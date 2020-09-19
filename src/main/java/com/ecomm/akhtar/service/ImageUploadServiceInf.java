package com.ecomm.akhtar.service;

import java.io.IOException;
import java.util.List;

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
	 */

	public abstract Users saveUploadedFiles(List<MultipartFile> files,UserPrincipal currentUser)
			throws IOException, CustomException;


}