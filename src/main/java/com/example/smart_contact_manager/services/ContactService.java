package com.example.smart_contact_manager.services;

import com.example.smart_contact_manager.presentation.ContactDetail;
import com.example.smart_contact_manager.presentation.ContactList;

public interface ContactService {
	void addContactDetails(ContactDetail contactDetails) throws Exception;
	ContactList getContactList();
	void deleteContact(String contactNumber);

	void updateContact(ContactDetail contactDetail);
}
