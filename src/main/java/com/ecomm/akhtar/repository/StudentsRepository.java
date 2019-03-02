/**
 *
 */
package com.ecomm.akhtar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.StudentsEntity;

/**
 * @author Ahmar
 *
 */
// @PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "studentsRepo", path = "studentsRepo")
public interface StudentsRepository extends JpaRepository<StudentsEntity, Long> {

	Optional<StudentsEntity> findByIdAndStatus(Long id, boolean b);

}
