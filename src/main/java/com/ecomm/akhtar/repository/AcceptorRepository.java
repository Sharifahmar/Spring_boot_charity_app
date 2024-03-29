/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.akhtar.entity.AcceptorEntity;

/**
 * @author Ahmar
 *
 */
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('USER')")
@RepositoryRestResource(path = "acceptorRepo")
public interface AcceptorRepository extends CrudRepository<AcceptorEntity, Long> {

	Boolean existsByPhoneNumber(String phoneNumber);

	Optional<AcceptorEntity> findByPhoneNumberAndStatus(String phone, boolean b);

	Optional<AcceptorEntity> findByAcceptorIdAndStatus(Long acceptorId, boolean b);

	@RestResource(path = "acceptorList")
	List<AcceptorEntity> findByStatus(@RequestParam("value") Boolean value);

	@RestResource(exported = false)
	Iterable<AcceptorEntity> findAll();

	@RestResource(path = "acceptorIdByIdAndStatus")
	List<AcceptorEntity> findByAcceptorIdAndStatus(@RequestParam("id") long id, @RequestParam("value") Boolean value);

	@Query(name = "acceptorSearchCriteria")
	List<AcceptorEntity> findByAcceptorSearchCriteria(@Param("fullName") String fullName,
			@Param("phoneNumber") String phoneNumber, @Param("status") Boolean status);

}
