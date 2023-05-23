package com.feuji.weekendtrip.convertor;

import java.io.IOException;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class InstantTimeSerializer extends JsonSerializer<Instant> {

	@Override
	public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeNumber(value.toEpochMilli());
	}

}
