/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.DonarSlipDetailsEntity;
import com.ecomm.akhtar.entity.UsersEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "donarSlipDetails", path = "donarSlipDetails")
public interface DonarSlipDetailsRepository extends JpaRepository<DonarSlipDetailsEntity, Long> {

	void save(UsersEntity userData);

	//Optional<DonationTypeEntity> findByIdAndStatus(Long id, Boolean status);

}
