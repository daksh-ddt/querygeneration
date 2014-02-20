package org.okbqa.querygeneration.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Payload {
	@JsonProperty("pseudoquery")
	private PseudoQuery PseudoQuery;
	
	@JsonProperty("disambiguationresult")
	private DisambiguationResult disambiguationResult;
	
	public PseudoQuery getPseudoQuery() {
		return PseudoQuery;
	}

	public void setPseudoQuery(PseudoQuery pseudoQuery) {
		PseudoQuery = pseudoQuery;
	}


	public DisambiguationResult getDisambiguationResult() {
		return disambiguationResult;
	}

	public void setDisambiguationResult(DisambiguationResult disambiguationResult) {
		this.disambiguationResult = disambiguationResult;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Payload Start\n");
		sb.append("pseudoquery=" + getPseudoQuery() + "\n");
		sb.append("disambiguationresult=" + getDisambiguationResult() + "\n");
		sb.append("Payload End\n");
		return sb.toString();
	}
}
