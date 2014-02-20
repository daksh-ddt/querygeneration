package org.okbqa.querygeneration.model;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonProperty;

public class NamedEntityCombination {
	@JsonProperty("entities")
	private NamedEntity[] namedEntities;

	@JsonProperty("score")
	private double score;

	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public NamedEntity[] getNamedEntities() {
		return namedEntities;
	}
	public void setNamedEntities(NamedEntity[] namedEntities) {
		this.namedEntities = namedEntities;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("NamedEntityCombination Start\n");
		sb.append("named entities=" + Arrays.toString(getNamedEntities()) + "\n");
		sb.append("score=" + getScore() + "\n");
		sb.append("NamedEntityCombination End\n");
		return sb.toString();
	}
}
