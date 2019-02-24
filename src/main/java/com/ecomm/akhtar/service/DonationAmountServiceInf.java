package com.ecomm.akhtar.service;

import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.DonationAmountModel;

public interface DonationAmountServiceInf {

	public String addDonationAmountService(DonationAmountModel value) throws CustomException;

}