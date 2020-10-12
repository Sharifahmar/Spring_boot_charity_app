package com.ecomm.akhtar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomm.akhtar.model.Acceptor;

@Service
public interface AcceptorServiceInf {

	Boolean existsByPhoneNumber(String phoneNumber);

	Acceptor findById(Long acceptorId);

	Acceptor updateAcceptor(Acceptor acceptor);

	List<Acceptor> searchCriteria(Acceptor acceptor);
	
	
	

}
