/**
 *
 */
package com.ecomm.akhtar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.StudentsStationaryEntity;

/**
 * @author Ahmar
 *
 */
// @PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "studentsStationaryRepo", path = "studentsStationaryRepo")
public interface StudentsStationaryRepository extends JpaRepository<StudentsStationaryEntity, Long> {

}
