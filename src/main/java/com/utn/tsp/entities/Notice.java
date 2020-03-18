package com.utn.tsp.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * @author Juan M. Panasiti
 */

@Entity
@Table(name = "lab4tp01_notice")
public class Notice implements Serializable {
	
	//Attributes
	private int id;
	private String title; 
	private String summary;
	private String image;
	private String html_content;
	private char published;
	private LocalDate publication_date;
	private Enterprise enterprise;
	
	//Constructors
	public Notice() {
		
	}

	public Notice(int id, String title, String summary, String image, String html_content, char published,
			LocalDate publication_date, Enterprise enterprise) {
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.image = image;
		this.html_content = html_content;
		this.published = published;
		this.publication_date = publication_date;
		this.enterprise = enterprise;
	}

	//Getters and Setter
	@Id
	@Column(name = "notice_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "notice_title", length = 128)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "notice_summary", length = 1024)
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "notice_image", length = 128)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "notice_html_content", length = 20480)
	public String getHtml_content() {
		return html_content;
	}

	public void setHtml_content(String html_content) {
		this.html_content = html_content;
	}

	@Column(name = "notice_published")
	public char getPublished() {
		char c = String.valueOf(published).toUpperCase().toCharArray()[0];
		if(c != 'Y') {
			c = 'N';
		}
		return c;
	}

	public void setPublished(char published) {
		char c = String.valueOf(published).toUpperCase().toCharArray()[0];
		if(c != 'Y') {
			c = 'N';
		}
		this.published = c;
	}

	@Column(name = "notice_publication_date")
	public LocalDate getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(LocalDate publication_date) {
		this.publication_date = publication_date;
	}

	@ManyToOne
	@JoinColumn(name = "notice_enterprise_id")
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	
	
	

}
