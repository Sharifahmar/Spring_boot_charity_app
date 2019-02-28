package com.ecomm.akhtar.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.ecomm.akhtar.audit.AuditModel;

@Entity
@Table(name = "STUDENT_STATIONARY", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "STUDENT_STATIONARY_TYPE" }) })
public class StudentsStationaryEntity extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814595115801146324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_STATIONARY_ID")
	private Long studentStationaryId;

	@Size(max = 100)
	@Column(name = "STUDENT_STATIONARY_TYPE", nullable = false)
	private String studentStationaryType;

	@Column(name = "STUDENT_STATIONARY_STS", columnDefinition = "BIT", nullable = false)
	private Boolean status;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "STUDENTS_ID")
	private StudentsEntity studentsEntity;

	public String getStudentStationaryType() {
		return studentStationaryType;
	}

	public void setStudentStationaryType(String studentStationaryType) {
		this.studentStationaryType = studentStationaryType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getStudentStationaryId() {
		return studentStationaryId;
	}

	public void setStudentStationaryId(Long studentStationaryId) {
		this.studentStationaryId = studentStationaryId;
	}

	public StudentsEntity getStudentsEntity() {
		return studentsEntity;
	}

	public void setStudentsEntity(StudentsEntity studentsEntity) {
		this.studentsEntity = studentsEntity;
	}
	

}
