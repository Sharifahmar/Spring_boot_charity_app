package com.ecomm.akhtar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.ApiResponseGenericModel;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.model.Donars;
import com.ecomm.akhtar.model.IdentityAvailability;
import com.ecomm.akhtar.model.UsersCheckRequest;
import com.ecomm.akhtar.service.DonarServiceInf;

@RestController
public class DonarController {

	@Autowired
	private DonarServiceInf donarServiceInf;

	@PostMapping(EcommUriConstants.DONAR_PHONENUMBER_EXIST_URI)
	public ResponseEntity<IdentityAvailability> checkUsernameAvailability(@RequestBody UsersCheckRequest donar) {
		Boolean isAvailable = donarServiceInf.existsByPhoneNumber(donar.getPhoneNumber());
		if (isAvailable) {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Phone Number not exist..!!"),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Phone Number already exist..!!"),
					HttpStatus.OK);
		}
	}

	@PostMapping(EcommUriConstants.DELETE_DONAR_URI)
	public ResponseEntity<ApiResponseModel> deleteDonar(@RequestBody Donars donar) {
		Donars donarNew = donarServiceInf.findById(donar.getDonarId());
		if (!ObjectUtils.isEmpty(donarNew)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseModel("Donar Deleted Successfully..!!", true));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));
		}
	}

	@PostMapping(EcommUriConstants.UPDATE_DONAR_URI)
	public ResponseEntity<ApiResponseGenericModel<?>> updateDonar(@RequestBody Donars donar) {
		Donars donarNew = donarServiceInf.updateDonar(donar);
		if (!ObjectUtils.isEmpty(donarNew)) {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseGenericModel<>(donarNew, true));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseGenericModel<>("Something went wrong.!!", false));
		}
	}

	@PostMapping(EcommUriConstants.DONAR_SEARCH_CRITERIA_DONAR_URI)
	public ResponseEntity<ApiResponseGenericModel<List<Donars>>> searchCriteria(@RequestBody Donars donar) {
		List<Donars> donarNew = donarServiceInf.searchCriteria(donar);
		if (!ObjectUtils.isEmpty(donarNew)) {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseGenericModel<List<Donars>>(donarNew, true));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseGenericModel<>("Something went wrong.!!", false));
		}
	}

	@PostMapping(EcommUriConstants.DONAR_BULK_RECEIPT_GENERATE_URI)
	public ResponseEntity<ApiResponseModel> donorBulkReceiptGenerate(@RequestBody List<Donars> donar) {
		try {
			String res = donarServiceInf.donorBulkReceiptGenerate(donar);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseModel(res, true));
		} catch (CustomException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseModel(e.getMessage(), e.getSuccess()));
		}
	}

}
