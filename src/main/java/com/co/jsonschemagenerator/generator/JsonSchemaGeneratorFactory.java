package com.co.jsonschemagenerator.generator;

public class JsonSchemaGeneratorFactory
{

	public static final String DEFAULT_GENERATOR = "JsonSchemaGenerator";
	public static final String JSON_SCHEMA_GENERATOR = "JsonSchemaGenerator";
	public static final String KAFKA_JSON_SCHEMA_GENERATOR = "KafkaJsonSchemaGenerator";

	public AbstractJsonSchemaGenerator generator(String className, String... args)
	{
		switch (className)
		{
		case JSON_SCHEMA_GENERATOR:
			return newJsonSchemaGenerator();
		case KAFKA_JSON_SCHEMA_GENERATOR:
			return KafkaJsonSchemaGenerator();
		default:
			throw new IllegalArgumentException("not a valid className");
		}

	}

	public JsonSchemaGenerator newJsonSchemaGenerator()
	{
		return new JsonSchemaGenerator(null);
	}

	public KafkaJsonSchemaGenerator KafkaJsonSchemaGenerator()
	{
		return new KafkaJsonSchemaGenerator();
	}

}
