package com.example.smart_contact_manager.presentation.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
	private String message;

	public Response(String message) {
		this.message = message;
	}
}
