package com.example.Smart_contact_manager.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Smart_contact_manager.entities.EUser;
import com.example.Smart_contact_manager.presentation.UserDataBuilder;
import com.example.Smart_contact_manager.presentation.UserDetail;
import com.example.Smart_contact_manager.repositories.AddressJpaRepository;
import com.example.Smart_contact_manager.repositories.UserJpaRespository;

@Service
public class UserSericeImpl implements UserService{

	@Autowired
	private UserJpaRespository userJpaRespository;

	@Autowired
	private AddressJpaRepository addressJpaRepository;

	@Override
	public UserDetail getUserDetails(String userId){
		EUser eUser=userJpaRespository.findByUserId(userId);
		UserDetail userDetail= UserDataBuilder.with(eUser);
		return userDetail;
	}

	@Override
	public boolean updateUserDetails(UserDetail request){
		//todo
		return true;
	}

	@Override
	public boolean addUser(UserDetail userDetail) throws Exception {
		EUser eUser= UserDataBuilder.with(userDetail);
		var eUser1=userJpaRespository.findByUsername(userDetail.getUsername());
		if(Objects.isNull(eUser1)){
			addressJpaRepository.save(eUser.getEAddress());
			userJpaRespository.save(eUser);
			return true;
		}
		throw new Exception("username already exist");
	}
}
