package com.ecomm.akhtar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.ecomm.akhtar.audit.AuditModel;

@Entity
@Table(name = "DONARS", uniqueConstraints = { @UniqueConstraint(columnNames = { "EMAIL_ID" }),
		@UniqueConstraint(columnNames = { "PHONE" }) })
public class DonarsEntity extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814595115801146324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DONARS_ID")
	private Long donarId;

	@Email
	@Size(max = 100)
	@Column(name = "EMAIL_ID", nullable = false)
	private String email;

	@Size(max = 100)
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Size(max = 100)
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "ADDRESS", columnDefinition = "TEXT")
	private String address;

	@Size(max = 100)
	@Column(name = "CITY")
	private String city;

	@Size(max = 100)
	@Column(name = "STATE")
	private String state;

	@Size(max = 100)
	@Column(name = "COUNTRY")
	private String country;

	@Size(max = 100)
	@Column(name = "ZIPCODE")
	private String zipCode;

	@Size(max = 100)
	@Column(name = "PHONE", nullable = false)
	private String phoneNumber;

	@Column(name = "DONAR_STS", columnDefinition = "BIT", nullable = false)
	private Boolean status;

	public Long getDonarId() {
		return donarId;
	}

	public void setDonarId(Long donarId) {
		this.donarId = donarId;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
