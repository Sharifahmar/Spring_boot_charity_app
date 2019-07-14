/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.AcceptorAmountEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "acceptorAmountRepo", path = "acceptorAmountRepo")
public interface AcceptorAmountRepository extends CrudRepository<AcceptorAmountEntity, Long> {

}
