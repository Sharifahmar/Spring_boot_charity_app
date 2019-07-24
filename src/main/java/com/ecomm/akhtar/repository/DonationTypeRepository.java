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

import com.ecomm.akhtar.entity.DonationTypeEntity;

/**
 * @author Ahmar
 *
 */
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('USER')")
@RepositoryRestResource(path = "donationTypeRepo")
public interface DonationTypeRepository extends CrudRepository<DonationTypeEntity, Long> {
	
	@RestResource(path = "donationTypeByIdAndStatus")
	Optional<DonationTypeEntity> findBydonationTypeIdAndStatus(@RequestParam("id") long id,@RequestParam("value") Boolean value);
	
	@RestResource(path = "donationTypeList")
	List<DonationTypeEntity> findByStatus(@RequestParam("value") Boolean value);
	
	boolean existsByDonationType(String donationType);

}
