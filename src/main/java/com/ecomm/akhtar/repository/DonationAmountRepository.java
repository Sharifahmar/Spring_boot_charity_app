/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.DonationAmountEntity;



/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "donationAmount", path = "donationAmount")
public interface DonationAmountRepository extends JpaRepository<DonationAmountEntity, Long> {
	

}
