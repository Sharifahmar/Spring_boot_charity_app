package com.ecomm.akhtar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ecomm.akhtar.audit.AuditModel;

@Entity
@Table(name = "DONATION_AMOUNT")
public class DonationAmountEntity extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814595115801146324L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
	@SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
	@Column(name = "DONATION_AMOUNT_ID")
	private Long donationAmountId;


	@Column(name = "DONATION_AMOUNT_STS", columnDefinition = "BIT", nullable = false)
	private Boolean status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private UsersEntity usersEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DONAR_ID")
	private DonarsEntity donarsEntity;

	

	public Long getDonationAmountId() {
		return donationAmountId;
	}

	public void setDonationAmountId(Long donationAmountId) {
		this.donationAmountId = donationAmountId;
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


	public DonarsEntity getDonarsEntity() {
		return donarsEntity;
	}

	public void setDonarsEntity(DonarsEntity donarsEntity) {
		this.donarsEntity = donarsEntity;
	}

}
