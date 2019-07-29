package com.ecomm.akhtar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.model.Acceptor;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.model.IdentityAvailability;
import com.ecomm.akhtar.model.UsersCheckRequest;
import com.ecomm.akhtar.service.AcceptorServiceInf;

@RestController
public class AcceptorController {

	@Autowired
	private AcceptorServiceInf acceptorServiceInf;

	@PostMapping(EcommUriConstants.ACCEPTOR_PHONENUMBER_EXIST_URI)
	public ResponseEntity<IdentityAvailability> checkUsernameAvailability(@RequestBody UsersCheckRequest acceptor) {
		Boolean isAvailable = acceptorServiceInf.existsByPhoneNumber(acceptor.getPhoneNumber());
		if (isAvailable) {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Phone Number not exist..!!"),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Phone Number already exist..!!"),
					HttpStatus.OK);
		}
	}

	@PostMapping(EcommUriConstants.ACCEPTOR_EMAIL_EXIST_URI)
	public ResponseEntity<IdentityAvailability> checkEmailAvailability(@RequestBody UsersCheckRequest acceptor) {
		Boolean isAvailable = acceptorServiceInf.existsByEmailId(acceptor.getEmail());
		if (isAvailable) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new IdentityAvailability(isAvailable, "Email not exist..!!"));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new IdentityAvailability(isAvailable, "Email already exist..!!"));
		}
	}
	
	
	@PostMapping(EcommUriConstants.UPDATE_ACCEPTOR_URI)
	public ResponseEntity<ApiResponseModel> updateDonar(@RequestBody Acceptor acceptor) {
		Acceptor acceptor2 = acceptorServiceInf.updateAcceptor(acceptor);
		if (!ObjectUtils.isEmpty(acceptor2)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseModel("Acceptor Updated Successfully..!!", true));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));
		}
	}
	
	

	@PostMapping(EcommUriConstants.DELETE_ACCEPTOR_URI)
	public ResponseEntity<ApiResponseModel> deleteAcceptor(@RequestBody Acceptor acceptor) {
		Acceptor acceptorNew = acceptorServiceInf.findById(acceptor.getAcceptorId());
		if (!ObjectUtils.isEmpty(acceptorNew)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseModel("Acceptor Deleted Successfully..!!", true));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));
		}
	}

	

}
