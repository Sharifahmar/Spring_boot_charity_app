/**
 * 
 */
package com.ecomm.akhtar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ecomm.akhtar.entity.AcceptorAmountEntity;
import com.ecomm.akhtar.entity.AcceptorEntity;
import com.ecomm.akhtar.entity.DonationAmountEntity;
import com.ecomm.akhtar.entity.DonationTypeEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.AcceptorAmountModel;
import com.ecomm.akhtar.repository.AcceptorAmountRepository;
import com.ecomm.akhtar.repository.AcceptorRepository;
import com.ecomm.akhtar.repository.DonationTypeRepository;
import com.ecomm.akhtar.repository.UsersRepository;
import com.ecomm.akhtar.securityconfig.UserPrincipal;

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
	
	@Autowired
	private UsersRepository userRepository;


	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecomm.akhtar.service.AcceptorAmountServiceInf#addAcceptorAmountService(
	 * com.ecomm.akhtar.model.AcceptorAmountModel)
	 */
	@Override
	public AcceptorAmountModel addAcceptorAmountService(AcceptorAmountModel acceptorAmountModel) throws CustomException {

		AcceptorAmountEntity acceptorAmountEntity = new AcceptorAmountEntity();
		AcceptorAmountModel acceptorAmountModelNew = new AcceptorAmountModel();
		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		AcceptorEntity acceptorData = acceptorRepository.findByPhoneNumberAndStatus(acceptorAmountModel.getAcceptor().getPhoneNumber(), true)
				.orElseThrow(
						() -> new CustomException("Acceptor Mobile Number not found or it was deleted..!", false));

		if (!ObjectUtils.isEmpty(acceptorData)) {

			DonationTypeEntity donationTypeData = donationTypeRepository
					.findBydonationTypeIdAndStatus(acceptorAmountModel.getDonationTypeModel().getDonationTypeId(), true)
					.orElseThrow(() -> new CustomException("Donation Type Data not found with specific Id..!", false));

			if (!ObjectUtils.isEmpty(donationTypeData)) {
				if (userPrincipal.getId() != null) {
					UsersEntity usersEntity = userRepository.findById(userPrincipal.getId())
							.orElseThrow(() -> new CustomException("User Information not found ..!", false));		
					acceptorAmountEntity.setAcceptorEntity(acceptorData);
					acceptorAmountEntity.setDonationTypeEntity(donationTypeData);
					acceptorAmountEntity.setUsersEntity(usersEntity);
					acceptorAmountEntity.setAcceptorAmount(acceptorAmountModel.getDonationAmount());
					acceptorAmountEntity.setStatus(true);
					acceptorAmountEntity.setTokenNumber(acceptorAmountModel.getTokenNumber());
					AcceptorAmountEntity acceptorAmountEntity2 = acceptorAmountRepository.save(acceptorAmountEntity);
					BeanUtils.copyProperties(acceptorAmountEntity2, acceptorAmountModelNew);
					acceptorAmountModelNew.setDonationAmount(acceptorAmountEntity2.getAcceptorAmount());
					acceptorAmountModelNew.setTokenNumber(acceptorAmountEntity2.getTokenNumber());
					
				}


			}

		}

		return acceptorAmountModelNew;

	}

}
