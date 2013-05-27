package org.springframework.social.meetup.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberTopicProfile {
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String urlkey;
	
	@JsonProperty
	private String name;

	public Long getId() {
		return id;
	}

	public String getUrlkey() {
		return urlkey;
	}

	public String getName() {
		return name;
	}

}