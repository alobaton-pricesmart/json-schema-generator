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
		try
		{
			log.info("Generating Json Schema...");
			JsonSchema jsonSchema = JsonSchemaUtils.getSchema(object);

			Class<?> cls = object.getClass();
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
