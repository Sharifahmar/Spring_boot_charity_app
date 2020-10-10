package com.ecomm.akhtar.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.web.multipart.MultipartFile;

import com.ecomm.akhtar.exception.CustomException;


public interface ImageUploadServiceInf {

	/**
	 * Method is use to save upload data
	 * 
	 * @param files
	 * @return 
	 * @throws IOException
	 * @throws CustomException 
	 * @throws URISyntaxException 
	 */

	public abstract Object saveUploadedFiles(MultipartFile files,Long id,String component)
			throws IOException, CustomException;


}