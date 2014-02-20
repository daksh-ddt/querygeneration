package org.okbqa.querygeneration.model;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonProperty;

public class PseudoQuery {
	
	@JsonProperty("query")
	private String query;

	@JsonProperty("slots")
	private Slot[] slots;
	
	@JsonProperty("score")
	private double score;
	
	@JsonProperty("question")
	private String question;
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Slot[] getSlots() {
		return slots;
	}
	public void setSlots(Slot[] slots) {
		this.slots = slots;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PseudoQuery Start\n");
		sb.append("question=" + getQuestion() + "\n");
		sb.append("slots=" + Arrays.toString(getSlots()) + "\n");
		sb.append("score=" + getScore() + "\n");
		sb.append("PseudoQuery End\n");
		return sb.toString();
	}
}
