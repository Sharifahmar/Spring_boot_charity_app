package com.ecomm.akhtar.service;

import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.StudentStatModel;

public interface StudentStationaryServiceInf {

	String addStudentStationaryDetailsService(StudentStatModel studentStatModel) throws CustomException;

}