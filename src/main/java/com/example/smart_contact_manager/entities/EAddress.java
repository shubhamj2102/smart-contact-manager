package com.example.smart_contact_manager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
public class EAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;

	@Column(name="city")
	public String city;
}
