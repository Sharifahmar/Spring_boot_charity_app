/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
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

	Boolean existsByEmail(String email);

	@RestResource(path = "donarList")
	List<DonarsEntity> findByStatus(@RequestParam("value") Boolean value);

	@RestResource(exported = false)
	Iterable<DonarsEntity> findAll();

	@RestResource(path = "donarListByIdAndStatus")
	List<DonarsEntity> findByDonarIdAndStatus(@RequestParam("id") long id, @RequestParam("value") Boolean value);

	Optional<DonarsEntity> findByPhoneNumberAndStatus(String phoneNumber, boolean b);

	@Query(name = "donarSearchCriteria")
	List<DonarsEntity> findByDonarSearchCriteria(@Param("firstName") String firstName,
			@Param("phoneNumber") String phoneNumber, @Param("email") String email, @Param("status") Boolean status);

}
