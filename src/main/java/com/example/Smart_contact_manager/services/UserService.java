package com.example.Smart_contact_manager.services;

import com.example.Smart_contact_manager.presentation.UserDetail;

public interface UserService {
	UserDetail getUserDetails(String userId);
	boolean updateUserDetails(UserDetail request);
	boolean addUser(UserDetail userDetail) throws Exception;
}
