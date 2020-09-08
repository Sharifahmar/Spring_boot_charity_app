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
	
	private String acceptorAmount;
	
	private String tokenNumber;

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

	public String getAcceptorAmount() {
		return acceptorAmount;
	}

	public void setAcceptorAmount(String acceptorAmount) {
		this.acceptorAmount = acceptorAmount;
	}

	public String getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(String tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	
}
