package com.co.jsonschemagenerator.generator;

import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfig;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;
import com.github.victools.jsonschema.generator.impl.module.ConstantValueModule;
import com.github.victools.jsonschema.generator.impl.module.FlattenedOptionalModule;
import com.github.victools.jsonschema.generator.impl.module.SimpleTypeModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonSchemaGenerator extends AbstractJsonSchemaGenerator
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
		configBuilder.with(new ConstantValueModule());
		configBuilder.with(new FlattenedOptionalModule());
		configBuilder.with(new SimpleTypeModule());
		SchemaGeneratorConfig config = configBuilder.build();
		generator = new SchemaGenerator(config);
	}

	@Override
	public void generate(Object object)
	{

		Class<?> cls = object.getClass();
		log.info("Generating Json Schema...");
		JsonNode jsonSchema = generator.generateSchema(cls);

		try
		{
			FileWriter writer = new FileWriter(cls.getName() + ".json");
			writer.write(jsonSchema.toString());
			writer.close();
		}
		catch (IOException e)
		{
			log.error("Json Schema couldn't be generated: " + e.getMessage());
		}

		log.info("Json Schema generated");

	}

}
