package com.ecomm.akhtar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.ecomm.akhtar.audit.AuditModel;

@Entity
@Table(name = "DONATION_TYPE", uniqueConstraints = { @UniqueConstraint(columnNames = { "DONATION_TYPE" })})
public class DonationTypeEntity extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814595115801146324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DONATION_TYPE_ID")
	private Long donationTypeId;

	
	@Size(max = 100)
	@Column(name = "DONATION_TYPE", nullable = false)
	private String donationType;

	
	@Column(name = "DONATION_TYPE_STS", columnDefinition = "BIT", nullable = false)
	private Boolean status;

	public Long getDonationTypeId() {
		return donationTypeId;
	}


	public void setDonationTypeId(Long donationTypeId) {
		this.donationTypeId = donationTypeId;
	}


	public String getDonationType() {
		return donationType;
	}


	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}

	
	
}
