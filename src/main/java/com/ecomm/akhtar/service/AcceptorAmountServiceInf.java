package com.ecomm.akhtar.service;

import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.AcceptorAmountModel;

public interface AcceptorAmountServiceInf {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecomm.akhtar.service.DonationAmountServiceInf#addDonationAmountService(
	 * com.ecomm.akhtar.model.DonationAmountModel)
	 */
	AcceptorAmountModel addAcceptorAmountService(AcceptorAmountModel value) throws CustomException;

}