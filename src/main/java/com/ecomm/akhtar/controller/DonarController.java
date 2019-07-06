package com.ecomm.akhtar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.model.IdentityAvailability;
import com.ecomm.akhtar.model.UsersCheckRequest;
import com.ecomm.akhtar.service.DonarServiceInf;

@RestController
public class DonarController {

	@Autowired
	private DonarServiceInf donarServiceInf;



	@PostMapping(EcommUriConstants.DONAR_PHONENUMBER_EXIST_URI)
	public ResponseEntity<IdentityAvailability> checkUsernameAvailability(@RequestBody UsersCheckRequest donar) {
		Boolean isAvailable = donarServiceInf.existsByPhoneNumber(donar.getPhoneNumber());
		if (isAvailable) {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Phone Number not exist..!!"),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Phone Number already exist..!!"),
					HttpStatus.OK);
		}
	}

	@PostMapping(EcommUriConstants.DONAR_EMAIL_EXIST_URI)
	public ResponseEntity<IdentityAvailability> checkEmailAvailability(@RequestBody UsersCheckRequest donar) {
		Boolean isAvailable = donarServiceInf.existsByEmailId(donar.getEmail());
		if (isAvailable) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new IdentityAvailability(isAvailable, "Email not exist..!!"));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new IdentityAvailability(isAvailable, "Email already exist..!!"));
		}
	}


}
