package com.sarudr.openaiservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Choice implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer index;
    private Message message;
    @JsonProperty("finish_reason")
    private String finishReason;
}
