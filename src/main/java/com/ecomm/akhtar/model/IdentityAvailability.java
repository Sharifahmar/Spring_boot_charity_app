package com.ecomm.akhtar.model;

public class IdentityAvailability {
	private Boolean available;

	private String response;

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public IdentityAvailability(Boolean available, String response) {

		this.available = available;
		this.response = response;
	}

	public IdentityAvailability(Boolean available) {

		this.available = available;
	}

}
