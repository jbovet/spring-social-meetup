/**
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.meetup.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.meetup.api.MemberProfile;
import org.springframework.social.meetup.api.MemberServicesProfile;
import org.springframework.social.meetup.api.MemberTopicProfile;

public class UserTemplateTest extends BaseTemplateTest {

    @Test
    public void testGetMember() throws Exception {

        mockServer
                .expect(requestTo("https://api.meetup.com/2/member/14146581"))
                .andExpect(method(GET))
                .andRespond(
                        withSuccess(jsonResource("get-user"),
                                MediaType.APPLICATION_JSON));

        MemberProfile profile = meetup.userOperations().getUserProfile(14146581L);

        assertEquals("Jose Patricio Bovet Derpich", profile.getName());
        assertEquals(14146581L, profile.getId());
        assertEquals("MeetupFan!",profile.getBio());
        assertEquals("cl", profile.getCountry());
        assertEquals("Santiago", profile.getCity());
        assertEquals("Santiago", profile.getHometown());
        assertEquals("-33.459999084472656", profile.getLat());
        assertEquals("-70.63999938964844", profile.getLon());
        assertEquals("http://www.meetup.com/members/14146581", profile.getLink());
        assertEquals("en_US", profile.getLang());
        assertEquals("1299027458000", profile.getJoined());
        assertEquals("http://photos1.meetupstatic.com/photos/member/c/1/a/4/member_69049572.jpeg", profile.getPhoto().getLink());
        assertEquals("http://photos3.meetupstatic.com/photos/member/c/1/a/4/thumb_69049572.jpeg", profile.getPhoto().getThumbnail() );
        //assertEquals("1369673856000",profile.getVisited() );
        assertTrue(profile.getTopics().size()>0);
        
        //topics
        MemberTopicProfile topic = profile.getTopics().iterator().next();
        assertEquals("Agile Software Development",topic.getName());
        assertEquals("agile-software-development",topic.getUrlkey());
        assertTrue(topic.getId().equals(50223L));

        //services
        assertTrue(profile.getServices().size()>0);
        MemberServicesProfile service = profile.getServices().iterator().next();
        assertEquals("@josebovet",service.getIdentifier());
        assertEquals("twitter",service.getName());
    }
}
