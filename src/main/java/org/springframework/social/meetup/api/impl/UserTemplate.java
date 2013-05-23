/**
 * 
 */
package org.springframework.social.meetup.api.impl;

import java.util.List;

import org.springframework.social.meetup.api.MeetupMemberProfile;
import org.springframework.social.meetup.api.UserOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author josebovet
 *
 */
public class UserTemplate extends AbstractMeetupOperations implements UserOperations {

	private final RestTemplate restTemplate;
	
	public UserTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
	}

	@Override
	public long getProfileId() {
		return 0;
	}

	@Override
	public String getScreenName() {
		return null;
	}

	@Override
	public MeetupMemberProfile getUserProfile() {
		return null;
	}

	@Override
	public MeetupMemberProfile getUserProfile(String screenName) {
		return null;
	}

	@Override
	public MeetupMemberProfile getUserProfile(long userId) {
		return null;
	}

	@Override
	public List<MeetupMemberProfile> getUsers(long... userIds) {
		return null;
	}

	@Override
	public List<MeetupMemberProfile> getUsers(String... screenNames) {
		return null;
	}
}