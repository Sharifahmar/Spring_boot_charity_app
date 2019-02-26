/**
 * 
 */
package com.ecomm.akhtar.model;

/**
 * @author Ahmar
 *
 */
public class AcceptorAmountModel {

	private Acceptor acceptor;

	private DonationTypeModel donationTypeModel;
	
	private String donationAmount;

	public Acceptor getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(Acceptor acceptor) {
		this.acceptor = acceptor;
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
