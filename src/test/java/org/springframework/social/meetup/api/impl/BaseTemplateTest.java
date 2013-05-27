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

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.web.client.MockRestServiceServer;

public class BaseTemplateTest {

    protected MeetupTemplate meetup;
    protected MockRestServiceServer mockServer;

    public BaseTemplateTest() {
        super();
    }

    @Before
    public void setUp() {

        meetup = new MeetupTemplate("consumerKey", "consumerSecret","accessToken", "accessTokenSecret");
        mockServer = MockRestServiceServer.createServer(meetup.getRestTemplate());
    }

    protected Resource jsonResource(String filename) {
        return new ClassPathResource(filename + ".json", getClass());
    }
}