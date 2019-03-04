package com.ecomm.akhtar.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.akhtar.constants.EcommUriConstants;
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
	@PostMapping(value = EcommUriConstants.SINGLE_FILE_UPLOAD)
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile uploadfile,
			final HttpServletRequest request) {

		/** Below data is what we saving into database */
		logger.info("Single file upload!");
		logger.info("fileName : " + uploadfile.getOriginalFilename());
		logger.info("contentType : " + uploadfile.getContentType());
		logger.info("contentSize : " + uploadfile.getSize());

		if (uploadfile.isEmpty()) {
			return new ResponseEntity<>("please select a file!", HttpStatus.BAD_REQUEST);
		}

		if (uploadfile.getOriginalFilename().contains("..")) {
			return new ResponseEntity<>("please select a file!", HttpStatus.BAD_REQUEST);
		}

		try {
			/** File will get saved to file system and database */
			imageUploadServiceInf.saveUploadedFiles(Arrays.asList(uploadfile));
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("Successfully uploaded - " + uploadfile.getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);

	}

	/**
	 * Multiple files to upload
	 * 
	 * @param extraField
	 * @param uploadfiles
	 * @return
	 */
	@PostMapping(value = EcommUriConstants.MULTI_FILE_UPLOAD)
	public ResponseEntity<String> uploadFileMulti(@RequestParam("files") MultipartFile[] uploadfiles) {
		logger.info("Multiple file upload!");
		String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
				.filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
		if (StringUtils.isEmpty(uploadedFileName)) {
			return new ResponseEntity<>("please select files!", HttpStatus.OK);
		}

		if (uploadfiles.length == 0) {
			return new ResponseEntity<>("please select files!", HttpStatus.OK);
		}

		try {
			/** File will get saved to file system and database */
			imageUploadServiceInf.saveUploadedFiles(Arrays.asList(uploadfiles));
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Successfully uploaded - " + uploadedFileName, HttpStatus.OK);

	}

	/**
	 * Rest endpoint api to get uploaded files
	 * 
	 * @return
	 */
	/*
	 * @GetMapping(value = "/getFileUploadMetaData") public ResponseEntity<?>
	 * getAllDetails() {
	 * 
	 * List<FileUploadMetaDataModel> fileMetaDataList =
	 * imageUploadServiceInf.getfileUploadMetaData();
	 * 
	 * try { if (!fileMetaDataList.isEmpty()) { return new
	 * ResponseEntity<>(fileMetaDataList, HttpStatus.OK); }
	 * 
	 * } catch (Exception e) { logger.error(arg0); }
	 * 
	 * return new ResponseEntity<>(new
	 * ApiResponseModel("Error While getting data.!!", false),
	 * HttpStatus.INTERNAL_SERVER_ERROR);
	 * 
	 * }
	 */
}
