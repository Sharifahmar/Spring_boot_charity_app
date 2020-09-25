package com.ecomm.akhtar.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.web.multipart.MultipartFile;

import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.securityconfig.UserPrincipal;


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

	public abstract Users saveUploadedFiles(MultipartFile files,UserPrincipal currentUser)
			throws IOException, CustomException;


}