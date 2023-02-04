package com.example.Smart_contact_manager.presentation;

import com.example.Smart_contact_manager.entities.EAddress;
import com.example.Smart_contact_manager.entities.EUser;

public final class UserDataBuilder {
	private UserDataBuilder() {
	}
	public static UserDetail with(EUser eUser) {
		var userDetail=new UserDetail();
		userDetail.setUserId(eUser.getUserId());
		userDetail.setEmail(eUser.getEmail());
		userDetail.setAddress(getAddress(eUser.getEAddress()));
		userDetail.setUsername(eUser.getUsername());
		userDetail.setPassword("******");
		userDetail.setFirstName(eUser.getFirstName());
		userDetail.setLastName(eUser.getLastName());
		return userDetail;
	}

	private static Address getAddress(EAddress eAddress) {
		Address address=new Address();
		address.setCity(eAddress.getCity());
		return address;
	}

	public static EUser with(UserDetail userDetail){
		var eUser=new EUser();
		eUser.setUserId(userDetail.getUserId());
		eUser.setEmail(userDetail.getEmail());
		eUser.setUsername(userDetail.getUsername());
		eUser.setFirstName(userDetail.getFirstName());
		eUser.setPassword(userDetail.getPassword());
		eUser.setLastName(userDetail.getLastName());
		eUser.setEAddress(getAddress(userDetail.getAddress()));
		return eUser;
	}

	private static EAddress getAddress(Address address) {
		var eAddress=new EAddress();
		eAddress.setCity(address.getCity());
		return eAddress;
	}

}
