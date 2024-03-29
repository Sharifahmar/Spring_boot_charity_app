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
import com.ecomm.akhtar.model.Acceptor;
import com.ecomm.akhtar.model.ApiResponseGenericModel;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.model.IdentityAvailability;
import com.ecomm.akhtar.model.UsersCheckRequest;
import com.ecomm.akhtar.service.AcceptorServiceInf;

@RestController
public class AcceptorController {

	@Autowired
	private AcceptorServiceInf acceptorServiceInf;

	@PostMapping(EcommUriConstants.ACCEPTOR_PHONENUMBER_EXIST_URI)
	public ResponseEntity<IdentityAvailability> checkUsernameAvailability(@RequestBody UsersCheckRequest acceptor) {
		Boolean isAvailable = acceptorServiceInf.existsByPhoneNumber(acceptor.getPhoneNumber());
		if (isAvailable) {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Phone Number not exist..!!"),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Phone Number already exist..!!"),
					HttpStatus.OK);
		}
	}

	
	@PostMapping(EcommUriConstants.UPDATE_ACCEPTOR_URI)
	public ResponseEntity<ApiResponseGenericModel<?>> updateDonar(@RequestBody Acceptor acceptor) {
		Acceptor acceptor2 = acceptorServiceInf.updateAcceptor(acceptor);
		if (!ObjectUtils.isEmpty(acceptor2)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseGenericModel<>(acceptor2, true));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseGenericModel<>("Something went wrong.!!", false));
		}
	}
	
	

	@PostMapping(EcommUriConstants.DELETE_ACCEPTOR_URI)
	public ResponseEntity<ApiResponseModel> deleteAcceptor(@RequestBody Acceptor acceptor) {
		Acceptor acceptorNew = acceptorServiceInf.findById(acceptor.getAcceptorId());
		if (!ObjectUtils.isEmpty(acceptorNew)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseModel("Acceptor Deleted Successfully..!!", true));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));
		}
	}

	@PostMapping(EcommUriConstants.ACCEPTOR_SEARCH_CRITERIA_DONAR_URI)
	public ResponseEntity<ApiResponseGenericModel<List<Acceptor>>> searchCriteria(@RequestBody Acceptor acceptor) {
		List<Acceptor> accptrNew = acceptorServiceInf.searchCriteria(acceptor);
		if (!ObjectUtils.isEmpty(accptrNew)) {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseGenericModel<List<Acceptor>>(accptrNew, true));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseGenericModel<>("Something went wrong.!!", false));
		}
	}
	

}
