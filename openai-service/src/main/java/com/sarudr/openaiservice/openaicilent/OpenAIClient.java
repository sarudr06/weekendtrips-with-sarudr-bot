package com.sarudr.openaiservice.openaicilent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sarudr.openaiservice.model.ChatGPTRequest;
import com.sarudr.openaiservice.model.ChatGPTResponse;
import com.sarudr.openaiservice.model.WhisperTranscriptionRequest;
import com.sarudr.openaiservice.model.WhisperTranscriptionResponse;

@FeignClient(name = "openai-service", url = "${openai-service.urls.base-url}", configuration = OpenAIClientConfig.class)
public interface OpenAIClient {

	@PostMapping(value = "${openai-service.urls.chat-url}", headers = { "Content-Type=application/json" })
	ChatGPTResponse chat(@RequestBody ChatGPTRequest chatGPTRequest);

	@PostMapping(value = "${openai-service.urls.create-transcription-url}", headers = {
			"Content-Type=multipart/form-data" })
	WhisperTranscriptionResponse createTranscription(
			@ModelAttribute WhisperTranscriptionRequest whisperTranscriptionRequest);
}
