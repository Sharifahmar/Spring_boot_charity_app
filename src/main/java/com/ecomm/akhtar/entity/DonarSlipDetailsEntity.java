package com.ecomm.akhtar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ecomm.akhtar.audit.AuditModel;

@Entity
@Table(name = "DONAR_SLIP_DETAILS")
public class DonarSlipDetailsEntity extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814595115801146324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DONAR_SLIP_DETAILS_ID")
	private Long donarSlipDetailsId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private UsersEntity usersEntity;

	public Long getDonarSlipDetailsId() {
		return donarSlipDetailsId;
	}

	public void setDonarSlipDetailsId(Long donarSlipDetailsId) {
		this.donarSlipDetailsId = donarSlipDetailsId;
	}

	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}
	
	
	

}
