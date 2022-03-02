package com.co.jsonschemagenerator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.co.jsonschemagenerator.generator.AbstractJsonSchemaGenerator;
import com.co.jsonschemagenerator.generator.JsonSchemaGeneratorFactory;
import com.co.jsonschemagenerator.models.TestTypesDto;

@SpringBootApplication
public class JsonSchemaGeneratorApplication implements CommandLineRunner
{

	public static void main(String[] args)
	{
		SpringApplication.run(JsonSchemaGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args)
	{
		String clazz = JsonSchemaGeneratorFactory.DEFAULT_GENERATOR;
		String schemaVersion = null;
		if (args.length == 1)
		{
			clazz = args[0];
		}
		else if (args.length > 1)
		{
			clazz = args[0];
			schemaVersion = args[1];
		}

		JsonSchemaGeneratorFactory factory = new JsonSchemaGeneratorFactory();

		AbstractJsonSchemaGenerator generator = factory.generator(clazz, schemaVersion);
		generator.generate(new TestTypesDto());
	}

}
