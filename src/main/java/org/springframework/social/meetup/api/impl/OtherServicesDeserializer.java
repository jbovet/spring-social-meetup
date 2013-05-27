package org.springframework.social.meetup.api.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.meetup.api.MemberServicesProfile;

public class OtherServicesDeserializer extends JsonDeserializer<List<MemberServicesProfile>> {

	@Override
	public List<MemberServicesProfile> deserialize(JsonParser jp,DeserializationContext ctxt) throws IOException,JsonProcessingException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		Iterator<Entry<String, JsonNode>> fields = node.getFields();
		List<MemberServicesProfile> serviceList = new ArrayList<MemberServicesProfile>();
		MemberServicesProfile  serviceProfile = null;
		while (fields.hasNext()) {
			Map.Entry<String,JsonNode> entry = (Map.Entry<String,JsonNode>) fields.next();
			serviceProfile = new MemberServicesProfile();
			serviceProfile.setName(entry.getKey());
			serviceProfile.setIdentifier(entry.getValue().get("identifier").getTextValue());
			serviceList.add(serviceProfile);
		}
		return serviceList;
	}
}