package org.springframework.social.meetup.api;

import java.io.Serializable;

public class MeetupMemberProfile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private final long id;
	
	private final String userName;
	
	private final String userPhotoUrl;
	
	private String city;
	
	private String country;
	
	private String lat;
	
	private String lon;
	
	private String link;
	
	private String joined;
	
	private String email;
	
	public MeetupMemberProfile(long id, String userName, String userPhotoUrl) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPhotoUrl = userPhotoUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getJoined() {
		return joined;
	}

	public void setJoined(String joined) {
		this.joined = joined;
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPhotoUrl() {
		return userPhotoUrl;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
}