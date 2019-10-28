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

	@Override
	public DonationTypeModel updateDonationType(DonationTypeModel donationTypeModel) {
		DonationTypeEntity donationTypeEntity = new DonationTypeEntity();
		DonationTypeModel donationTypeModel2 = new DonationTypeModel();
		Optional<DonationTypeEntity> donationTypeEntityRtrn = donationTypeRepository
				.findById(donationTypeModel.getDonationTypeId());
		if (donationTypeEntityRtrn.isPresent()) {
			BeanUtils.copyProperties(donationTypeModel, donationTypeEntity);
			donationTypeEntity.setDonationType(donationTypeEntityRtrn.get().getDonationType());
			DonationTypeEntity donationTypeEntityNew = donationTypeRepository.save(donationTypeEntity);
			BeanUtils.copyProperties(donationTypeEntityNew, donationTypeModel2);
		}
		return donationTypeModel2;
	}

}
