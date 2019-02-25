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
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.service.DonarSlipDetailsServiceInf;

/**
 * @author Ahmar
 *
 */
@RestController
public class DonarSlipDetailsController {

	@Autowired
	private DonarSlipDetailsServiceInf donarSlipDetailsServiceInf;

	@PostMapping(EcommUriConstants.DONAR_SLIP_DETAILS)
	public ResponseEntity<ApiResponseModel> addDonarSlipDetails(@Valid @RequestBody Users users) {

		try {
			String msg = donarSlipDetailsServiceInf.addDonarSlipDetailsService(users);

			return new ResponseEntity<>(new ApiResponseModel(msg, true), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(new ApiResponseModel("Error Occured while generating slip..!!", false),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
