package org.springframework.social.meetup.api;


public class MemberServicesProfile  {
	
	private String name;
	
	private String identifier;
	
	public String getName() {
		return name;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}