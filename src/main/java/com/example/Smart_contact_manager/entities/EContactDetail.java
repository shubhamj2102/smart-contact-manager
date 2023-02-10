package com.example.Smart_contact_manager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="contact_detail")
@Getter
@Setter
public class EContactDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@Column(name="first_name",nullable = false)
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="contact_number",nullable = false,unique = true)
	private String contactNumber;

	@Column(name="email")
	private String email;

	@Column(name="work")
	private String work;

	@Column(name="notes")
	private String notes;

	@ManyToOne
	@JoinColumn(name="user_id")
	private EUser eUser;
}
