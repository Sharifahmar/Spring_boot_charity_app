/**
 * 
 */
package com.ecomm.akhtar.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.entity.StudentsEntity;
import com.ecomm.akhtar.model.Students;
import com.ecomm.akhtar.repository.StudentsRepository;

/**
 * @author Ahmar
 *
 */
@Component
public class StudentServiceImpl implements StudentServiceInf {

	@Autowired
	private StudentsRepository studentsRepository;

	@Override
	public Students findById(Long studentId) {
		Students students = new Students();
		Optional<StudentsEntity> studentEntity = studentsRepository.findById(studentId);
		if (studentEntity.isPresent()) {
			studentEntity.get().setStatus(false);
			StudentsEntity studentEntityNew = studentsRepository.save(studentEntity.get());
			BeanUtils.copyProperties(studentEntityNew, students);
		}
		return students;
	}

	@Override
	public Students updateStudent(Students students) {
		Students studentsNew = new Students();
		Optional<StudentsEntity> studEntity = studentsRepository.findById(students.getStudentId());
		if (studEntity.isPresent()) {
			StudentsEntity stEntity = new StudentsEntity();
			BeanUtils.copyProperties(students, stEntity);
			stEntity.setPhoneNumber(studEntity.get().getPhoneNumber());
			stEntity.setAadhaarNumber(studEntity.get().getAadhaarNumber());
			StudentsEntity studentEntity = studentsRepository.save(stEntity);
			BeanUtils.copyProperties(studentEntity, studentsNew);
		}
		return studentsNew;
	}

	@Override
	public Boolean existsByAadharNumber(String aadharNumber) {
		return !studentsRepository.existsByAadhaarNumber(aadharNumber);
	}

	@Override
	public List<Students> searchCriteria(Students students) {
		StudentsEntity studentsEntity = new StudentsEntity();
		studentsEntity.setFirstName(students.getFirstName());
		studentsEntity.setPhoneNumber(students.getPhoneNumber());
		studentsEntity.setAadhaarNumber(students.getAadhaarNumber());
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
		Example<StudentsEntity> exampleQuery = Example.of(studentsEntity, matcher);
		List<StudentsEntity> studentEntity = (List<StudentsEntity>) studentsRepository.findAll(exampleQuery);
		return studentEntity.stream().map(x -> {
			Students studentsRtrn = new Students();
			BeanUtils.copyProperties(x, studentsRtrn);
			return studentsRtrn;
		}).collect(Collectors.toList());
	}

}
