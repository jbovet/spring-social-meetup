/**
 * 
 */
package org.springframework.social.meetup.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.meetup.api.Meetup;
import org.springframework.social.meetup.api.UserOperations;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;

/**
 * @author josebovet
 * 
 */
public class MeetupTemplate extends AbstractOAuth1ApiBinding implements Meetup {

	private UserOperations userOperations;

	public MeetupTemplate() {
		super();
		initSubApis();
	}

	/**
	 * @param consumerKey
	 * @param consumerSecret
	 * @param accessToken
	 * @param accessTokenSecret
	 */
	public MeetupTemplate(String consumerKey, String consumerSecret,String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		initSubApis();
	}

	@Override
	public UserOperations userOperations() {
		return userOperations;
	}

	private void initSubApis() {
		this.userOperations = new UserTemplate(getRestTemplate(),isAuthorized());
	}

	@Override
	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = super.getJsonMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		// objectMapper.registerModule(new MeetupModule());
		converter.setObjectMapper(objectMapper);
		return converter;
	}
}