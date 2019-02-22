/**
 * 
 */
package com.ecomm.akhtar.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** An entity that stores file meta data into database */

@Entity
@Table(name = "USER_IMAGES")
public class ImagesEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7351225841805456232L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_ID")
	private Long id;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "FILE_TYPE")
	private String fileType;

	@Column(name = "FILE_SIZE")
	private long fileSize;
	
	@Column(name = "FILE_PATH")
	private String filePath;
	
	
	@Column(name = "IMG_STS",  nullable = false, columnDefinition = "BIT")
	private Boolean status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private UsersEntity usersEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}
	
	
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ImagesEntity [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", fileSize=" + fileSize
				+ ", filePath=" + filePath + ", status=" + status + ", usersEntity=" + usersEntity + "]";
	}


	

}
