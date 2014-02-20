package org.okbqa.querygeneration.model;


import org.codehaus.jackson.annotate.JsonProperty;

public class NamedEntity {
	@JsonProperty("var")
	private String variable;

	@JsonProperty("type")
	private String type;

	@JsonProperty("value")
	private String value;

	@JsonProperty("score")
	private double score;
	
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("NamedEntity Start\n");
		sb.append("variable=" + getVariable() + "\n");
		sb.append("type=" + getType() + "\n");
		sb.append("value=" + getValue() + "\n");
		sb.append("score=" + getScore() + "\n");
		sb.append("NamedEntity End\n");
		return sb.toString();
	}
}
