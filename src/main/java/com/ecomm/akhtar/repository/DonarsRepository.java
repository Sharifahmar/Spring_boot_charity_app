/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecomm.akhtar.entity.DonarsEntity;



/**
 * @author Ahmar
 *
 */
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('USER')")
@RepositoryRestResource(collectionResourceRel = "donarsRepo", path = "donarsRepo")
public interface DonarsRepository extends JpaRepository<DonarsEntity, Long> {
	
	Boolean existsByPhoneNumber(String phoneNumber);

	Boolean existsByEmail(String email);
	

}
