package com.co.jsonschemagenerator.annotations;

import java.util.Set;

import org.reflections.Reflections;
import org.springframework.stereotype.Component;

/**
 * Load the GenerateJsonSchema annotated classes.
 * 
 * @author alvaro.lobaton
 */
@Component
public class GenerateJsonSchemaAnnotationLoader
{
	
	public static final String DEFAULT_PKG = "com.co.jsonschemagenerator.models";

	/**
	 * Return the GenerateJsonSchema annotated classes of a package.
	 * 
	 * @param pkg
	 *          The package to lookup.
	 * @return The annotated classes.
	 */
	public Set<Class<?>> load(String pkg)
	{
		Reflections reflections = new Reflections(pkg);
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(GenerateJsonSchema.class);
		return annotated;

	}

}
