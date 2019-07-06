/**
 * 
 */
package com.ecomm.akhtar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.repository.DonarsRepository;

/**
 * @author Ahmar
 *
 */
@Component
public class DonarServiceImpl implements DonarServiceInf {

	@Autowired
	private DonarsRepository donarsRepository;

	@Override
	public Boolean existsByPhoneNumber(String phoneNumber) {
		return !donarsRepository.existsByPhoneNumber(phoneNumber);
	}

	@Override
	public Boolean existsByEmailId(String email) {
		return !donarsRepository.existsByEmail(email);
	}

}
