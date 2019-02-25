package com.ecomm.akhtar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ecomm.akhtar.entity.DonarSlipDetailsEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.repository.DonarSlipDetailsRepository;
import com.ecomm.akhtar.repository.UsersRepository;

@Component
public class DonarSlipDetailsServiceImpl implements DonarSlipDetailsServiceInf {
	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private DonarSlipDetailsRepository donarSlipDetailsRepository;

	DonarSlipDetailsEntity donarSlipDetailsEntity = null;

	String message = null;

	@Override
	public String addDonarSlipDetailsService(Users users) throws CustomException {

		donarSlipDetailsEntity = new DonarSlipDetailsEntity();

		UsersEntity userData = userRepository.findByIdAndStatus(users.getId(), true)
				.orElseThrow(() -> new CustomException("User not found with specific details..!!", false));

		BeanUtils.copyProperties(userData, donarSlipDetailsEntity);

		DonarSlipDetailsEntity donarSlipDetailsEntity2 = donarSlipDetailsRepository.save(donarSlipDetailsEntity);

		if (!ObjectUtils.isEmpty(donarSlipDetailsEntity2)) {

			message = "Donar Slip generated Successfully..!!";
		} else {
			message = "Error Occurred while generating donar slip..!!";
		}
		return message;

	}

}
