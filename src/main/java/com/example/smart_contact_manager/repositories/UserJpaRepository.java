package com.example.smart_contact_manager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.smart_contact_manager.entities.EUser;

@Repository
public interface UserJpaRepository extends CrudRepository<EUser,Long> {
	EUser findByUserId(String userId);
	EUser findByUsername(String username);
}
