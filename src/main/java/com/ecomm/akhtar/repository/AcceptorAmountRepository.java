/**
 * 
 */
package com.ecomm.akhtar.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ecomm.akhtar.entity.AcceptorAmountEntity;
import com.ecomm.akhtar.model.AcceptorContributionDTO;

/**
 * @author Ahmar
 *
 */
@RepositoryRestResource(collectionResourceRel = "acceptorAmountRepo", path = "acceptorAmountRepo")
public interface AcceptorAmountRepository extends CrudRepository<AcceptorAmountEntity, Long> {

	@Query(name = "acceptorContributionJoinQuerySearchCriteria")
	List<AcceptorContributionDTO> acceptorContributionJoin(@Param("fullName") String fullName,
			@Param("donationTypeId") Long donationTypeId, @Param("status") Boolean status,
			@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

}
