package com.magicalcyber.demo.jackson.deserialize;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class AllowNullNotEmpty extends JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = p.readValueAsTree();
		if (node.asText().isEmpty()) {
			throw new RuntimeException("cannot be empty");
		}
		return new BigDecimal(node.toString());
	}

}
