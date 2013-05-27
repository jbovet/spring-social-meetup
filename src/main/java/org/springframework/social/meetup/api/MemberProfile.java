package org.springframework.social.meetup.api;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.meetup.api.impl.OtherServicesDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberProfile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty
	private long id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String bio;
	
	@JsonProperty
	private MemberPhotoProfile photo;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private String country;
	
	@JsonProperty
	private String hometown;
	
	@JsonProperty
	private String lang;
	
	@JsonProperty
	private String lat;
	
	@JsonProperty
	private String lon;
	
	@JsonProperty
	private String link;
	
	@JsonProperty
	private String joined;
	
	@JsonProperty
	private String visited;
	
	@JsonProperty
	private String email;
	
	@JsonProperty
	private List<MemberTopicProfile> topics;

	@JsonProperty("other_services")
    @JsonDeserialize(using = OtherServicesDeserializer.class)
	private List<MemberServicesProfile> services;
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public MemberPhotoProfile getPhoto() {
		return photo;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getLat() {
		return lat;
	}

	public String getLon() {
		return lon;
	}

	public String getLink() {
		return link;
	}

	public String getJoined() {
		return joined;
	}

	public String getEmail() {
		return email;
	}
	
	public String getLang() {
		return lang;
	}
	public String getVisited() {
		return visited;
	}
	
	public String getBio() {
		return bio;
	}
	public String getHometown() {
		return hometown;
	}
	public List<MemberTopicProfile> getTopics() {
		return topics;
	}
	public List<MemberServicesProfile> getServices() {
		return services;
	}
}