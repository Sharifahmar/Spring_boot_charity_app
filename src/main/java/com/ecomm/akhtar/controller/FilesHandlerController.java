/*package com.ecomm.akhtar.controller;

import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.ecomm.akhtar.aws.AwsConfig;
import com.ecomm.akhtar.aws.IAws3Service;
import com.ecomm.akhtar.entity.ImagesEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.repository.ImagesRepository;
import com.ecomm.akhtar.securityconfig.CurrentUser;
import com.ecomm.akhtar.securityconfig.UserPrincipal;

@RestController
public class FilesHandlerController {
	@Autowired
	private IAws3Service iAws3Service;

	@Autowired
	private AwsConfig awsConfig;

	@Autowired
	private AmazonS3 amazonS3;

	@Autowired
	private ImagesRepository imagesRepository;

	// @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@PostMapping(value = "/upload")
	public ResponseEntity<ApiResponseModel> upload(@RequestPart("file") MultipartFile[] multipartFiles,
			@RequestPart("type") String type, @RequestPart("id") String id) throws CustomException {
		if (id != null) {
			try {
				long value = Long.parseLong(id);
				iAws3Service.upload(multipartFiles, value, type);
			} catch (Exception e) {
				throw new CustomException("Error while uploading file" + e.getMessage(), false);
			}
		} else {
			throw new CustomException("Empty or Null Id found in User request", false);
		}

		return new ResponseEntity<>(new ApiResponseModel("File successfully uploaded !", true), HttpStatus.OK);

	}

	// @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping(value = "/download")
	public ResponseEntity<?> download(@RequestParam String key, @RequestParam("id") Long id) throws CustomException {
		String folderKey = Long.toString(id) + "/" + key;

		try {
			GetObjectRequest getObjectRequest = new GetObjectRequest(awsConfig.getBucket(), folderKey);

			S3Object s3Object = amazonS3.getObject(getObjectRequest);

			S3ObjectInputStream objectInputStream = s3Object.getObjectContent();

			byte[] bytes = IOUtils.toByteArray(objectInputStream);
			ImagesEntity imagesEntity = imagesRepository.findByFileType(id, key);
			String mType = imagesEntity.getFileType();
			String fileName = URLEncoder.encode(key, "UTF-8").replaceAll("\\+", "%20");
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.parseMediaType(mType));
			httpHeaders.setContentDispositionFormData("attachment", fileName);
			return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);

		} catch (Exception e) {
			// e.printStackTrace();
			throw new CustomException("Error while downloading file" + e.getMessage(), false);
		}

	}

	// @PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/list")
	public ResponseEntity<?> list() throws CustomException {
		List<S3ObjectSummary> detailList = iAws3Service.list();
		if (detailList.isEmpty()) {

			throw new CustomException("List of Object is empty", false);
		}
		return new ResponseEntity<>(detailList, HttpStatus.OK);

	}
}
*/