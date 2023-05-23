package com.sarudr.openaiservice.model;
import java.io.Serializable;

import lombok.Data;

@Data
public class ChatRequest implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String question;
}