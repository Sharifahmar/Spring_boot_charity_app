package com.ecomm.akhtar.model;

public class DeliveryStatus {

	private int deliveryStatusId;
	private String deliveryStatusType;
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
