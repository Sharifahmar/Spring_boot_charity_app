/**
 *
 */
package com.ecomm.akhtar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.UsersEntity;

/**
 * @author Ahmar
 *
 */
// @PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "usersentities", path = "usersentities")
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

	Optional<UsersEntity> findByUserName(String username);

	Optional<UsersEntity> findByEmailId(String email);

	Optional<UsersEntity> findByPhone(String phone);

	Optional<UsersEntity> findByUserNameOrEmailId(String username, String email);

	Boolean existsByUserName(String username);

	Boolean existsByEmailId(String email);

	@Override
	List<UsersEntity> findAll();

	Optional<UsersEntity> findByIdAndStatus(Long id, Boolean status);

}
