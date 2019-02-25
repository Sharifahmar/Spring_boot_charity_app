/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.DonationTypeEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "donationType", path = "donationType")
public interface DonationTypeRepository extends JpaRepository<DonationTypeEntity, Long> {

	Optional<DonationTypeEntity> findBydonationTypeIdAndStatus(Long id,Boolean status);

}
