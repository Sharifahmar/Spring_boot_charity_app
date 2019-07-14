/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.UsersEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "coupons", path = "coupons")
public interface CouponsRepository extends CrudRepository<UsersEntity, Integer> {

}
