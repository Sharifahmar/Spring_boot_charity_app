/**
 * 
 */
package com.ecomm.akhtar.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ecomm.akhtar.entity.DonarsEntity;
import com.ecomm.akhtar.entity.DonationAmountEntity;
import com.ecomm.akhtar.entity.DonationTypeEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.DonarContributionDTO;
import com.ecomm.akhtar.model.DonarContributionRequestDTO;
import com.ecomm.akhtar.model.DonationAmountModel;
import com.ecomm.akhtar.repository.DonarsRepository;
import com.ecomm.akhtar.repository.DonationAmountRepository;
import com.ecomm.akhtar.repository.DonationTypeRepository;
import com.ecomm.akhtar.repository.UsersRepository;
import com.ecomm.akhtar.securityconfig.UserPrincipal;

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

	@Autowired
	private DonarsRepository donarsRepository;

	@Override
	public DonationAmountModel addDonationAmountService(DonationAmountModel donationAmountModel)
			throws CustomException {
		DonationAmountEntity donationAmountEntity = new DonationAmountEntity();
		DonationAmountModel donationAmountModel2 = new DonationAmountModel();
		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		DonarsEntity donarsEntity = donarsRepository
				.findByPhoneNumberAndStatus(donationAmountModel.getDonars().getPhoneNumber(), true)
				.orElseThrow(() -> new CustomException("Donar Mobile Number not found or it was deleted..!", false));

		if (!ObjectUtils.isEmpty(donarsEntity)) {
			DonationTypeEntity donationTypeData = donationTypeRepository
					.findBydonationTypeIdAndStatus(donationAmountModel.getDonationTypeModel().getDonationTypeId(), true)
					.orElseThrow(() -> new CustomException("Donation Type not found or it was deleted..!", false));

			if (!ObjectUtils.isEmpty(donationTypeData)) {
				if (userPrincipal.getId() != null) {
					UsersEntity usersEntity = userRepository.findById(userPrincipal.getId())
							.orElseThrow(() -> new CustomException("User Information not found ..!", false));
					donationAmountEntity.setDonarsEntity(donarsEntity);
					donationAmountEntity.setDonationTypeEntity(donationTypeData);
					donationAmountEntity.setUsersEntity(usersEntity);
					donationAmountEntity.setDonationAmount(donationAmountModel.getDonationAmount());
					donationAmountEntity.setStatus(true);
				}
				DonationAmountEntity donationAmountEntity2 = donationAmountRepository.save(donationAmountEntity);
				BeanUtils.copyProperties(donationAmountEntity2, donationAmountModel2);
				donationAmountModel2.setDonationAmount(donationAmountEntity2.getDonationAmount());
			}
		}
		return donationAmountModel2;
	}

	@Override
	public List<DonarContributionDTO> getContributionDetails(DonarContributionRequestDTO request) {
		List<DonarContributionDTO> data = donationAmountRepository.donarContributionJoin(request.getPhoneNumber(),request.getDonationTypeId(),request.getStatus());
		return data;
	}
}
