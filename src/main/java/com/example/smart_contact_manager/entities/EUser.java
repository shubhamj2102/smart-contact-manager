package com.example.smart_contact_manager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class EUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@Column(name="user_id")
	private String userId;

	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;

	@JoinColumn (name="address_id")
	@OneToOne
	private EAddress eAddress;

	@Column(name="email")
	private String email;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
}
