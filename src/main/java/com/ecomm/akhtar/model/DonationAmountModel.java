/**
 * 
 */
package com.ecomm.akhtar.model;

/**
 * @author Ahmar
 *
 */
public class DonationAmountModel {

	
	private Donars donars;

	private DonationTypeModel donationTypeModel;
	
	private String donationAmount;

	public Donars getDonars() {
		return donars;
	}

	public void setDonars(Donars donars) {
		this.donars = donars;
	}

	public DonationTypeModel getDonationTypeModel() {
		return donationTypeModel;
	}

	public void setDonationTypeModel(DonationTypeModel donationTypeModel) {
		this.donationTypeModel = donationTypeModel;
	}

	public String getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(String donationAmount) {
		this.donationAmount = donationAmount;
	}

	

	

}
