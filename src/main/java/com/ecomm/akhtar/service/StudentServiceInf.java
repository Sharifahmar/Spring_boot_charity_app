package com.ecomm.akhtar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomm.akhtar.model.Students;

@Service
public interface StudentServiceInf {


	Students findById(Long studentId);

	Students updateStudent(Students student);

	Boolean existsByAadharNumber(String aadharNumber);

	List<Students> searchCriteria(Students students);
	
	
	

}
