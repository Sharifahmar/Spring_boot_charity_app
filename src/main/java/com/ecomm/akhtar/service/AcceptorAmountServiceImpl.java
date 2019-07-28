/**
 * 
 */
package com.ecomm.akhtar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ecomm.akhtar.entity.AcceptorAmountEntity;
import com.ecomm.akhtar.entity.AcceptorEntity;
import com.ecomm.akhtar.entity.DonationAmountEntity;
import com.ecomm.akhtar.entity.DonationTypeEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.AcceptorAmountModel;
import com.ecomm.akhtar.repository.AcceptorAmountRepository;
import com.ecomm.akhtar.repository.AcceptorRepository;
import com.ecomm.akhtar.repository.DonationTypeRepository;

/**
 * @author Ahmar
 *
 */
@Component
public class AcceptorAmountServiceImpl implements AcceptorAmountServiceInf {

	@Autowired
	private AcceptorRepository acceptorRepository;

	@Autowired
	private DonationTypeRepository donationTypeRepository;

	@Autowired
	private AcceptorAmountRepository acceptorAmountRepository;

	AcceptorAmountEntity acceptorAmountEntity = null;

	AcceptorAmountModel acceptorAmountModel = null;

	String message = null;

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecomm.akhtar.service.AcceptorAmountServiceInf#addAcceptorAmountService(
	 * com.ecomm.akhtar.model.AcceptorAmountModel)
	 */
	@Override
	public String addAcceptorAmountService(AcceptorAmountModel value) throws CustomException {

		acceptorAmountEntity = new AcceptorAmountEntity();
		acceptorAmountModel = new AcceptorAmountModel();
		AcceptorEntity acceptorData = acceptorRepository.findByPhoneNumberAndStatus(value.getAcceptor().getPhone(), true)
				.orElseThrow(
						() -> new CustomException("Acceptor Data not found with specific Mobile Number..!", false));

		if (!ObjectUtils.isEmpty(acceptorData)) {

			DonationTypeEntity donationTypeData = donationTypeRepository
					.findBydonationTypeIdAndStatus(value.getDonationTypeModel().getDonationTypeId(), true)
					.orElseThrow(() -> new CustomException("Donation Type Data not found with specific Id..!", false));

			if (!ObjectUtils.isEmpty(donationTypeData)) {

				BeanUtils.copyProperties(value, acceptorAmountEntity);
				acceptorAmountEntity.setAcceptorEntity(acceptorData);
				acceptorAmountEntity.setDonationTypeEntity(donationTypeData);
				AcceptorAmountEntity acceptorAmountEntity2 = acceptorAmountRepository.save(acceptorAmountEntity);

				if (!ObjectUtils.isEmpty(acceptorAmountEntity2)) {
					message = "Acceptor Amount & Data added Successfully..!!";
				} else {
					message = "Error Occurred while saving Acceptor Amount & Data..!!";
				}

			}

		}

		return message;

	}

}
