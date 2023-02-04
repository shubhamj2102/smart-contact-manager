package com.example.Smart_contact_manager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Smart_contact_manager.entities.EUser;
import com.example.Smart_contact_manager.presentation.UserDetail;

@Repository
public interface UserJpaRespository extends CrudRepository<EUser,String> {
	EUser findByUserId(String userId);
	EUser findByUsername(String username);
}
