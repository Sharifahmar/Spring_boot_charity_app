package com.ecomm.akhtar.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.ApiResponseGenericModel;
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
	public ResponseEntity<ApiResponseGenericModel<?>> uploadFile(@RequestParam("image") MultipartFile uploadfile, @PathVariable("component") String component,@PathVariable("id") Long id) {
		
		Object obj = null;
		
		logger.info("fileName : " + uploadfile.getOriginalFilename());
		logger.info("contentType : " + uploadfile.getContentType());
		logger.info("contentSize : " + uploadfile.getSize());

		if (uploadfile.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponseGenericModel<>("please select an image", false));
		}

		if (uploadfile.getOriginalFilename().contains("..")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponseGenericModel<>("please select a valid file with valid name", false));
		}

		try {

			obj = imageUploadServiceInf.saveUploadedFiles(uploadfile, id, component);

		} catch (IOException | CustomException e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseGenericModel<>(e.getMessage(), false));

		}

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseGenericModel<>(obj, true));

	}

}
