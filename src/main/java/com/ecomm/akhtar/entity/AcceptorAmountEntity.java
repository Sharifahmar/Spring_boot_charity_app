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
import javax.validation.constraints.Size;

import com.ecomm.akhtar.audit.AuditModel;

@Entity
@Table(name = "ACCEPTOR_AMOUNT")
public class AcceptorAmountEntity extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814595115801146324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCEPTOR_AMOUNT_ID")
	private Long acceptorAmountId;

	@Size(max = 100)
	@Column(name = "ACCEPTOR_AMOUNT", nullable = false)
	private String acceptorAmount;

	@Column(name = "ACCEPTOR_AMOUNT_STS", columnDefinition = "BIT", nullable = false)
	private Boolean status;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCEPTOR_ID")
	private AcceptorEntity acceptorEntity;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DONATION_TYPE_ID")
	private DonationTypeEntity donationTypeEntity;

	public Long getAcceptorAmountId() {
		return acceptorAmountId;
	}

	public void setAcceptorAmountId(Long acceptorAmountId) {
		this.acceptorAmountId = acceptorAmountId;
	}

	public String getAcceptorAmount() {
		return acceptorAmount;
	}

	public void setAcceptorAmount(String acceptorAmount) {
		this.acceptorAmount = acceptorAmount;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public AcceptorEntity getAcceptorEntity() {
		return acceptorEntity;
	}

	public void setAcceptorEntity(AcceptorEntity acceptorEntity) {
		this.acceptorEntity = acceptorEntity;
	}

	public DonationTypeEntity getDonationTypeEntity() {
		return donationTypeEntity;
	}

	public void setDonationTypeEntity(DonationTypeEntity donationTypeEntity) {
		this.donationTypeEntity = donationTypeEntity;
	}
	
	
	

}
