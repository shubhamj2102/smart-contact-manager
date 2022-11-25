package com.example.Smart_contact_manager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Smart_contact_manager.entities.EContactDetail;

@Repository
public interface ContactDetailsJpaRepository extends CrudRepository<EContactDetail,String> {
	EContactDetail findByContactNumber(String contactNumber);
	void deleteByContactNumber(String contactNumber);
}
