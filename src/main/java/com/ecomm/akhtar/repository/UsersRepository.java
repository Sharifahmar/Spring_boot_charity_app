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
@RepositoryRestResource(collectionResourceRel = "usersRepo", path = "usersRepo")
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {


	Optional<UsersEntity> findByEmail(String email);

	Optional<UsersEntity> findByPhoneNumber(String phone);

	//Optional<UsersEntity> findByUserNameOrEmailId(String username, String email);

	Boolean existsByPhoneNumber(String phoneNumber);

	Boolean existsByEmail(String email);

	@Override
	List<UsersEntity> findAll();

	Optional<UsersEntity> findByIdAndStatus(Long id, Boolean status);
	
	Optional<UsersEntity> findByPhoneNumberAndStatus(String phone,Boolean status);

}
