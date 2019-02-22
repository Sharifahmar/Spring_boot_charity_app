/*package com.ecomm.akhtar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DELIVERY_STATUS")
public class DeliveryStatusEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DELVRY_ID")
	private int deliveryStatusId;

	@Size(max = 100)
	@Column(name = "DELVRY_STS_TYPE")
	private String deliveryStatusType;

	@Column(name = "DELVRY_STS", nullable = false, columnDefinition = "BIT DEFAULT 1")
	private Boolean status;

	public int getDeliveryStatusId() {
		return deliveryStatusId;
	}

	public void setDeliveryStatusId(int deliveryStatusId) {
		this.deliveryStatusId = deliveryStatusId;
	}

	public String getDeliveryStatusType() {
		return deliveryStatusType;
	}

	public void setDeliveryStatusType(String deliveryStatusType) {
		this.deliveryStatusType = deliveryStatusType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
*/