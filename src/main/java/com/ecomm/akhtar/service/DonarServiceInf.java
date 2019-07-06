package com.ecomm.akhtar.service;

import org.springframework.stereotype.Service;

@Service
public interface DonarServiceInf {

	Boolean existsByPhoneNumber(String phoneNumber);

	Boolean existsByEmailId(String email);

}
