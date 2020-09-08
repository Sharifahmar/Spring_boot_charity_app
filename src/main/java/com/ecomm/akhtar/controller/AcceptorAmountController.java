/**
 * 
 */
package com.ecomm.akhtar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Acceptor;
import com.ecomm.akhtar.model.AcceptorAmountModel;
import com.ecomm.akhtar.model.AcceptorContributionDTO;
import com.ecomm.akhtar.model.AcceptorContributionRequestDTO;
import com.ecomm.akhtar.model.ApiResponseGenericModel;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.service.AcceptorAmountServiceInf;

/**
 * @author Ahmar
 *
 */
@RestController
public class AcceptorAmountController {

	@Autowired
	private AcceptorAmountServiceInf acceptorAmountServiceInf;

	@PostMapping(EcommUriConstants.ACCEPTOR_AMOUNT)
	public ResponseEntity<ApiResponseModel> addDonationAmount(@RequestBody AcceptorAmountModel acceptorAmountModel) {

		try {
			AcceptorAmountModel msg = acceptorAmountServiceInf.addAcceptorAmountService(acceptorAmountModel);

			if (!ObjectUtils.isEmpty(msg)) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ApiResponseModel("Acceptor Donation Amount Insert Successfully..!!", true));
			}

		} catch (CustomException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseModel(e.getMessage(), e.getSuccess()));

		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseModel("Something went wrong.!!", false));

	}

	@PostMapping(EcommUriConstants.ACCEPTOR_CONTRIBUTION_DETAILS)
	public ResponseEntity<ApiResponseGenericModel<List<AcceptorContributionDTO>>> getContributionDetails(
			@RequestBody AcceptorContributionRequestDTO request) {

		try {
			List<AcceptorContributionDTO> filteredRes = acceptorAmountServiceInf.getContributionDetails(request);

			if (!CollectionUtils.isEmpty(filteredRes)) {

				return ResponseEntity.status(HttpStatus.OK)
						.body(new ApiResponseGenericModel<List<AcceptorContributionDTO>>(filteredRes, true));
			}

		} catch (CustomException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseGenericModel<>(e.getMessage(), e.getSuccess()));
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseGenericModel<>("No Data present for related Search..!!", false));
	}

	@PostMapping(EcommUriConstants.ACCEPTOR_DONATION_DETAILS_BY_ID)
	public ResponseEntity<ApiResponseGenericModel<AcceptorContributionDTO>> getContributionDetailsById(
			@PathVariable Long id) {

		AcceptorContributionDTO res = acceptorAmountServiceInf.getDonationDetailsById(id);
		if (!ObjectUtils.isEmpty(res)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseGenericModel<AcceptorContributionDTO>(res, true));
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseGenericModel<>("No Data present for related Search..!!", false));
	}

	@PostMapping(EcommUriConstants.DELETE_ACCEPTOR_DONATION_DETAILS)
	public ResponseEntity<ApiResponseModel> deleteAcceptorDonation(@RequestBody Acceptor acceptorDTO) {

		AcceptorContributionDTO amtDto = acceptorAmountServiceInf.findById(acceptorDTO.getAcceptorId());

		if (!ObjectUtils.isEmpty(amtDto)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseModel("Acceptor Donation Deleted Successfully..!!", true));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));
		}
	}

	@PostMapping(EcommUriConstants.UPDATE_ACCEPTOR_DONATION_DETAILS)
	public ResponseEntity<ApiResponseModel> updateAcceptorDonation(
			@RequestBody AcceptorContributionDTO acceptorContributionDTO) {

		try {
			AcceptorContributionDTO dto = acceptorAmountServiceInf.updateAcceptorDonation(acceptorContributionDTO);
			if (!ObjectUtils.isEmpty(dto)) {
				return ResponseEntity.status(HttpStatus.OK)
						.body(new ApiResponseModel("Donation Record Update Successfully..!!", true));
			}

		} catch (CustomException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseModel(e.getMessage(), e.getSuccess()));
		}

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));

	}

}
