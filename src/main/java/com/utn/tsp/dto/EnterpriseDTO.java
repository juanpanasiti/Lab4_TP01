package com.utn.tsp.dto;

import java.io.Serializable;

/*
 * @author Juan M. Panasiti
 */

public class EnterpriseDTO implements Serializable{
	// Attributes
	private int id;
	private String designation;
	private String phone;
	private String attention_time;
	private String about_us;
	private double latitude;
	private double longitude;
	private String address;
	private String email;

	// Constructors
	public EnterpriseDTO(String designation, String phone, String attention_time, String about_us, double latitude,
			double longitude, String address, String email) {
		super();
		this.designation = designation;
		this.phone = phone;
		this.attention_time = attention_time;
		this.about_us = about_us;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
		this.email = email;
	}

	public EnterpriseDTO() {
		super();
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAttention_time() {
		return attention_time;
	}

	public void setAttention_time(String attention_time) {
		this.attention_time = attention_time;
	}

	public String getAbout_us() {
		return about_us;
	}

	public void setAbout_us(String about_us) {
		this.about_us = about_us;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
