package com.sarudr.openaiservice.service;

import java.util.Collections;

import org.springframework.stereotype.Service;

import com.sarudr.openaiservice.model.ChatGPTRequest;
import com.sarudr.openaiservice.model.ChatGPTResponse;
import com.sarudr.openaiservice.model.ChatRequest;
import com.sarudr.openaiservice.model.Message;
import com.sarudr.openaiservice.model.TranscriptionRequest;
import com.sarudr.openaiservice.model.WhisperTranscriptionRequest;
import com.sarudr.openaiservice.model.WhisperTranscriptionResponse;
import com.sarudr.openaiservice.openaicilent.OpenAIClient;
import com.sarudr.openaiservice.openaicilent.OpenAIClientConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpenAIClientService {

	private final OpenAIClient openAIClient;
	private final OpenAIClientConfig openAIClientConfig;

	private final static String ROLE_USER = "user";

	public ChatGPTResponse chat(ChatRequest chatRequest) {
		Message message = Message.builder().role(ROLE_USER).content(chatRequest.getQuestion()).build();
		ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder().model(openAIClientConfig.getModel())
				.messages(Collections.singletonList(message)).build();
		return openAIClient.chat(chatGPTRequest);
	}

	public WhisperTranscriptionResponse createTranscription(TranscriptionRequest transcriptionRequest) {
		WhisperTranscriptionRequest whisperTranscriptionRequest = WhisperTranscriptionRequest.builder()
				.model(openAIClientConfig.getAudioModel()).file(transcriptionRequest.getFile()).build();
		return openAIClient.createTranscription(whisperTranscriptionRequest);
	}
}
