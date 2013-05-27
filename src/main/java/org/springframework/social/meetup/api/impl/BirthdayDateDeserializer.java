package org.springframework.social.meetup.api.impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class BirthdayDateDeserializer extends JsonDeserializer<Date> {
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)throws IOException, JsonProcessingException {
        Calendar calendar = GregorianCalendar.getInstance();
        while (jp.nextToken() != JsonToken.END_OBJECT) {
			if("month".equals(jp.getCurrentName()))
			{
				jp.nextToken();
				calendar.set(Calendar.MONTH,jp.getIntValue());
			}
			if("year".equals(jp.getCurrentName()))
			{
				jp.nextToken();
				calendar.set(Calendar.YEAR,jp.getIntValue());
			}
			if("day".equals(jp.getCurrentName()))
			{
				jp.nextToken();
				calendar.set(Calendar.DATE,jp.getIntValue());
			}
		}
        jp.close();
        System.out.println(calendar.getTime());
		return calendar.getTime();
	}
}