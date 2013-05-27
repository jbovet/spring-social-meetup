package org.springframework.social.meetup.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPhotoProfile {

	@JsonProperty("photo_link")
	private String link;

	@JsonProperty("thumb_link")
	private String thumbnail;

	@JsonProperty("photo_id")
	private String id;

	public String getLink() {
		return link;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public String getId() {
		return id;
	}
}