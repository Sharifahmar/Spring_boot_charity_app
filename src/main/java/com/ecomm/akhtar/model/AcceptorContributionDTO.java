/**
 * 
 */
package com.ecomm.akhtar.model;

import java.text.SimpleDateFormat;

/**
 * @author Ahmar
 *
 */
public class AcceptorContributionDTO {

	private Long acceptorAmountId;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String email;

	private String address;

	private String tokenNumber;

	private String donationType;

	private Long donationTypeId;

	private String acceptorAmount;

	private java.util.Date date;

	public AcceptorContributionDTO(Long donationAmountId, String firstName, String lastName, String phoneNumber,
			String email, String address, String tokenNumber, String donationType, Long donationTypeId,
			String donationAmount, java.util.Date date) {
		super();
		this.acceptorAmountId = donationAmountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.tokenNumber = tokenNumber;
		this.donationType = donationType;
		this.donationTypeId = donationTypeId;
		this.acceptorAmount = donationAmount;
		this.date = date;
	}

	public AcceptorContributionDTO() {
		super();

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

	public Long getDonationTypeId() {
		return donationTypeId;
	}

	public void setDonationTypeId(Long donationTypeId) {
		this.donationTypeId = donationTypeId;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public Long getAcceptorAmountId() {
		return acceptorAmountId;
	}

	public void setAcceptorAmountId(Long acceptorAmountId) {
		this.acceptorAmountId = acceptorAmountId;
	}

	public String getAcceptorAmount() {
		return acceptorAmount;
	}

	public void setAcceptorAmount(String acceptorAmount) {
		this.acceptorAmount = acceptorAmount;
	}

	public String getDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(this.getDate());
	}

}
