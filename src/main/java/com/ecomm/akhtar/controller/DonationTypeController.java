package com.ecomm.akhtar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.model.DonationTypeModel;
import com.ecomm.akhtar.model.IdentityAvailability;
import com.ecomm.akhtar.service.DonationTypeInf;

@RestController
public class DonationTypeController {

	@Autowired
	private DonationTypeInf donationTypeInf;

	@PostMapping(EcommUriConstants.DONATION_TYPE_EXIST_URI)
	public ResponseEntity<IdentityAvailability> checkUsernameAvailability(@RequestBody DonationTypeModel donationTypeModel) {
		Boolean isAvailable = donationTypeInf.existsByDonationType(donationTypeModel.getDonationType());
		if (isAvailable) {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Donation Type is not exist..!!"),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Donation Type already exist..!!"),
					HttpStatus.OK);
		}
	}

}
