/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.AcceptorTokenDetailsEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "acceptorTokenRepo", path = "acceptorTokenRepo")
public interface AcceptorTokenRepository extends JpaRepository<AcceptorTokenDetailsEntity, Long> {

	

}
