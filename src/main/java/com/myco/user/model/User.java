package com.myco.user.model;



import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Document(indexName = "userinformation_elasticsearch")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Field(type = FieldType.Keyword, name = "id")
	private String id;

	@Field(type = FieldType.Text, name = "firstName")
	private String firstName;

	@Field(type = FieldType.Text, name = "lastName")
	private String lastName;

	@Field(type = FieldType.Text, name = "email")
	private String email;

	@Field(type = FieldType.Long, name = "mobile")
	private long mobile;

	@Field(type = FieldType.Text, name = "gender")
	private String gender;
	
	@Field(type = FieldType.Date, name = "created")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created;
	
	@Field(type = FieldType.Date, name = "updated")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", email=" + email + ", gender=" + gender + ", created=" + created + ", updated=" + updated + "]";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdate() {
		return updated;
	}
	public void setUpdate(Date updated) {
		this.updated = updated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
