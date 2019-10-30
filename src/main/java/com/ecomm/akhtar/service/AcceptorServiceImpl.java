/**
 * 
 */
package com.ecomm.akhtar.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.entity.AcceptorEntity;
import com.ecomm.akhtar.entity.DonarsEntity;
import com.ecomm.akhtar.model.Acceptor;
import com.ecomm.akhtar.model.Donars;
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

	@Override
	public List<Acceptor> searchCriteria(Acceptor acceptor) {
		AcceptorEntity acceptorEntity = new AcceptorEntity();
		acceptorEntity.setFirstName(acceptor.getFirstName());
		acceptorEntity.setPhoneNumber(acceptor.getPhoneNumber());
		acceptorEntity.setEmail(acceptor.getEmail());
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
		Example<AcceptorEntity> exampleQuery = Example.of(acceptorEntity, matcher);
		List<AcceptorEntity> acceptorEntityRtrn = (List<AcceptorEntity>) acceptorRepository.findAll(exampleQuery);
		return acceptorEntityRtrn.stream().map(x -> {
			Acceptor acceptorNew = new Acceptor();
			BeanUtils.copyProperties(x, acceptorNew);
			return acceptorNew;
		}).collect(Collectors.toList());
	}

}
