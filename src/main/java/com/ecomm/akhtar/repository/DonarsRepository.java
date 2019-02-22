/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.DonarsEntity;



/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "donars", path = "donars")
public interface DonarsRepository extends JpaRepository<DonarsEntity, Long> {
	

}
