package com.example.Smart_contact_manager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Smart_contact_manager.entities.EAddress;

@Repository
public interface AddressJpaRepository extends CrudRepository<EAddress,String> {

}
