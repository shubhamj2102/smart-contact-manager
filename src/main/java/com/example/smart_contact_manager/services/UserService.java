package com.example.smart_contact_manager.services;

import com.example.smart_contact_manager.exceptions.UsernameAlreadyExistException;
import com.example.smart_contact_manager.presentation.UserDetail;
import com.example.smart_contact_manager.presentation.requests.LoginRequest;
import com.example.smart_contact_manager.presentation.responses.Response;

public interface UserService {
	UserDetail getUserDetails(String userId);
	boolean updateUserDetails(UserDetail request);
	boolean addUser(UserDetail userDetail) throws UsernameAlreadyExistException;
	Response userAuthentication(LoginRequest loginRequest);
}
