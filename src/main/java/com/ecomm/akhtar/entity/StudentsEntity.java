/**
 *
 */
package com.ecomm.akhtar.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ecomm.akhtar.audit.AuditModel;

/**
 * @author Ahmar
 *
 */
@Entity
@Table(name = "STUDENTS")
public class StudentsEntity extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENTS_ID")
	private Long studentId;

	@Size(max = 100)
	@Column(name = "STUDENTS_ID_NUMBER")
	private String idNumber;

	@Size(max = 100)
	@Column(name = "STUDENTS_SUB_ID")
	private String subId;

	@Size(max = 100)
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Size(max = 100)
	@Column(name = "LAST_NAME")
	private String lastName;

	@Size(max = 100)

	@Column(name = "AADHAAR_NUMBER", nullable = false)
	private String aadhaarNumber;

	@Size(max = 100)
	@Column(name = "MOTHER_NAME")
	private String motherName;

	@Size(max = 100)
	@Column(name = "FATHER_NAME")
	private String fatherName;

	@Column(name = "SCHOOL_NAME", columnDefinition = "TEXT")
	private String schoolName;

	@Size(max = 100)
	@Column(name = "CLASS_NAME")
	private String className;

	@Size(max = 100)
	@Column(name = "GRADE")
	private String grade;

	@Column(name = "ADDRESS", columnDefinition = "TEXT")
	private String address;

	@Size(max = 100)
	@Column(name = "CITY")
	private String city;

	@Size(max = 100)
	@Column(name = "STATE")
	private String state;

	@Size(max = 100)
	@Column(name = "COUNTRY")
	private String country;

	@Size(max = 100)
	@Column(name = "ZIPCODE")
	private String zipCode;

	@Size(max = 100)
	@Column(name = "PHONE", nullable = false)
	private String phoneNumber;

	@Column(name = "STUDENT_STS", nullable = false, columnDefinition = "BIT")
	private Boolean status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentsEntity")
	private Set<StudentsStationaryEntity> studentsStationaryEntities;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<StudentsStationaryEntity> getStudentsStationaryEntities() {
		return studentsStationaryEntities;
	}

	public void setStudentsStationaryEntities(Set<StudentsStationaryEntity> studentsStationaryEntities) {
		this.studentsStationaryEntities = studentsStationaryEntities;
	}

}
