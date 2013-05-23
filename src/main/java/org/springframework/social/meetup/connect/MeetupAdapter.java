package org.springframework.social.meetup.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.meetup.api.Meetup;
import org.springframework.social.meetup.api.MeetupMemberProfile;

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
		MeetupMemberProfile profile = meetup.userOperations().getUserProfile();
		values.setProviderUserId(String.valueOf(profile.getId()));
		values.setDisplayName(profile.getUserName());
		values.setProfileUrl(profile.getLink());
		values.setImageUrl(profile.getUserPhotoUrl());
	}

	@Override
	public UserProfile fetchUserProfile(Meetup meetup) {
		MeetupMemberProfile userProfile = meetup.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(userProfile.getUserName()).setEmail(userProfile.getEmail()).build();
	}

	@Override
	public void updateStatus(Meetup meetup, String message) {
		throw new UnsupportedOperationException("updateStatus() method is not supported!!!");
	}
}