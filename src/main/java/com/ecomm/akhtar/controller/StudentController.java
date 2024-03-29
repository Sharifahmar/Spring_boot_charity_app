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
import com.ecomm.akhtar.model.ApiResponseGenericModel;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.model.IdentityAvailability;
import com.ecomm.akhtar.model.Students;
import com.ecomm.akhtar.service.StudentServiceInf;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceInf studentServiceInf;

	@PostMapping(EcommUriConstants.DELETE_STUDENT_URI)
	public ResponseEntity<ApiResponseModel> deleteStudent(@RequestBody Students students) {
		Students studNew = studentServiceInf.findById(students.getStudentId());
		if (!ObjectUtils.isEmpty(studNew)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseModel("Student Deleted Successfully..!!", true));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));
		}
	}

	@PostMapping(EcommUriConstants.UPDATE_STUDENT_URI)
	public ResponseEntity<ApiResponseModel> updateStudent(@RequestBody Students students) {
		Students studentNew = studentServiceInf.updateStudent(students);
		if (!ObjectUtils.isEmpty(studentNew)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseModel("Student Updated Successfully..!!", true));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseModel("Something went wrong.!!", false));
		}
	}

	@PostMapping(EcommUriConstants.STUDENT_AADHARNUMBER_EXIST_URI)
	public ResponseEntity<IdentityAvailability> checkUsernameAvailability(@RequestBody Students students) {
		Boolean isAvailable = studentServiceInf.existsByAadharNumber(students.getAadhaarNumber());
		if (isAvailable) {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Aadhar Number not exist..!!"),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Aadhar Number already exist..!!"),
					HttpStatus.OK);
		}
	}

	@PostMapping(EcommUriConstants.STUDENT_SEARCH_CRITERIA_DONAR_URI)
	public ResponseEntity<ApiResponseGenericModel<List<Students>>> searchCriteria(@RequestBody Students students) {
		List<Students> studentList = studentServiceInf.searchCriteria(students);
		if (!ObjectUtils.isEmpty(studentList)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseGenericModel<List<Students>>(studentList, true));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponseGenericModel<>("Something went wrong.!!", false));
		}
	}

}
