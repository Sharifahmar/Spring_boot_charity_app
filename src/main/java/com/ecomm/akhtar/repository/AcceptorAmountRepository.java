/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.AcceptorAmountEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "acceptorAmountRepo", path = "acceptorAmountRepo")
public interface AcceptorAmountRepository extends JpaRepository<AcceptorAmountEntity, Long> {

}
