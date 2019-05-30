package com.ndanhkhoi.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "DISTRICT")
public class District {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROVINCEID")
	private Province province;

	private String name;
	private String prefix;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
	private List<Ward> wards;

	public District() {
	}

	public District(Province province, String name, String prefix, List<Ward> wards) {
		this.province = province;
		this.name = name;
		this.prefix = prefix;
		this.wards = wards;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public List<Ward> getWards() {
		return this.wards;
	}

	public void setWards(List<Ward> wards) {
		this.wards = wards;
	}

}
