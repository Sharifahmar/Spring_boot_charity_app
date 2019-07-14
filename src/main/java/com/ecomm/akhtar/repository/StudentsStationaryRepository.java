/**
 *
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.StudentsStationaryEntity;

/**
 * @author Ahmar
 *
 */
// @PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "studentsStationaryRepo", path = "studentsStationaryRepo")
public interface StudentsStationaryRepository extends CrudRepository<StudentsStationaryEntity, Long> {

}
