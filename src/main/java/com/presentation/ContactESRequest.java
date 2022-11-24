package com.presentation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactESRequest {
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String email;
	private String work;
}
