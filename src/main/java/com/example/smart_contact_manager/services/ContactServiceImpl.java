package com.example.smart_contact_manager.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smart_contact_manager.presentation.ContactDataBuilder;
import com.example.smart_contact_manager.presentation.ContactDetail;
import com.example.smart_contact_manager.presentation.ContactList;
import com.example.smart_contact_manager.repositories.AddressJpaRepository;
import com.example.smart_contact_manager.repositories.ContactDetailsJpaRepository;
import com.example.smart_contact_manager.repositories.UserJpaRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactDetailsJpaRepository contactDetailsJpaRepository;

	@Autowired
	private UserJpaRepository userJpaRespository;

	@Autowired
	private AddressJpaRepository addressJpaRepository;

	@Override
	public void addContactDetails(ContactDetail contactDetails) throws Exception {
		var contactNumber=contactDetails.getContactNumber();
		var eContact= contactDetailsJpaRepository.findByContactNumber(contactNumber);
		if(Objects.nonNull(eContact)){
			throw new Exception("contact already exist !");
		}
		var eContactDetail= ContactDataBuilder.with(contactDetails);
		var eUser = eContactDetail.getEUser();
		addressJpaRepository.save(eUser.getEAddress());
		userJpaRespository.save(eUser);
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
			userJpaRespository.save(eContactDetail.getEUser());
			contactDetailsJpaRepository.save(eContactDetail);
		}
		else{
			var eContactDetail1=ContactDataBuilder.with(contactDetail);
			contactDetailsJpaRepository.save(eContactDetail1);
		}
	}
}
