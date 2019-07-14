/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.AcceptorEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "acceptorRepo", path = "acceptorRepo")
public interface AcceptorRepository extends CrudRepository<AcceptorEntity, Long> {

	Optional<AcceptorEntity> findByPhoneAndStatus(String phone, boolean b);

	Optional<AcceptorEntity> findByAcceptorIdAndStatus(Long acceptorId, boolean b);

}
