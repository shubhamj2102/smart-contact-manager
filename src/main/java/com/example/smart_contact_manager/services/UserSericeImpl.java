package com.example.smart_contact_manager.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smart_contact_manager.entities.EUser;
import com.example.smart_contact_manager.exceptions.UserNotFoundException;
import com.example.smart_contact_manager.exceptions.UsernameAlreadyExistException;
import com.example.smart_contact_manager.presentation.UserDataBuilder;
import com.example.smart_contact_manager.presentation.UserDetail;
import com.example.smart_contact_manager.presentation.requests.LoginRequest;
import com.example.smart_contact_manager.presentation.responses.Response;
import com.example.smart_contact_manager.repositories.AddressJpaRepository;
import com.example.smart_contact_manager.repositories.UserJpaRepository;

import lombok.SneakyThrows;

@Service
public class UserSericeImpl implements UserService{

	@Autowired
	private UserJpaRepository userJpaRespository;

	@Autowired
	private AddressJpaRepository addressJpaRepository;

	@SneakyThrows
	@Override
	public UserDetail getUserDetails(String userId){
		EUser eUser=userJpaRespository.findByUserId(userId);
		if(Objects.isNull(eUser)){
			throw new UserNotFoundException("user not found");
		}
		UserDetail userDetail= UserDataBuilder.with(eUser);
		return userDetail;
	}

	@Override
	public boolean updateUserDetails(UserDetail request){
		//todo
		return true;
	}

	@Override
	public boolean addUser(UserDetail userDetail) throws UsernameAlreadyExistException {
		EUser eUser= UserDataBuilder.with(userDetail);
		var eUser1=userJpaRespository.findByUsername(userDetail.getUsername());
		if(Objects.isNull(eUser1)){
			addressJpaRepository.save(eUser.getEAddress());
			userJpaRespository.save(eUser);
			return true;
		}
		throw new UsernameAlreadyExistException("username already exist");
	}

	@Override
	public Response userAuthentication(LoginRequest loginRequest){
		String username=loginRequest.getUsername();
		var eUser=userJpaRespository.findByUsername(username);
		if(Objects.isNull(eUser)){
			return new Response("username doesn't exist");
		}
		var requestPassword=loginRequest.getPassword();
		var password=eUser.getPassword();
		if(requestPassword.equals(password)){
			return new Response("login success");
		}
		return new Response("wrong password");
	}
}
