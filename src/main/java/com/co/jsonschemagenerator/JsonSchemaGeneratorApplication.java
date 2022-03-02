package com.co.jsonschemagenerator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.co.jsonschemagenerator.generator.JsonSchemaGenerator;
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
		String schemaVersion = null;
		if (args.length > 0)
		{
			schemaVersion = args[0];
		}

		JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(schemaVersion);
		jsonSchemaGenerator.generate(TestTypesDto.class);
	}

}
