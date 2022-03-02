package com.co.jsonschemagenerator.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.ToString;

@JsonPropertyOrder
@Data
@ToString
public class TestTypesDto implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -680996837223788859L;

	@JsonProperty(required = false)
	@Nullable
	private String stringNotRequired;

	@JsonProperty(required = true)
	@NotNull
	private String stringRequired;

	@JsonProperty(required = false)
	private Boolean booleanNotRequired;

	@JsonProperty(required = true)
	@NotNull
	private Boolean booleanRequired;

	@JsonProperty(required = false)
	private Double numberNotRequired;

	@JsonProperty(required = true)
	@NotNull
	private Double numberRequired;

	@JsonProperty(required = false)
	private Integer integerNotRequired;

	@JsonProperty(required = true)
	@NotNull
	private Integer integerRequired;

	@JsonProperty(required = false)
	private List<Integer> arrayNotRequired;

	@JsonProperty(required = true)
	@NotNull
	private List<Integer> arrayRequired;

	@JsonProperty(required = false)
	private LocalDateTime localDateTimeNotRequired;

	@JsonProperty(required = true)
	@NotNull
	private LocalDateTime localDateTimeRequired;
}
