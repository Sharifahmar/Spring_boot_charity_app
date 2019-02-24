/**
 * 
 */
package com.ecomm.akhtar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ecomm.akhtar.entity.DonationAmountEntity;
import com.ecomm.akhtar.entity.DonationTypeEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.DonationAmountModel;
import com.ecomm.akhtar.repository.DonationAmountRepository;
import com.ecomm.akhtar.repository.DonationTypeRepository;
import com.ecomm.akhtar.repository.UsersRepository;

/**
 * @author Ahmar
 *
 */
@Component
public class DonationAmountServiceImpl implements DonationAmountServiceInf {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private DonationTypeRepository donationTypeRepository;

	@Autowired
	private DonationAmountRepository donationAmountRepository;

	DonationAmountEntity donationAmountEntity = null;

	DonationAmountModel donationAmountModel = null;

	String message = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecomm.akhtar.service.DonationAmountServiceInf#addDonationAmountService(
	 * com.ecomm.akhtar.model.DonationAmountModel)
	 */
	@Override
	public String addDonationAmountService(DonationAmountModel value) throws CustomException {

		donationAmountEntity = new DonationAmountEntity();
		donationAmountModel = new DonationAmountModel();
		UsersEntity userData = userRepository.findByPhone(value.getUsers().getPhone())
				.orElseThrow(() -> new CustomException("User Data not found with specific Mobile Number..!", false));

		if (!ObjectUtils.isEmpty(userData)) {

			DonationTypeEntity donationTypeData = donationTypeRepository
					.findById(value.getDonationTypeModel().getDonationTypeId())
					.orElseThrow(() -> new CustomException("Donation Type Data not found with specific Id..!", false));

			if (!ObjectUtils.isEmpty(donationTypeData)) {

				BeanUtils.copyProperties(value, donationAmountEntity);
				donationAmountEntity.setUsersEntity(userData);
				donationAmountEntity.setDonationTypeEntity(donationTypeData);
				DonationAmountEntity donationAmountEntity2 = donationAmountRepository.save(donationAmountEntity);

				if (!ObjectUtils.isEmpty(donationAmountEntity2)) {
					message = "Donation Amount added Successfully..!!";
				} else {
					message = "Error Occurred while saving Amount..!!";
				}

			}

		}

		return message;

	}

}
