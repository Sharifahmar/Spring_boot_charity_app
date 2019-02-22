/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.RolesEntity;
import com.ecomm.akhtar.model.RoleName;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "roles", path = "roles")
public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {
	Optional<RolesEntity> findByRoleName(RoleName roleUser);
}
