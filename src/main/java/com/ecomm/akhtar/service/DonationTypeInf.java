package com.ecomm.akhtar.service;

import org.springframework.stereotype.Service;

import com.ecomm.akhtar.model.DonationTypeModel;

@Service
public interface DonationTypeInf {

	Boolean existsByDonationType(String donationType);

	DonationTypeModel findById(Long donationTypeId);
	
	
	

}
