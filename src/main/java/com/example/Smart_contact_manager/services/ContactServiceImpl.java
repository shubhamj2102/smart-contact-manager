package com.example.Smart_contact_manager.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Smart_contact_manager.presentation.ContactDataBuilder;
import com.example.Smart_contact_manager.presentation.ContactDetail;
import com.example.Smart_contact_manager.presentation.ContactList;
import com.example.Smart_contact_manager.repositories.ContactDetailsJpaRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactDetailsJpaRepository contactDetailsJpaRepository;

	@Override
	public void addContactDetails(ContactDetail contactDetails) throws Exception {
		var contactNumber=contactDetails.getContactNumber();
		var eContact= contactDetailsJpaRepository.findByContactNumber(contactNumber);
		if(Objects.nonNull(eContact)){
			throw new Exception("contact already exist !");
		}
		var eContactDetail= ContactDataBuilder.with(contactDetails);
		contactDetailsJpaRepository.save(eContactDetail);
	}

	@Override
	public ContactList getContactList(){
		var itList=contactDetailsJpaRepository.findAll();
		var contactList= ContactDataBuilder.with(itList);
		return contactList;
	}

	@Override
	public void deleteContact(String contactNumber){
		var eContact= contactDetailsJpaRepository.findByContactNumber(contactNumber);
		contactDetailsJpaRepository.delete(eContact);
	}

	@Override
	public void updateContact(ContactDetail contactDetail){
		var contactNumber=contactDetail.getContactNumber();
		var eContactDetail=contactDetailsJpaRepository.findByContactNumber(contactNumber);
		if(Objects.nonNull(eContactDetail)){
			ContactDataBuilder.with(eContactDetail,contactDetail);
			contactDetailsJpaRepository.save(eContactDetail);
		}
		else{
			var eContactDetail1=ContactDataBuilder.with(contactDetail);
			contactDetailsJpaRepository.save(eContactDetail1);
		}
	}
}
