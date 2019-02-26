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
import com.ecomm.akhtar.model.Acceptor;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.service.AcceptorTokenServiceInf;

/**
 * @author Ahmar
 *
 */
@RestController
public class AcceptorTokenController {

	@Autowired
	private AcceptorTokenServiceInf acceptorTokenServiceInf;

	@PostMapping(EcommUriConstants.ACCEPTOR_TOKEN)
	public ResponseEntity<ApiResponseModel> addAcceptorTokenDetails(@Valid @RequestBody Acceptor acceptor) {

		try {
			String msg = acceptorTokenServiceInf.addAcceptorTokenService(acceptor);

			return new ResponseEntity<>(new ApiResponseModel(msg, true), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(new ApiResponseModel("Error Occured while generating slip..!!", false),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
