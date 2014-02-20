package org.okbqa.querygeneration.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Query {
	@JsonProperty("query")
	private String query;

	@JsonProperty("score")
	private double score;
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
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
		sb.append("Query Start\n");
		sb.append("query=" + getQuery() + "\n");
		sb.append("score=" + getScore() + "\n");
		sb.append("Query End\n");
		return sb.toString();
	}
}
