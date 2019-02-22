package com.ecomm.akhtar.model;

public class SubCategories {

	private Long subCategoryId;
	private String subCategoryName;
	private String image;
	private Long categoryId;
	private Long userId;
	private Boolean status;

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SubCategories [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", image="
				+ image + ", categoryId=" + categoryId + ", userId=" + userId + ", status=" + status + "]";
	}
	
	

}
