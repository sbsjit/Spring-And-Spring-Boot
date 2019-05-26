package com.sushree.sahayatri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Bean using Getters and Setters

@Entity
@Table(name="User")
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="Name")
	@NotBlank
	private String name;
	
	@Column(name="Phone")
	@NotBlank
	private String phone;
	
	@Column(name="Email")
	@NotBlank
	private String email;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Username")
	@NotBlank
	private String username;
	
	@Column(name="Password")
	@NotBlank
	private String password;
	
	@Column(name="VerifiedStatus")
	@NotBlank
	private Boolean verifiedStatus;
	
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "userGroupId")
	private UserGroup userGroup;

	
	
	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getVerifiedStatus() {
		return verifiedStatus;
	}

	public void setVerifiedStatus(Boolean verifiedStatus) {
		this.verifiedStatus = verifiedStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
