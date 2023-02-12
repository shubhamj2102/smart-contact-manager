package com.example.smart_contact_manager.presentation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetail {
	private String userId;
	private String firstName;
	private String lastName;
	private Address address;
	private String email;
	private String username;
	private String password;
}
