/**
 * 
 */
package com.ecomm.akhtar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.exception.CustomException;
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
	public ResponseEntity<ApiResponseModel> addDonationAmount(@RequestBody AcceptorAmountModel acceptorAmountModel) {

		try {
			AcceptorAmountModel msg = acceptorAmountServiceInf.addAcceptorAmountService(acceptorAmountModel);

			if (!ObjectUtils.isEmpty(msg)) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ApiResponseModel("Acceptor Donation Amount Insert Successfully..!!", true));
			}

		} catch (CustomException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseModel(e.getMessage(), e.getSuccess()));

		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseModel("Something went wrong.!!", false));

	}

}
