package com.ndanhkhoi.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "PROFILE")
public class Profile {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WARDID", nullable = false)
	private Ward ward;

	private String fullname;
	private String gender;

	private String birthday;
	private String joindate;
	
	private String tel;
	private String idcardNumber;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
	private List<Bill> bills;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
	private List<OrderInfo> orderInfos;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "profile")
	Account account;

	public Profile() {
	}

	public Profile(Ward ward, String gender) {
		this.ward = ward;
		this.gender = gender;
	}

	public Profile(Ward ward, String fullname, String gender, String birthday, String tel, String idcardNumber,
			List<Bill> bills, List<OrderInfo> orderInfos, Account account) {
		this.ward = ward;
		this.fullname = fullname;
		this.gender = gender;
		this.birthday = birthday;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		this.joindate = dtf.format(localDate).toString();
		this.tel = tel;
		this.idcardNumber = idcardNumber;
		this.bills = bills;
		this.orderInfos = orderInfos;
		this.account = account;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ward getWard() {
		return this.ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdcardNumber() {
		return this.idcardNumber;
	}

	public void setIdcardNumber(String idcardNumber) {
		this.idcardNumber = idcardNumber;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public List<OrderInfo> getOrderInfos() {
		return this.orderInfos;
	}

	public void setOrderInfos(List<OrderInfo> orderInfos) {
		this.orderInfos = orderInfos;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

}
