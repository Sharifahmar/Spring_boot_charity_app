/**
 * 
 */
package com.ecomm.akhtar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.model.DonationAmountModel;
import com.ecomm.akhtar.service.DonationAmountServiceInf;

/**
 * @author Ahmar
 *
 */
@RestController
public class DonationAmountController {

	@Autowired
	private DonationAmountServiceInf donationAmountServiceInf;

	@PostMapping(EcommUriConstants.DONATION_AMOUNT)
	public ResponseEntity<ApiResponseModel> addDonationAmount(
			@Valid @RequestBody DonationAmountModel donationAmountModel) {

		try {
			String msg = donationAmountServiceInf.addDonationAmountService(donationAmountModel);

			return new ResponseEntity<>(new ApiResponseModel(msg, true), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(new ApiResponseModel("Error Occured while saving Amount..!!", false), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
