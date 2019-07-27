/**
 * 
 */
package com.ecomm.akhtar.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.entity.DonarsEntity;
import com.ecomm.akhtar.model.Donars;
import com.ecomm.akhtar.repository.DonarsRepository;

/**
 * @author Ahmar
 *
 */
@Component
public class DonarServiceImpl implements DonarServiceInf {

	@Autowired
	private DonarsRepository donarsRepository;

	@Override
	public Boolean existsByPhoneNumber(String phoneNumber) {
		return !donarsRepository.existsByPhoneNumber(phoneNumber);
	}

	@Override
	public Boolean existsByEmailId(String email) {
		return !donarsRepository.existsByEmail(email);
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
		Optional<DonarsEntity> donarEntity  = donarsRepository.findById(donar.getDonarId());
		if (donarEntity.isPresent()) {
			BeanUtils.copyProperties(donar, donarEntity.get());
			DonarsEntity donarsEntity = donarsRepository.save(donarEntity.get());
			BeanUtils.copyProperties(donarsEntity, donars);
		}
		return donars;
	}

}
