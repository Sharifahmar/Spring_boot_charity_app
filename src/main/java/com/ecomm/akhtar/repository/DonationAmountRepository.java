/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.akhtar.entity.DonationAmountEntity;



/**
 * @author Ahmar
 *
 */
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('USER')")
@RepositoryRestResource(path = "donationAmountRepo")
public interface DonationAmountRepository extends CrudRepository<DonationAmountEntity, Long> {
	
	@RestResource(path = "donationAmountList")
	List<DonationAmountEntity> findByStatus(@RequestParam("value") Boolean value);
	

}
