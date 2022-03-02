package com.co.jsonschemagenerator.generator;

import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfig;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonSchemaGenerator
{

	private SchemaGenerator generator;

	public JsonSchemaGenerator(String schemaVersion)
	{
		SchemaVersion version = SchemaVersion.DRAFT_7;
		if (schemaVersion != null)
		{
			version = SchemaVersion.valueOf(schemaVersion);
		}
		SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(version, OptionPreset.PLAIN_JSON);
		SchemaGeneratorConfig config = configBuilder.build();
		generator = new SchemaGenerator(config);
	}

	public void generate(Class<?> clazz)
	{

		JsonNode jsonSchema = generator.generateSchema(clazz);

		FileWriter writer;
		try
		{
			writer = new FileWriter(clazz.getName() + ".json");
			writer.write(jsonSchema.toString());
			writer.close();
		}
		catch (IOException e)
		{
			log.error("Json Schema couldn't be generated: " + e.getMessage());
		}

	}

}
