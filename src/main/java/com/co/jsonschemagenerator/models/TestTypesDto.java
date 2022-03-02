package com.co.jsonschemagenerator.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TestTypesDto implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -680996837223788859L;

	@JsonProperty(required = false)
	private String stringNotRequired;

	@JsonProperty(required = true)
	private String stringRequired;

	@JsonProperty(required = false)
	private Boolean booleanNotRequired;

	@JsonProperty(required = true)
	private Boolean booleanRequired;

	@JsonProperty(required = false)
	private Double numberNotRequired;

	@JsonProperty(required = true)
	private Double numberRequired;

	@JsonProperty(required = false)
	private Integer integerNotRequired;

	@JsonProperty(required = true)
	private Integer integerRequired;

	@JsonProperty(required = false)
	private List<Integer> arrayNotRequired;

	@JsonProperty(required = true)
	private List<Integer> arrayRequired;

	@JsonProperty(required = false)
	private LocalDateTime localDateTimeNotRequired;

	@JsonProperty(required = true)
	private LocalDateTime localDateTimeRequired;
}
