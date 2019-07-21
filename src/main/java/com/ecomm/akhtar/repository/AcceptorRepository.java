/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.akhtar.entity.AcceptorEntity;
import com.ecomm.akhtar.entity.DonarsEntity;

/**
 * @author Ahmar
 *
 */
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('USER')")
@RepositoryRestResource(path = "acceptorRepo")
public interface AcceptorRepository extends CrudRepository<AcceptorEntity, Long> {

	Optional<AcceptorEntity> findByPhoneAndStatus(String phone, boolean b);

	Optional<AcceptorEntity> findByAcceptorIdAndStatus(Long acceptorId, boolean b);

	@RestResource(path = "acceptorList")
	List<DonarsEntity> findByStatus(@RequestParam("value") Boolean value);
	
	@RestResource(exported = false)
	Iterable<AcceptorEntity> findAll();
	
	@RestResource(path = "acceptorIdByIdAndStatus")
	List<DonarsEntity> findByAcceptorIdAndStatus(@RequestParam("id") long id,@RequestParam("value") Boolean value);
}
