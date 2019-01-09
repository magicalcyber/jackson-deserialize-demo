package com.magicalcyber.demo.jackson.deserialize;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@PostMapping("/hello")
	public ResponseEntity<RequestDto> hello(@Valid @RequestBody RequestDto requestDto) {
		return ResponseEntity.ok(requestDto);
	}
}
