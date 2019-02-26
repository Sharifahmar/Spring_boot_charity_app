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
@Table(name = "ACCEPTOR_TOKEN_DETAILS")
public class AcceptorTokenDetailsEntity extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814595115801146324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCEPTOR_TOKEN_DETAILS_ID")
	private Long acceptorTokenDetailsId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTOR_ID")
	private AcceptorEntity acceptorEntity;

	public Long getAcceptorTokenDetailsId() {
		return acceptorTokenDetailsId;
	}

	public void setAcceptorTokenDetailsId(Long acceptorTokenDetailsId) {
		this.acceptorTokenDetailsId = acceptorTokenDetailsId;
	}

	public AcceptorEntity getAcceptorEntity() {
		return acceptorEntity;
	}

	public void setAcceptorEntity(AcceptorEntity acceptorEntity) {
		this.acceptorEntity = acceptorEntity;
	}

}
