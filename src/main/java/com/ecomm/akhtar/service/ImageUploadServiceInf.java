package com.ecomm.akhtar.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecomm.akhtar.model.FileUploadMetaDataModel;


public interface ImageUploadServiceInf {

	/**
	 * Method is use to save upload data
	 * 
	 * @param files
	 * @throws IOException
	 */

	public abstract void saveUploadedFiles(List<MultipartFile> files)
			throws IOException;

	/**
	 * Saves meta data to database
	 * 
	 * @param file
	 * @throws IOException
	 */
	public abstract void saveMetaData(MultipartFile file, Path path)
			throws IOException;

	/**
	 * Return List of all details
	 */
	public abstract List<FileUploadMetaDataModel> getfileUploadMetaData();

}