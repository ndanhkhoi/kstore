package com.ndanhkhoi.entity;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name = "PRODUCT")
public class Product{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORYID")
	private Category category;
	
	private Long price;
	private String os;
	private String screen;
	private String frontCamera;
	private String backCamera;
	private String cpu;
	private Float ram;
	private Float rom;
	private String battery;
	private String security;
	private String color;
	private String description;
	private int number;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<OrderDetail> orderDetails;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<Import> imports;

	public Product() {
	}


	public Product(String name, Category category, Long price, String os, String screen, String frontCamera, String backCamera,
			String cpu, Float ram, Float rom, String battery, String security, String color, String description) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.os = os;
		this.screen = screen;
		this.frontCamera = frontCamera;
		this.backCamera = backCamera;
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.battery = battery;
		this.security = security;
		this.color = color;
		this.description = description;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return this.price;
	}
	
	public String getPriceString(){
		Locale localeVN = new Locale("vi", "VN");
	    NumberFormat vn = NumberFormat.getCurrencyInstance(localeVN);
		return vn.format(price);
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getScreen() {
		return this.screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getFrontCamera() {
		return this.frontCamera;
	}

	public void setFrontCamera(String frontCamera) {
		this.frontCamera = frontCamera;
	}

	public String getBackCamera() {
		return this.backCamera;
	}

	public void setBackCamera(String backCamera) {
		this.backCamera = backCamera;
	}

	public String getCpu() {
		return this.cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public Float getRam() {
		return this.ram;
	}

	public void setRam(Float ram) {
		this.ram = ram;
	}

	public Float getRom() {
		return this.rom;
	}

	public void setRom(Float rom) {
		this.rom = rom;
	}

	public String getBattery() {
		return this.battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getSecurity() {
		return this.security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public List<Import> getImports() {
		return imports;
	}


	public void setImports(List<Import> imports) {
		this.imports = imports;
	}
	
	
}
