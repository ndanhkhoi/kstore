package com.ndanhkhoi.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "IMPORT")
public class Import {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long stt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCTID", nullable = false)
	private Product product;

	private String importDate;
	private int number;
	
	public Import(){
	}

	public Import(Product product, int number) {
		this.product = product;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		this.importDate = dtf.format(localDate).toString();
		this.number = number;
	}

	public long getStt() {
		return stt;
	}

	public void setStt(long stt) {
		this.stt = stt;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getImportDay() {
		return importDate;
	}

	public void setImportDay(String importDate) {
		this.importDate = importDate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	

}
