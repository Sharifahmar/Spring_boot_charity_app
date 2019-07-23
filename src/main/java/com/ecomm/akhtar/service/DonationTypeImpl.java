/**
 * 
 */
package com.ecomm.akhtar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.repository.DonationTypeRepository;

/**
 * @author Ahmar
 *
 */
@Component
public class DonationTypeImpl implements DonationTypeInf {

	@Autowired
	private DonationTypeRepository donationTypeRepository;

	@Override
	public Boolean existsByDonationType(String donationType) {
		return !donationTypeRepository.existsByDonationType(donationType);
	}



}
