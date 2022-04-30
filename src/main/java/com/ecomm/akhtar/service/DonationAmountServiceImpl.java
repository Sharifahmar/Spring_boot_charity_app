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
				.findByFullNameAndStatus(donationAmountModel.getDonars().getFullName(), true)
				.orElseThrow(() -> new CustomException("Donar with name "+ donationAmountModel.getDonars().getFullName() +" not found or it was deleted..!", false));

		if (!ObjectUtils.isEmpty(donarsEntity)) {
			DonationTypeEntity donationTypeData = donationTypeRepository
					.findBydonationTypeIdAndStatus(donationAmountModel.getDonationTypeModel().getDonationTypeId(), true)
					.orElseThrow(() -> new CustomException("Donation Type not found or it was deleted..!", false));

			if (!ObjectUtils.isEmpty(donationTypeData)) {
				if (userPrincipal.getId() != null) {
					UsersEntity usersEntity = userRepository.findById(userPrincipal.getId())
							.orElseThrow(() -> new CustomException("User Information not found ..!", false));
					donationAmountEntity.setDonarsEntity(donarsEntity);
				//	donationAmountEntity.setDonationTypeEntity(donationTypeData);
					donationAmountEntity.setUsersEntity(usersEntity);
				//	donationAmountEntity.setDonationAmount(donationAmountModel.getDonationAmount());
					donationAmountEntity.setStatus(true);
					//donationAmountEntity.setReceiptNumber(donationAmountModel.getReceiptNumber());
					DonationAmountEntity donationAmountEntity2 = donationAmountRepository.save(donationAmountEntity);
					BeanUtils.copyProperties(donationAmountEntity2, donationAmountModel2);
					//donationAmountModel2.setDonationAmount(donationAmountEntity2.getDonationAmount());
				} else {

					throw new CustomException("User Information not found ..!", false);

				}

			}
		}
		return donationAmountModel2;
	}

	@Override
	public List<DonarContributionDTO> getContributionDetails(DonarContributionRequestDTO request)
			throws CustomException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
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

		List<DonarContributionDTO> data = donationAmountRepository.donarContributionJoin(request.getFullName(),
				request.getDonationTypeId(), request.getStatus(), request.getFromDateObj(), request.getToDateObj());
		return data;
	}

	@Override
	public DonarContributionDTO getContributionDetailsById(Long id) {
		Optional<DonationAmountEntity> entities = donationAmountRepository.findById(id);
		DonarContributionDTO donarContributionDTO = new DonarContributionDTO();
		if (entities.isPresent()) {
			BeanUtils.copyProperties(entities.get(), donarContributionDTO);
			BeanUtils.copyProperties(entities.get().getDonarsEntity(), donarContributionDTO);
			BeanUtils.copyProperties(entities.get().getDonarsEntity().getDonationTypeEntity(), donarContributionDTO);
			donarContributionDTO.setDate(entities.get().getCreatedDt());
		}
		return donarContributionDTO;
	}

	@Override
	public DonarContributionDTO findById(Long donationAmountId) {
		DonarContributionDTO donarContributionDTO = new DonarContributionDTO();
		Optional<DonationAmountEntity> donationAmountEntity = donationAmountRepository.findById(donationAmountId);
		if (donationAmountEntity.isPresent()) {
			donationAmountEntity.get().setStatus(false);
			DonationAmountEntity donationAmountEntity2 = donationAmountRepository.save(donationAmountEntity.get());
			BeanUtils.copyProperties(donationAmountEntity2, donarContributionDTO);
			BeanUtils.copyProperties(donationAmountEntity2.getDonarsEntity(), donarContributionDTO);
			//BeanUtils.copyProperties(donationAmountEntity2.getDonationTypeEntity(), donarContributionDTO);
		}
		return donarContributionDTO;
	}

	@Override
	public DonarContributionDTO updateDonarContribution(DonarContributionDTO donarContributionDTO)
			throws CustomException {

		DonarContributionDTO donarContributionDTORtrn = new DonarContributionDTO();

		Optional<DonationAmountEntity> donationAmountEntity = donationAmountRepository
				.findById(donarContributionDTO.getDonationAmountId());

		if (donationAmountEntity.isPresent()) {

			DonarsEntity donarsEntity = donarsRepository
					.findByPhoneNumberAndStatus(donarContributionDTO.getPhoneNumber(), true).orElseThrow(
							() -> new CustomException("Donar Mobile Number not found or it was deleted..!", false));

			if (!ObjectUtils.isEmpty(donarsEntity)) {

				DonationTypeEntity donationTypeData = donationTypeRepository
						.findBydonationTypeIdAndStatus(donarContributionDTO.getDonationTypeId(), true)
						.orElseThrow(() -> new CustomException("Donation Type not found or it was deleted..!", false));

				if (!ObjectUtils.isEmpty(donationTypeData)) {

					donationAmountEntity.get().setDonarsEntity(donarsEntity);
					//donationAmountEntity.get().setDonationTypeEntity(donationTypeData);
//					if (!ObjectUtils.isEmpty(donarContributionDTO.getDonationAmount())
//							&& !ObjectUtils.isEmpty(donarContributionDTO.getReceiptNumber())) {
//						//donationAmountEntity.get().setDonationAmount(donarContributionDTO.getDonationAmount());
//						//donationAmountEntity.get().setReceiptNumber(donarContributionDTO.getReceiptNumber());
//					}

					DonationAmountEntity donationAmountEntityLatest = donationAmountRepository
							.save(donationAmountEntity.get());
					BeanUtils.copyProperties(donationAmountEntityLatest, donarContributionDTORtrn);
					BeanUtils.copyProperties(donationAmountEntityLatest.getDonarsEntity(), donarContributionDTORtrn);
//					BeanUtils.copyProperties(donationAmountEntityLatest.getDonationTypeEntity(),
//							donarContributionDTORtrn);

				}

			}

		}

		return donarContributionDTORtrn;
	}
}
