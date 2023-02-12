package com.example.smart_contact_manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.smart_contact_manager.exceptions.UsernameAlreadyExistException;
import com.example.smart_contact_manager.presentation.UserDetail;
import com.example.smart_contact_manager.presentation.requests.LoginRequest;
import com.example.smart_contact_manager.presentation.responses.Response;
import com.example.smart_contact_manager.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("user-details")
	public UserDetail getUserDetails(@RequestParam String userId){
		UserDetail userDetail= userService.getUserDetails(userId);
		return userDetail;
	}

	@PutMapping("update-details")
	public String updateUserDetails (@RequestBody UserDetail request){
		boolean updated=userService.updateUserDetails(request);
		return "details updated";
	}

	@PostMapping("add-user")
	public Response addUser(@RequestBody UserDetail userDetail) throws UsernameAlreadyExistException {
		userService.addUser(userDetail);
		return new Response("user added");
	}

	@DeleteMapping ("delete-user")
	public String deleteUser(@RequestParam String  userId){

		return "user deleted";
	}

	@PostMapping("/login")
	public Response loginUser(@RequestBody LoginRequest loginRequest){
		var response= userService.userAuthentication(loginRequest);
		return response;
	}
}
