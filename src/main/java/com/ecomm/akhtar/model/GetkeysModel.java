/**
 *
 */
package com.ecomm.akhtar.model;

/**
 * @author Ahmar
 *
 */
public class GetkeysModel {

	private String key;
	private String privateKey;

	public GetkeysModel(String key, String privateKey) {
		super();
		this.key = key;
		this.privateKey = privateKey;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

}
