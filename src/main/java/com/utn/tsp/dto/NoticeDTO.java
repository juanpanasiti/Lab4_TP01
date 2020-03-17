package com.utn.tsp.dto;

import java.io.Serializable;
import java.time.LocalDate;
import com.utn.tsp.dto.EnterpriseDTO;

/*
 * @author Juan M. Panasiti
 */

public class NoticeDTO implements Serializable {

	//Attributes
		private int id;
		private String title; 
		private String summary;
		private String image;
		private String html_content;
		private char published;
		private LocalDate publication_date;
		private EnterpriseDTO enterpriseDto;
		
		//Constructors
		public NoticeDTO() {
			
		}

		public NoticeDTO(int id, String title, String summary, String image, String html_content, char published,
				LocalDate publication_date, EnterpriseDTO enterpriseDto) {
			this.id = id;
			this.title = title;
			this.summary = summary;
			this.image = image;
			this.html_content = html_content;
			this.published = published;
			this.publication_date = publication_date;
			this.enterpriseDto = enterpriseDto;
		}

		//Getters and Setter
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getHtml_content() {
			return html_content;
		}

		public void setHtml_content(String html_content) {
			this.html_content = html_content;
		}

		public char getPublished() {
			return published;
		}

		public void setPublished(char published) {
			this.published = published;
		}

		public LocalDate getPublication_date() {
			return publication_date;
		}

		public void setPublication_date(LocalDate publication_date) {
			this.publication_date = publication_date;
		}

		public EnterpriseDTO getEnterprise() {
			return enterpriseDto;
		}

		public void setEnterprise(EnterpriseDTO enterpriseDto) {
			this.enterpriseDto = enterpriseDto;
		}
		
}
