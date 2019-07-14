/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.DonationTypeEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "donationTypeRepo", path = "donationTypeRepo")
public interface DonationTypeRepository extends CrudRepository<DonationTypeEntity, Long> {

	Optional<DonationTypeEntity> findBydonationTypeIdAndStatus(Long id,Boolean status);

}
