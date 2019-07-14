/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.DonationAmountEntity;



/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "donationAmountRepo", path = "donationAmountRepo")
public interface DonationAmountRepository extends CrudRepository<DonationAmountEntity, Long> {
	

}
