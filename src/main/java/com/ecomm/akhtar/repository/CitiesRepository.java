/**
 * 
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.CitiesEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "cities", path = "cites")
public interface CitiesRepository extends CrudRepository<CitiesEntity, Integer> {

}
