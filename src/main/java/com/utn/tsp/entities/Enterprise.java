package com.utn.tsp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * @author Juan M. Panasiti
 */
@Entity
@Table(name = "lab4tp01_enterprise")
public class Enterprise implements Serializable {

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
	public Enterprise() {

	}

	public Enterprise(String designation, String phone, String attention_time, String about_us, double latitude,
			double longitude, String address, String email) {

		this.designation = designation;
		this.phone = phone;
		this.attention_time = attention_time;
		this.about_us = about_us;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
		this.email = email;
	}

	// Getters and Setters
	@Id
	@Column(name = "enterprise_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "enterprise_designation", length = 128)
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "enterprise_phone", length = 50)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "enterprise_attention_time", length = 256)
	public String getAttention_time() {
		return attention_time;
	}

	public void setAttention_time(String attention_time) {
		this.attention_time = attention_time;
	}

	@Column(name = "enterprise_about_us", length = 1024)
	public String getAbout_us() {
		return about_us;
	}

	public void setAbout_us(String about_us) {
		this.about_us = about_us;
	}

	@Column(name = "enterprise_latitude")
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "enterprise_longitude")
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Column(name = "enterprise_address", length = 256)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "enterprise_email", length = 75)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
