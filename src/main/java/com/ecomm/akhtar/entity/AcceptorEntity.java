package com.ecomm.akhtar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.ecomm.akhtar.audit.AuditModel;

@Entity
@Table(name = "ACCEPTOR", uniqueConstraints = { @UniqueConstraint(columnNames = { "PHONE" }) })
public class AcceptorEntity extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814595115801146324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCEPTOR_ID")
	private Long acceptorId;

	@Size(max = 256)
	@Column(name = "FULL_NAME")
	private String fullName;

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

	@Column(name = "PROFILE_PICTURE", columnDefinition = "TEXT")
	private String profilePicture;

	@Column(name = "PROFILE_PICTURE_URL", columnDefinition = "TEXT")
	private String profilePictureUrl;

	@Column(name = "ACCEPTOR_STS", columnDefinition = "BIT", nullable = false)
	private Boolean status;

	public Long getAcceptorId() {
		return acceptorId;
	}

	public void setAcceptorId(Long acceptorId) {
		this.acceptorId = acceptorId;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

}
