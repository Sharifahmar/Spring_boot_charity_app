package com.ecomm.akhtar.service;

import org.springframework.stereotype.Service;

import com.ecomm.akhtar.model.Acceptor;

@Service
public interface AcceptorServiceInf {

	Boolean existsByPhoneNumber(String phoneNumber);

	Boolean existsByEmailId(String email);

	Acceptor findById(Long acceptorId);

	Acceptor updateAcceptor(Acceptor acceptor);
	
	
	

}
