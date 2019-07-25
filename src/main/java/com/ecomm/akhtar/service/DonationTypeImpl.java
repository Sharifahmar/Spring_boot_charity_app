/**
 * 
 */
package com.ecomm.akhtar.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.entity.DonarsEntity;
import com.ecomm.akhtar.entity.DonationTypeEntity;
import com.ecomm.akhtar.model.DonationTypeModel;
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

	@Override
	public DonationTypeModel findById(Long donationTypeId) {
		DonationTypeModel donationTypeModel = new DonationTypeModel();
		Optional<DonationTypeEntity> donationTypeEntity = donationTypeRepository.findById(donationTypeId);
		if (donationTypeEntity.isPresent()) {
			donationTypeEntity.get().setStatus(false);
			DonationTypeEntity donationTypeEntityNew = donationTypeRepository.save(donationTypeEntity.get());
			BeanUtils.copyProperties(donationTypeEntityNew, donationTypeModel);
		}
		return donationTypeModel;

	}

}
