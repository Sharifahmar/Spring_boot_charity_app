/**
 *
 */
package com.ecomm.akhtar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.akhtar.entity.AcceptorEntity;
import com.ecomm.akhtar.entity.StudentsEntity;

/**
 * @author Ahmar
 *
 */
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "studentsRepo", path = "studentsRepo")
public interface StudentsRepository extends CrudRepository<StudentsEntity, Long> {

	Optional<StudentsEntity> findByStudentIdAndStatus(Long id, boolean b);
	
	@RestResource(path = "studentList")
	List<StudentsEntity> findByStatus(@RequestParam("value") Boolean value);
	
	@RestResource(path = "studentIdByIdAndStatus")
	List<StudentsEntity> findByStudentIdAndStatus(@RequestParam("id") long id,@RequestParam("value") Boolean value);

}
