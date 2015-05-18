package com.easynutrition.api.rest.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ApiRestSerializerCalendar extends JsonSerializer<Calendar> {

	@Override
	public void serialize(Calendar value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(value.getTime());
		jgen.writeString(formattedDate);
	}

}
