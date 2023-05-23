package com.sarudr.openaiservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarudr.openaiservice.model.ChatGPTResponse;
import com.sarudr.openaiservice.model.ChatRequest;
import com.sarudr.openaiservice.model.TranscriptionRequest;
import com.sarudr.openaiservice.model.WhisperTranscriptionResponse;
import com.sarudr.openaiservice.service.OpenAIClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/openai")
public class OpenAIClientController {

	private final OpenAIClientService openAIClientService;

	@PostMapping(value = "/chat", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ChatGPTResponse chat(@RequestBody ChatRequest chatRequest) {
		System.out.println(chatRequest.getQuestion());
		return openAIClientService.chat(chatRequest);
	}

	@PostMapping(value = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public WhisperTranscriptionResponse createTranscription(@ModelAttribute TranscriptionRequest transcriptionRequest) {
		return openAIClientService.createTranscription(transcriptionRequest);
	}
}
