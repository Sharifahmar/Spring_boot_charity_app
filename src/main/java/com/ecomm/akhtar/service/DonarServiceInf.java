package com.ecomm.akhtar.service;

import org.springframework.stereotype.Service;

import com.ecomm.akhtar.model.Donars;

@Service
public interface DonarServiceInf {

	Boolean existsByPhoneNumber(String phoneNumber);

	Boolean existsByEmailId(String email);

	Donars findById(Long donarId);
	
	
	

}
