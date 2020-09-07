/**
 * 
 */
package com.ecomm.akhtar.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ecomm.akhtar.entity.AcceptorAmountEntity;
import com.ecomm.akhtar.entity.AcceptorEntity;
import com.ecomm.akhtar.entity.DonationTypeEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.AcceptorAmountModel;
import com.ecomm.akhtar.model.AcceptorContributionDTO;
import com.ecomm.akhtar.model.AcceptorContributionRequestDTO;
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

	@Override
	public AcceptorAmountModel addAcceptorAmountService(AcceptorAmountModel acceptorAmountModel)
			throws CustomException {

		AcceptorAmountEntity acceptorAmountEntity = new AcceptorAmountEntity();
		AcceptorAmountModel acceptorAmountModelNew = new AcceptorAmountModel();
		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		AcceptorEntity acceptorData = acceptorRepository
				.findByPhoneNumberAndStatus(acceptorAmountModel.getAcceptor().getPhoneNumber(), true)
				.orElseThrow(() -> new CustomException("Acceptor Mobile Number not found or it was deleted..!", false));

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

	@Override
	public List<AcceptorContributionDTO> getContributionDetails(AcceptorContributionRequestDTO request)
			throws CustomException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (request.getFromDate() != null) {
			Date fromDate = null;
			try {
				fromDate = formatter.parse(request.getFromDate());
			} catch (ParseException e) {
				throw new CustomException("From Date Format should be wrong..!", false);
			}
			request.setFromDateObj(fromDate);
		}

		if (request.getToDate() != null) {
			Date toDate = null;
			Date datePlusOne = null;
			try {
				toDate = formatter.parse(request.getToDate());
			} catch (ParseException e) {
				throw new CustomException("To Date Format should be wrong..!", false);
			}
			Calendar c = Calendar.getInstance();
			c.setTime(toDate);
			c.add(Calendar.DATE, 1);
			datePlusOne = c.getTime();
			request.setToDateObj(datePlusOne);
		}

		List<AcceptorContributionDTO> data = acceptorAmountRepository.acceptorContributionJoin(request.getPhoneNumber(),
				request.getDonationTypeId(), request.getStatus(), request.getFromDateObj(), request.getToDateObj());
		return data;
	}

	@Override
	public AcceptorContributionDTO getDonationDetailsById(Long id) {
		Optional<AcceptorAmountEntity> entities = acceptorAmountRepository.findById(id);
		AcceptorContributionDTO acceptorDTO = new AcceptorContributionDTO();
		if (entities.isPresent()) {
			BeanUtils.copyProperties(entities.get(), acceptorDTO);
			BeanUtils.copyProperties(entities.get().getAcceptorEntity(), acceptorDTO);
			BeanUtils.copyProperties(entities.get().getDonationTypeEntity(), acceptorDTO);
			acceptorDTO.setDate(entities.get().getCreatedDt());
		}

		return acceptorDTO;
	}

	@Override
	public AcceptorContributionDTO findById(Long acceptorAmountId) {
		AcceptorContributionDTO dto = new AcceptorContributionDTO();
		Optional<AcceptorAmountEntity> acceptorAmountEntity = acceptorAmountRepository.findById(acceptorAmountId);
		if (acceptorAmountEntity.isPresent()) {
			acceptorAmountEntity.get().setStatus(false);
			AcceptorAmountEntity amountEntity2 = acceptorAmountRepository.save(acceptorAmountEntity.get());
			BeanUtils.copyProperties(amountEntity2, dto);
			BeanUtils.copyProperties(amountEntity2.getAcceptorEntity(), dto);
			BeanUtils.copyProperties(amountEntity2.getDonationTypeEntity(), dto);
		}
		return dto;
	}
}
