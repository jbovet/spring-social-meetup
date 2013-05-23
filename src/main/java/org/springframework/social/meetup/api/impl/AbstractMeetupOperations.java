/**
 * 
 */
package org.springframework.social.meetup.api.impl;

import java.net.URI;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author josebovet
 *
 */
public class AbstractMeetupOperations {
	
	private final boolean isAuthorized;

	public AbstractMeetupOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException();
		}
	}

	protected URI buildUri(String path) {
		return buildUri(path, EMPTY_PARAMETERS);
	}

	protected URI buildUri(String path, String parameterName, String parameterValue) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set(parameterName, parameterValue);
		return buildUri(path, parameters);
	}

	protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
		return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
	}

	private static final String API_URL_BASE = "https://api.meetup.com/";

	private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();
}