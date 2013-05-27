/**
 * 
 */
package org.springframework.social.meetup.api.impl;

import org.springframework.social.MissingAuthorizationException;

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

    protected String buildUrl(String string) {
        return API_URL_BASE + string;
    }
	
	private static final String API_URL_BASE = "https://api.meetup.com/2";
}