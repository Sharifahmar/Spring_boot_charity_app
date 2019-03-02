package com.ecomm.akhtar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.ecomm.akhtar.entity.DonarSlipDetailsEntity;
import com.ecomm.akhtar.entity.StudentsEntity;
import com.ecomm.akhtar.entity.StudentsStationaryEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.StudentStatModel;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.repository.DonarSlipDetailsRepository;
import com.ecomm.akhtar.repository.StudentsRepository;
import com.ecomm.akhtar.repository.StudentsStationaryRepository;
import com.ecomm.akhtar.repository.UsersRepository;

@Component
public class StudentStationaryServiceImpl implements StudentStationaryServiceInf {
	@Autowired
	private StudentsRepository studentsRepository;

	@Autowired
	private StudentsStationaryRepository studentsStationaryRepository;

	StudentsStationaryEntity studentsStationaryEntity = null;

	String message = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ecomm.akhtar.service.StudentStationaryServiceInf#
	 * addStudentStationaryDetailsService(com.ecomm.akhtar.model.StudentStatModel)
	 */
	@Override
	public String addStudentStationaryDetailsService(StudentStatModel studentStatModel) throws CustomException {

		studentsStationaryEntity = new StudentsStationaryEntity();

		StudentsEntity studData = studentsRepository
				.findByIdAndStatus(studentStatModel.getStudentsModel().getId(), true)
				.orElseThrow(() -> new CustomException("User not found with specific details..!!", false));

		studentsStationaryEntity.setStudentsEntity(studData);
		studentsStationaryEntity
				.setStudentStationaryType(StringUtils.capitalize(studentStatModel.getStudentStationaryType()));

		StudentsStationaryEntity studStationaryEntity = studentsStationaryRepository.save(studentsStationaryEntity);

		if (!ObjectUtils.isEmpty(studStationaryEntity)) {

			message = "Student Stationary" + studStationaryEntity.getStudentStationaryType()
					+ "assigned Successfully..!!";
		} else {
			message = "Error Occurred while assigning stationary to student..!!";
		}
		return message;

	}

}
