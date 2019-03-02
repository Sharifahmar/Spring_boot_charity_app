/**
 * 
 */
package com.ecomm.akhtar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.model.StudentStatModel;
import com.ecomm.akhtar.service.StudentStationaryServiceInf;

/**
 * @author Ahmar
 *
 */
@RestController
public class StudentStationaryController {

	@Autowired
	private StudentStationaryServiceInf studentStationaryServiceInf;

	@PostMapping(EcommUriConstants.STUDENT_STATIONARY)
	public ResponseEntity<ApiResponseModel> addStudentStationaryDetails(
			@Valid @RequestBody StudentStatModel studStatModel) {

		try {
			String msg = studentStationaryServiceInf.addStudentStationaryDetailsService(studStatModel);

			return new ResponseEntity<>(new ApiResponseModel(msg, true), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(
					new ApiResponseModel("Error Occured while while assigning stationary to student..!!", false),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
