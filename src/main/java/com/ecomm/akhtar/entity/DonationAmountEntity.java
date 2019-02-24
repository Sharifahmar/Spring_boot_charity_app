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
@Table(name = "DONATION_AMOUNT")
public class DonationAmountEntity extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814595115801146324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DONATION_AMOUNT_ID")
	private Long donationAmountId;

	@Size(max = 100)
	@Column(name = "DONATION_AMOUNT", nullable = false)
	private String donationAmount;

	@Column(name = "DONATION_AMOUNT_STS", columnDefinition = "BIT", nullable = false)
	private Boolean status;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private UsersEntity usersEntity;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DONATION_TYPE_ID")
	private DonationTypeEntity donationTypeEntity;

	public Long getDonationAmountId() {
		return donationAmountId;
	}

	public void setDonationAmountId(Long donationAmountId) {
		this.donationAmountId = donationAmountId;
	}

	public String getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(String donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}

	public DonationTypeEntity getDonationTypeEntity() {
		return donationTypeEntity;
	}

	public void setDonationTypeEntity(DonationTypeEntity donationTypeEntity) {
		this.donationTypeEntity = donationTypeEntity;
	}

}
