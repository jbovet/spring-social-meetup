/**
 * 
 */
package org.springframework.social.meetup.api.impl;

import java.util.List;

import org.springframework.social.meetup.api.MemberProfile;
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
	public MemberProfile getUserProfile() {
		return null;
	}

	@Override
	public MemberProfile getUserProfile(String screenName) {
		return null;
	}

	@Override
	public MemberProfile getUserProfile(long userId) {
		return restTemplate.getForObject(buildUrl("/member/{userId}"),MemberProfile.class,String.valueOf(userId));
	}

	@Override
	public List<MemberProfile> getUsers(long... userIds) {
		return null;
	}

	@Override
	public List<MemberProfile> getUsers(String... screenNames) {
		return null;
	}
}