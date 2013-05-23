/**
 * 
 */
package org.springframework.social.meetup.api;

import org.springframework.social.ApiBinding;

/**
 *  Basic set of operations for interacting with Meetup.
 *	Implemented by MeetupTemplate.
 * @author josebovet
 *
 */
public interface Meetup extends ApiBinding {

	/***
	 *  Returns user operations from meetup API
	 */
	UserOperations userOperations();
	
}
