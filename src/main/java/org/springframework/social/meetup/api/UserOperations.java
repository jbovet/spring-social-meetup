package org.springframework.social.meetup.api;

import java.util.List;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;

/**
 * Interface for information operations  about Meetup users.
 * @author josebovet
 */
public interface UserOperations {

	/**
	 * Retrieves the authenticated user's ID.
	 * @return the user's ID
	 * @throws ApiException if there is an error while communicating with Meetup.
	 * @throws MissingAuthorizationException if MeetupTemplate was not created with OAuth credentials.
	 */
	long getProfileId();

	/**
	 * Retrieves the authenticated user's Meetup screen name
	 * @return the user's screen name
	 * @throws ApiException if there is an error while communicating with Meetup.
	 * @throws MissingAuthorizationException if MeetupTemplate was not created with OAuth credentials.
	 */
	String getScreenName();

	/**
	 * Retrieves the authenticated user's Meetup profile details.
	 * @return a {@link MemberProfile} object representing the user's profile.
	 * @throws ApiException if there is an error while communicating with Meetup.
	 * @throws MissingAuthorizationException if MeetupTemplate was not created with OAuth credentials.
	 */
	MemberProfile getUserProfile();

	/**
	 * Retrieves a specific user's Meetup profile details.
	 * Note that this method does not require authentication.
	 * @param screenName the screen name for the user whose details are to be retrieved.
	 * @return a {@link Meetup} object representing the user's profile.
	 * @throws ApiException if there is an error while communicating with Meetup.
	 * @throws MissingAuthorizationException if MeetupTemplate was not created with OAuth credentials.
	 */
	MemberProfile getUserProfile(String screenName);

	/**
	 * Retrieves a specific user's Meetup profile details.
	 * Note that this method does not require authentication.
	 * @param userId the user ID for the user whose details are to be retrieved.
	 * @return a {@link MemberProfile} object representing the user's profile.
	 * @throws ApiException if there is an error while communicating with Meetup.
	 * @throws MissingAuthorizationException if MeetupTemplate was not created with OAuth credentials.
	 */
	MemberProfile getUserProfile(long userId);

	/**
	 * Retrieves a list of Meetup profiles for the given list of user IDs.
	 * @throws ApiException if there is an error while communicating with Meetup.
	 * @throws MissingAuthorizationException if MeetupTemplate was not created with OAuth credentials.
	 */
	List<MemberProfile> getUsers(long... userIds);

	/**
	 * Retrieves a list of Meetup profiles for the given list of screen names.
	 * @throws ApiException if there is an error while communicating with Meetup.
	 * @throws MissingAuthorizationException if MeetupTemplate was not created with OAuth credentials.
	 */
	List<MemberProfile> getUsers(String... screenNames);
}