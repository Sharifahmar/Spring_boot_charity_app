/**
 * 
 */
package com.ecomm.akhtar.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.entity.DonarsEntity;
import com.ecomm.akhtar.entity.DonationAmountEntity;
import com.ecomm.akhtar.entity.DonationTypeEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Donars;
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
public class DonarServiceImpl implements DonarServiceInf {

	@Autowired
	private DonarsRepository donarsRepository;

	@Autowired
	private DonationTypeRepository donationTypeRepository;

	@Autowired
	private DonationAmountRepository donationAmountRepository;

	@Autowired
	private UsersRepository userRepository;

	@Override
	public Boolean existsByPhoneNumber(String phoneNumber) {
		return !donarsRepository.existsByPhoneNumber(phoneNumber);
	}

	@Override
	public Donars findById(Long donarId) {
		Donars donars = new Donars();
		Optional<DonarsEntity> donarEntity = donarsRepository.findById(donarId);
		if (donarEntity.isPresent()) {
			donarEntity.get().setStatus(false);
			DonarsEntity donarsEntity = donarsRepository.save(donarEntity.get());
			BeanUtils.copyProperties(donarsEntity, donars);
		}
		return donars;
	}

	@Override
	public Donars updateDonar(Donars donar) {
		Donars donars = new Donars();
		Optional<DonarsEntity> donarEntity = donarsRepository.findById(donar.getDonarId());
		Optional<DonationTypeEntity> donationTypeEntity = donationTypeRepository.findById(donar.getDonationTypeId());
		if (donarEntity.isPresent() && donationTypeEntity.isPresent()) {
			DonarsEntity doEntity = new DonarsEntity();
			BeanUtils.copyProperties(donar, doEntity);
			doEntity.setPhoneNumber(donarEntity.get().getPhoneNumber());
			doEntity.setDonationTypeEntity(donationTypeEntity.get());
			DonarsEntity donarsEntity = donarsRepository.save(doEntity);
			BeanUtils.copyProperties(donarsEntity, donars);
			donars.setDonationTypeId(donarEntity.get().getDonationTypeEntity().getDonationTypeId());
		}
		return donars;
	}

	@Override
	public List<Donars> searchCriteria(Donars donar) {
		List<DonarsEntity> donarEntity = donarsRepository.findByDonarSearchCriteria(donar.getFullName(),
				donar.getPhoneNumber(), donar.getStatus());
		return donarEntity.stream().map(x -> {
			Donars donars = new Donars();
			BeanUtils.copyProperties(x, donars);
			return donars;
		}).collect(Collectors.toList());
	}

	@Override
	public String donorBulkReceiptGenerate(List<Donars> donar) throws CustomException {
		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		UsersEntity usersEntity = userRepository.findById(userPrincipal.getId())
				.orElseThrow(() -> new CustomException("User Information not found ..!", false));
		List<DonationAmountEntity> data = donar.stream().map(x -> {
			DonationAmountEntity donationAmountEntity = new DonationAmountEntity();
			Optional<DonarsEntity> donarEntity = donarsRepository.findById(x.getDonarId());
			donationAmountEntity.setDonarsEntity(donarEntity.get());
			donationAmountEntity.setUsersEntity(usersEntity);
			donationAmountEntity.setStatus(true);
			return donationAmountEntity;
		}).collect(Collectors.toList());
		
		donationAmountRepository.saveAll(data);		
		return "Bulk Donation Amount Generated Successfully..!!";
	}

}
