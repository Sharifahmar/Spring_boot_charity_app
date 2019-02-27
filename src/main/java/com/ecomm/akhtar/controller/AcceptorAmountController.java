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
import com.ecomm.akhtar.model.AcceptorAmountModel;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.service.AcceptorAmountServiceInf;

/**
 * @author Ahmar
 *
 */
@RestController
public class AcceptorAmountController {

	@Autowired
	private AcceptorAmountServiceInf acceptorAmountServiceInf;

	@PostMapping(EcommUriConstants.ACCEPTOR_AMOUNT)
	public ResponseEntity<ApiResponseModel> addDonationAmount(
			@Valid @RequestBody AcceptorAmountModel acceptorAmountModel) {

		try {
			String msg = acceptorAmountServiceInf.addAcceptorAmountService(acceptorAmountModel);

			return new ResponseEntity<>(new ApiResponseModel(msg, true), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(new ApiResponseModel("Error Occured while saving Amount..!!", false), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
