package com.ecomm.akhtar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Donars;

@Service
public interface DonarServiceInf {

	Boolean existsByPhoneNumber(String phoneNumber);

	Donars findById(Long donarId);

	Donars updateDonar(Donars donar);

	List<Donars> searchCriteria(Donars donar);

	String donorBulkReceiptGenerate(List<Donars> donar) throws CustomException;
	
	
	

}
