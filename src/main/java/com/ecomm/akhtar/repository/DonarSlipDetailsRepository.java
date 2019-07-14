/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.DonarSlipDetailsEntity;
import com.ecomm.akhtar.entity.UsersEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "donarSlipDetailsRepo", path = "donarSlipDetailsRepo")
public interface DonarSlipDetailsRepository extends CrudRepository<DonarSlipDetailsEntity, Long> {

	void save(UsersEntity userData);

	//Optional<DonationTypeEntity> findByIdAndStatus(Long id, Boolean status);

}
