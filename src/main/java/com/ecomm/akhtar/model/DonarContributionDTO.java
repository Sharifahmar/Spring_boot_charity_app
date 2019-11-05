/**
 * 
 */
package com.ecomm.akhtar.model;

import java.text.SimpleDateFormat;

/**
 * @author Ahmar
 *
 */
public class DonarContributionDTO {

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String email;

	private String donationType;

	private Long donationTypeValue;

	private String donationAmount;

	private java.util.Date date;
	

	public DonarContributionDTO(String firstName, String lastName, String phoneNumber, String email,
			String donationType, Long donationTypeValue, String donationAmount, java.util.Date date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.donationType = donationType;
		this.donationTypeValue = donationTypeValue;
		this.donationAmount = donationAmount;
		this.date = date;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public Long getDonationTypeValue() {
		return donationTypeValue;
	}

	public void setDonationTypeValue(Long donationTypeValue) {
		this.donationTypeValue = donationTypeValue;
	}

	public String getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(String donationAmount) {
		this.donationAmount = donationAmount;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void Date(java.util.Date date) {
		this.date = date;
	}
	
	public String getDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		return formatter.format(this.getDate());
	}

}
