package com.example.smart_contact_manager.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.smart_contact_manager.entities.EAddress;
import com.example.smart_contact_manager.entities.EContactDetail;
import com.example.smart_contact_manager.entities.EUser;

public final class ContactDataBuilder {
	private ContactDataBuilder() {
	}

	public static EContactDetail with(ContactDetail contactDetails){
		var eContactDetail=new EContactDetail();
		eContactDetail.setFirstName(contactDetails.getFirstName());
		eContactDetail.setLastName(contactDetails.getLastName());
		eContactDetail.setEmail(contactDetails.getEmail());
		eContactDetail.setWork(contactDetails.getWork());
		eContactDetail.setNotes(contactDetails.getNotes());
		eContactDetail.setContactNumber(contactDetails.getContactNumber());
		eContactDetail.setEUser(getUserDetails(contactDetails.getUserDetail()));
		return eContactDetail;
	}

	private static EUser getUserDetails(UserDetail userDetail) {
		var eUser=new EUser();

		if(Objects.isNull(userDetail)){
			return eUser;
		}

		eUser.setUserId(userDetail.getUserId());
		eUser.setUsername(userDetail.getUsername());
		eUser.setEmail(userDetail.getEmail());
		eUser.setFirstName(userDetail.getFirstName());
		eUser.setLastName(userDetail.getLastName());
		eUser.setEAddress(getAddress(userDetail.getAddress()));
		eUser.setPassword(userDetail.getPassword());
		return eUser;
	}

	public static ContactList with(Iterable<EContactDetail> itList) {
		var contactList=new ContactList();
		List<ContactDetail> contactDetails= new ArrayList<>();
		itList.forEach(eContact->{
			var contactDetail=getContactDetails(eContact);
			contactDetails.add(contactDetail);
		});
		contactList.setContactDetails(contactDetails);
		return contactList;
	}

	private static ContactDetail getContactDetails(EContactDetail eContact) {
		var contactDetails=new ContactDetail();
		if(Objects.isNull(eContact)){
			return contactDetails;
		}
		contactDetails.setContactNumber(eContact.getContactNumber());
		contactDetails.setWork(eContact.getWork());
		contactDetails.setNotes(eContact.getNotes());
		contactDetails.setEmail(eContact.getEmail());
		contactDetails.setLastName(eContact.getLastName());
		contactDetails.setFirstName(eContact.getFirstName());
		return contactDetails;
	}

	public static void with(EContactDetail eContactDetail, ContactDetail contactDetail) {
		eContactDetail.setNotes(contactDetail.getNotes());
		eContactDetail.setContactNumber(contactDetail.getContactNumber());
		eContactDetail.setWork(contactDetail.getWork());
		eContactDetail.setEmail(contactDetail.getEmail());
		eContactDetail.setFirstName(contactDetail.getFirstName());
		eContactDetail.setLastName(contactDetail.getLastName());
	}
	private static EAddress getAddress(Address address) {
		var eAddress=new EAddress();
		if(Objects.isNull(address)){
			return eAddress;
		}
		eAddress.setCity(address.getCity());
		return eAddress;
	}
}
