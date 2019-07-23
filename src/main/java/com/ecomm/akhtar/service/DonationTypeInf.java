package com.ecomm.akhtar.service;

import org.springframework.stereotype.Service;

@Service
public interface DonationTypeInf {

	Boolean existsByDonationType(String donationType);
	
	
	

}
