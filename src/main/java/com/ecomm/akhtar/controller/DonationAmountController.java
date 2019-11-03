package com.ecomm.akhtar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.exception.CustomException;
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
	public ResponseEntity<ApiResponseModel> addDonationAmount(@RequestBody DonationAmountModel donationAmountModel) {
		DonationAmountModel donationTypeModelRetrn = null;

		try {
			donationTypeModelRetrn = donationAmountServiceInf.addDonationAmountService(donationAmountModel);
			if (!ObjectUtils.isEmpty(donationTypeModelRetrn)) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ApiResponseModel("Donation Amount Insert Successfully..!!", true));
			}
		} catch (CustomException e) {
			   
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseModel(e.getMessage(), e.getSuccess()));

		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseModel("Something went wrong.!!", false));
	}
}
