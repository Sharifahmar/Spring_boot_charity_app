/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.ImagesEntity;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "userimages", path = "userimages")
public interface ImagesRepository extends JpaRepository<ImagesEntity, Long> {

	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@Query(name = "findByFileType", nativeQuery = true)
	ImagesEntity findByFileType(Long id, String docName);
	
	@Query(name = "findImgByIdAndStatus", nativeQuery = true)
	Optional<ImagesEntity> findByIdImgAndStatus(Long id ,Boolean status);

}
