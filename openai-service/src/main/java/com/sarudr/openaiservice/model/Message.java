package com.sarudr.openaiservice.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String role;
    private String content;
}