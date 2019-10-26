/**
 * 
 */
package com.ecomm.akhtar.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.entity.AcceptorEntity;
import com.ecomm.akhtar.model.Acceptor;
import com.ecomm.akhtar.repository.AcceptorRepository;

/**
 * @author Ahmar
 *
 */
@Component
public class AcceptorServiceImpl implements AcceptorServiceInf {

	@Autowired
	private AcceptorRepository acceptorRepository;

	@Override
	public Boolean existsByPhoneNumber(String phoneNumber) {
		return !acceptorRepository.existsByPhoneNumber(phoneNumber);
	}

	@Override
	public Boolean existsByEmailId(String email) {
		return !acceptorRepository.existsByEmail(email);
	}

	@Override
	public Acceptor findById(Long donarId) {
		Acceptor acceptor = new Acceptor();
		Optional<AcceptorEntity> acceptorEntity = acceptorRepository.findById(donarId);
		if (acceptorEntity.isPresent()) {
			acceptorEntity.get().setStatus(false);
			AcceptorEntity acceptorEntityNew = acceptorRepository.save(acceptorEntity.get());
			BeanUtils.copyProperties(acceptorEntityNew, acceptor);
		}
		return acceptor;
	}

	@Override
	public Acceptor updateAcceptor(Acceptor acceptor) {
		Acceptor acceptor2 = new Acceptor();
		Optional<AcceptorEntity> acOptional = acceptorRepository.findById(acceptor.getAcceptorId());
		if (acOptional.isPresent()) {
			AcceptorEntity acceptorEntityNew = new AcceptorEntity();
			BeanUtils.copyProperties(acceptor, acceptorEntityNew);
			acceptorEntityNew.setPhoneNumber(acOptional.get().getPhoneNumber());
			acceptorEntityNew.setEmail(acOptional.get().getEmail());
			AcceptorEntity acceptorEntity = acceptorRepository.save(acceptorEntityNew);
			BeanUtils.copyProperties(acceptorEntity, acceptor2);
		}
		return acceptor2;
	}

}
