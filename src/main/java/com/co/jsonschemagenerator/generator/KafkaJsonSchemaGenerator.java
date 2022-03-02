package com.co.jsonschemagenerator.generator;

import java.io.FileWriter;
import java.io.IOException;

import io.confluent.kafka.schemaregistry.json.JsonSchema;
import io.confluent.kafka.schemaregistry.json.JsonSchemaUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KafkaJsonSchemaGenerator extends AbstractJsonSchemaGenerator
{
	public KafkaJsonSchemaGenerator()
	{

	}

	@Override
	public void generate(Object object)
	{
		Class<?> cls = object.getClass();
		String className = cls.getSimpleName();

		try
		{
			log.info("Generating " + className + " Json Schema ");
			JsonSchema jsonSchema = JsonSchemaUtils.getSchema(object);

			FileWriter writer = new FileWriter(className + ".json");
			writer.write(jsonSchema.toString());
			writer.close();
		}
		catch (IOException e)
		{
			log.error("Json Schema couldn't be generated: " + e.getMessage());
		}
		log.info(className + " Json Schema generated");
	}
}
