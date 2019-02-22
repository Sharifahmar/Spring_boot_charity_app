package com.ecomm.akhtar.model;

public class NewsCategories extends AuditModel{

	private int newsCategoryId;
	private String newsName;
	private String image;
	private Boolean status;
	public int getNewsCategoryId() {
		return newsCategoryId;
	}
	public void setNewsCategoryId(int newsCategoryId) {
		this.newsCategoryId = newsCategoryId;
	}
	public String getNewsName() {
		return newsName;
	}
	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	

}
