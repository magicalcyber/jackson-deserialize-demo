package com.magicalcyber.demo.jackson.deserialize;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PostDeserializer extends JsonDeserializer<Post> {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public Post deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.readValueAsTree();

		if (node.asText().isEmpty()) {
			throw new RuntimeException("cannot empty object");
		}
		return objectMapper.readValue(node.asText(), Post.class);
	}

}
