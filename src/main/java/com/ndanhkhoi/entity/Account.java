package com.ndanhkhoi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "ACCOUNT")
public class Account{

	@Id
	private String username;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROFILEID", nullable = false)
	private Profile profile;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLEID", nullable = false)
	private Roles roles;
	
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	List<Log> logs;
	

	public Account() {
	}

	public Account(String username, Profile profile, Roles roles, String password) {
		this.username = username;
		this.profile = profile;
		this.roles = roles;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}
	
	

}
