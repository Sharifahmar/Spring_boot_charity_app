package com.ecomm.akhtar.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.securityconfig.CurrentUser;
import com.ecomm.akhtar.securityconfig.UserPrincipal;
import com.ecomm.akhtar.service.ImageUploadServiceInf;

@RestController
public class ImageUploadController {
	private final Logger logger = LogManager.getLogger(ImageUploadController.class);

	@Autowired
	private ImageUploadServiceInf imageUploadServiceInf;

	/**
	 * Single file upload
	 * 
	 * @param uploadfile
	 * @param request
	 * @return
	 */
	@PostMapping(value = EcommUriConstants.IMAGE_UPLOAD)
	public ResponseEntity<?> uploadFile(@RequestParam("image") MultipartFile uploadfile,
			@CurrentUser UserPrincipal currentUser) {

		Users users = null;
		logger.info("fileName : " + uploadfile.getOriginalFilename());
		logger.info("contentType : " + uploadfile.getContentType());
		logger.info("contentSize : " + uploadfile.getSize());

		if (uploadfile.isEmpty()) {
			return new ResponseEntity<>("please select an image", HttpStatus.BAD_REQUEST);
		}

		if (uploadfile.getOriginalFilename().contains("..")) {
			return new ResponseEntity<>("please select a valid file with valid name", HttpStatus.BAD_REQUEST);
		}

		try {

			try {

				users = imageUploadServiceInf.saveUploadedFiles(Arrays.asList(uploadfile), currentUser);

			} catch (CustomException e) {

				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (IOException e) {
			return new ResponseEntity<>("Error while image upload", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(users, new HttpHeaders(), HttpStatus.OK);

	}

}
