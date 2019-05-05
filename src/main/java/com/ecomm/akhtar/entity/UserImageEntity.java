package com.ecomm.akhtar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** An entity that stores file meta data into database */
@Entity
@Table(name = "USER_IMAGES")
public class UserImageEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "FILE_ID")
	private long fileId;
	@Column(name = "FILE_NAME")
	private String fileName;
	@Column(name = "FILE_PATH")
	private String filePath;
	@Column(name = "FILE_TYPE")
	private String fileType;
	@Column(name = "IMG_STS", nullable = false, columnDefinition = "BIT")
	private Boolean status;

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
