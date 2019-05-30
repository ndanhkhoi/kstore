package com.ndanhkhoi.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "ROLES")
public class Roles {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	
	private String name;
	private String code;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private List<Account> accounts;

	public Roles() {
	}

	public Roles(String name, List<Account> accounts) {
		this.name = name;
		this.accounts = accounts;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
