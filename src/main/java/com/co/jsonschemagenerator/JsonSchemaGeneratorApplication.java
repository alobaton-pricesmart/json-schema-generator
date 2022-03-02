package com.co.jsonschemagenerator;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.co.jsonschemagenerator.annotations.GenerateJsonSchemaAnnotationLoader;
import com.co.jsonschemagenerator.generator.AbstractJsonSchemaGenerator;
import com.co.jsonschemagenerator.generator.JsonSchemaGeneratorFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class JsonSchemaGeneratorApplication implements CommandLineRunner
{

	@Autowired
	private GenerateJsonSchemaAnnotationLoader loader;

	public static void main(String[] args)
	{
		SpringApplication.run(JsonSchemaGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args)
	{
		String cls = JsonSchemaGeneratorFactory.DEFAULT_GENERATOR;
		String pkg = GenerateJsonSchemaAnnotationLoader.DEFAULT_PKG;
		String schemaVersion = null;
		if (args.length == 1)
		{
			cls = args[0];
		}
		else if (args.length == 2)
		{
			cls = args[0];
			pkg = args[1];
		}
		else if (args.length == 3)
		{
			cls = args[0];
			pkg = args[1];
			schemaVersion = args[2];
		}

		JsonSchemaGeneratorFactory factory = new JsonSchemaGeneratorFactory();

		AbstractJsonSchemaGenerator generator = factory.generator(cls, schemaVersion);

		loader.load(pkg).stream().forEach(c -> {

			try
			{
				generator.generate(c.getConstructor().newInstance());
			}
			catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | InstantiationException
					| IllegalAccessException e)
			{
				log.error(c.getName() + " instance couldn't be created");
			}

		});

	}

}
