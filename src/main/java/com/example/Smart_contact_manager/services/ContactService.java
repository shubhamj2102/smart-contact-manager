package com.example.Smart_contact_manager.services;

import com.example.Smart_contact_manager.presentation.ContactDetail;
import com.example.Smart_contact_manager.presentation.ContactList;

public interface ContactService {
	void addContactDetails(ContactDetail contactDetails) throws Exception;
	ContactList getContactList();
	void deleteContact(String contactNumber);

	void updateContact(ContactDetail contactDetail);
}
