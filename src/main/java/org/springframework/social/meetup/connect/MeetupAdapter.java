package org.springframework.social.meetup.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.meetup.api.Meetup;
import org.springframework.social.meetup.api.MemberProfile;

public class MeetupAdapter implements ApiAdapter<Meetup> {

	@Override
	public boolean test(Meetup meetup) {
		try {
			meetup.userOperations().getUserProfile();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	@Override
	public void setConnectionValues(Meetup meetup, ConnectionValues values) {
		MemberProfile profile = meetup.userOperations().getUserProfile();
		values.setProviderUserId(String.valueOf(profile.getId()));
		values.setDisplayName(profile.getName());
		values.setProfileUrl(profile.getLink());
		values.setImageUrl(profile.getPhoto().getLink());
	}

	@Override
	public UserProfile fetchUserProfile(Meetup meetup) {
		MemberProfile userProfile = meetup.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(userProfile.getName()).setEmail(userProfile.getEmail()).build();
	}

	@Override
	public void updateStatus(Meetup meetup, String message) {
		throw new UnsupportedOperationException("updateStatus() method is not supported!!!");
	}
}