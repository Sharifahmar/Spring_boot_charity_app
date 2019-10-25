package com.ecomm.akhtar.service;

import org.springframework.stereotype.Service;

import com.ecomm.akhtar.model.Students;

@Service
public interface StudentServiceInf {


	Students findById(Long studentId);

	Students updateStudent(Students student);
	
	
	

}
