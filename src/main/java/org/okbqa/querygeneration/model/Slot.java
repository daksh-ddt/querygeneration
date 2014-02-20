package org.okbqa.querygeneration.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Slot {
	
	@JsonProperty("s")
	private String subject;
	
	@JsonProperty("p")
	private String predicate;

	@JsonProperty("o")
	private String object;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPredicate() {
		return predicate;
	}

	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Slot Start\n");
		sb.append("subject=" + getSubject() + "\n");
		sb.append("predicate=" + getPredicate() + "\n");
		sb.append("object=" + getObject() + "\n");
		sb.append("Slot End\n");
		return sb.toString();
	}
}
