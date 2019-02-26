package com.ecomm.akhtar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.ecomm.akhtar.entity.AcceptorEntity;
import com.ecomm.akhtar.entity.AcceptorTokenDetailsEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Acceptor;
import com.ecomm.akhtar.repository.AcceptorRepository;
import com.ecomm.akhtar.repository.AcceptorTokenRepository;

@Component
public class AcceptorTokenServiceImpl implements AcceptorTokenServiceInf {
	@Autowired
	private AcceptorRepository acceptorRepository;

	@Autowired
	private AcceptorTokenRepository acceptorTokenRepository;

	AcceptorTokenDetailsEntity acceptorTokenDetailsEntity = null;

	String message = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ecomm.akhtar.service.AcceptorTokenServiceInf#addAcceptorTokenService(com.
	 * ecomm.akhtar.model.Acceptor)
	 */
	@Override
	public String addAcceptorTokenService(Acceptor acceptor) throws CustomException {

		acceptorTokenDetailsEntity = new AcceptorTokenDetailsEntity();

		AcceptorEntity acceptorData = acceptorRepository.findByAcceptorIdAndStatus(acceptor.getAcceptorId(), true)
				.orElseThrow(() -> new CustomException("Acceptor not found with specific details..!!", false));

		acceptorTokenDetailsEntity.setAcceptorEntity(acceptorData);

		AcceptorTokenDetailsEntity acceptorTokenDetailsEntity2 = acceptorTokenRepository.save(acceptorTokenDetailsEntity);

		if (!ObjectUtils.isEmpty(acceptorTokenDetailsEntity2)) {

			message = "Token Id & Slip generated Successfully..!!";
		} else {
			message = "Error Occurred while generating Token Id & Slip..!!";
		}
		return message;

	}

}
