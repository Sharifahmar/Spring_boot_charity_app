/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.akhtar.entity.DonarsEntity;

/**
 * @author Ahmar
 *
 */
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('USER')")
@RepositoryRestResource(path = "donarsRepo")
public interface DonarsRepository extends CrudRepository<DonarsEntity, Long>{

	Boolean existsByPhoneNumber(String phoneNumber);

	@RestResource(path = "donarList")
	List<DonarsEntity> findByStatus(@RequestParam("value") Boolean value);

	@RestResource(exported = false)
	Iterable<DonarsEntity> findAll();

	@RestResource(path = "donarListByIdAndStatus")
	DonarsEntity findByDonarIdAndStatus(@RequestParam("id") long id, @RequestParam("value") Boolean value);

	Optional<DonarsEntity> findByPhoneNumberAndStatus(String phoneNumber, boolean b);
	
	@RestResource(path = "donarListByFullNameAndStatus")
	Optional<DonarsEntity> findByFullNameAndStatus(String fullName, boolean b);

	@Query(name = "donarSearchCriteria")
	List<DonarsEntity> findByDonarSearchCriteria(@Param("fullName") String fullName,
			@Param("phoneNumber") String phoneNumber, @Param("status") Boolean status);

}
