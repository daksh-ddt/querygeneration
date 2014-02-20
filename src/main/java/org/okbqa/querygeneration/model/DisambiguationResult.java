package org.okbqa.querygeneration.model;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonProperty;

public class DisambiguationResult {
	@JsonProperty("question")
	private String question;
	
	@JsonProperty("ned")
	private NamedEntityCombination[] namedEntityCombinations;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public NamedEntityCombination[] getNamedEntityCombinations() {
		return namedEntityCombinations;
	}
	public void setNamedEntityCombinations(NamedEntityCombination[] namedEntityCombinations) {
		this.namedEntityCombinations = namedEntityCombinations;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DisambiguationResult Start\n");
		sb.append("question=" + getQuestion() + "\n");
		sb.append("named entity combination=" + Arrays.toString(getNamedEntityCombinations()) + "\n");
		sb.append("DisambiguationResult End\n");
		return sb.toString();
	}
}
