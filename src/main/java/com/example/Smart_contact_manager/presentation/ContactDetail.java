package com.example.Smart_contact_manager.presentation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDetail {

	private String firstName;
	private String lastName;
	private String contactNumber;
	private String email;
	private String work;
	private String notes;
	private UserDetail userDetail;
}
