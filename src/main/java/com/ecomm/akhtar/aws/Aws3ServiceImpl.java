/**
 * 
 *//*
package com.ecomm.akhtar.aws;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.entity.CategoriesEntity;
import com.ecomm.akhtar.entity.ImagesEntity;
import com.ecomm.akhtar.entity.SubCategoriesEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.repository.CategoriesRepository;
import com.ecomm.akhtar.repository.ImagesRepository;
import com.ecomm.akhtar.repository.SubCategoriesRepository;
import com.ecomm.akhtar.repository.UsersRepository;

*//**
 * @author Ahmar
 *
 *//*
@Component
public class Aws3ServiceImpl implements IAws3Service {

	@Autowired
	private AmazonS3 amazonS3;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ImagesRepository imagesRepository;
	@Autowired
	private CategoriesRepository categoriesRepository;
	@Autowired
	private SubCategoriesRepository subCategoriesRepository;

	@Autowired
	AwsConfig awsConfig;

	String folderKey = "";

	private PutObjectResult upload(InputStream inputStream, String uploadKey, Long id, String type)
			throws CustomException {
		caseValue(type, id, uploadKey);
		PutObjectRequest putObjectRequest = new PutObjectRequest(awsConfig.getBucket(), folderKey, inputStream,
				new ObjectMetadata());
		putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
		PutObjectResult putObjectResult = amazonS3.putObject(putObjectRequest);
		IOUtils.closeQuietly(inputStream);
		return putObjectResult;
	}

	public List<PutObjectResult> upload(MultipartFile[] multipartFiles, Long id, String type) {
		List<PutObjectResult> putObjectResults = new ArrayList<>();
		Arrays.stream(multipartFiles).filter(multipartFile -> !StringUtils.isEmpty(multipartFile.getOriginalFilename()))
				.forEach(multipartFile -> {
					try {
						putObjectResults.add(
								upload(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), id, type));

						saveMetaData(multipartFile, id, type);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});

		return putObjectResults;
	}

	public List<S3ObjectSummary> list() {
		ObjectListing objectListing = amazonS3
				.listObjects(new ListObjectsRequest().withBucketName(awsConfig.getBucket()));
		List<S3ObjectSummary> s3ObjectSummaries = objectListing.getObjectSummaries();
		return s3ObjectSummaries;
	}

	*//**
	 * Method is use to save metadata of multipart
	 * 
	 * @throws Exception
	 *//*
	private void saveMetaData(MultipartFile file, Long id, String type) throws Exception {

		if (type.equalsIgnoreCase(EcommUriConstants.USERS)) {
			userOperations(file, id);
		}

		if (type.equalsIgnoreCase(EcommUriConstants.CATEGORIES)) {
			categoryOperation(file, id, type);
		}

		if (type.equalsIgnoreCase(EcommUriConstants.SUB_CATEGORIES)) {
			subCategoryOperation(file, id, type);
		}

	}

	private void caseValue(String type, Long id, String uploadKey) throws CustomException {

		switch (type) {
		case "USERS":
			folderKey = Long.toString(id) + "/" + uploadKey;
			break;
		case "CATEGORIES":
			CategoriesEntity categoryId = categoriesRepository.findById(id)
					.orElseThrow(() -> new CustomException("CategoryId not found in records..!!", false));

			folderKey = Long.toString(categoryId.getUsersEntity().getId()) + "/" + type + "/" + Long.toString(id) + "/"
					+ uploadKey;
			break;
		case "SUB_CATEGORIES":

			SubCategoriesEntity subCategoryId = subCategoriesRepository.findById(id)
					.orElseThrow(() -> new CustomException("SubCategoryId not found  in records..!!", false));

			folderKey = Long.toString(subCategoryId.getUsersEntity().getId()) + "/" + EcommUriConstants.CATEGORIES + "/"
					+ Long.toString(subCategoryId.getCategoriesEntity().getCategoryId()) + "/" + type + "/"
					+ Long.toString(subCategoryId.getSubCategoryId()) + "/" + uploadKey;
			break;
		default:
			throw new CustomException("Type of input to upload file not proper", false);
		}
	}

	private void userOperations(MultipartFile file, Long id) throws Exception {
		ImagesEntity imgMetaData = new ImagesEntity();
		if (id != null) {
			String path = EcommUriConstants.AWS_BUCKET + Long.toString(id) + "/" + file.getOriginalFilename();

			Optional<ImagesEntity> imagesEntity = imagesRepository.findByIdImgAndStatus(id, true);

			if (imagesEntity.isPresent()) {
				imagesEntity.get().setStatus(false);
				imagesRepository.save(imagesEntity.get());
				UsersEntity usersEntity = usersRepository.findById(id)
						.orElseThrow(() -> new Exception("User not found in records"));
				imgMetaData.setUsersEntity(usersEntity);
				imgMetaData.setFileName(file.getOriginalFilename());
				imgMetaData.setFileType(file.getContentType());
				imgMetaData.setFileSize(file.getSize());
				imgMetaData.setFilePath(path);
				imgMetaData.setStatus(true);
				imagesRepository.save(imgMetaData);

			} else {

				UsersEntity usersEntity = usersRepository.findById(id)
						.orElseThrow(() -> new Exception("User not found in records"));
				imgMetaData.setUsersEntity(usersEntity);
				imgMetaData.setFileName(file.getOriginalFilename());
				imgMetaData.setFileType(file.getContentType());
				imgMetaData.setFileSize(file.getSize());
				imgMetaData.setFilePath(path);
				imgMetaData.setStatus(true);
				imagesRepository.save(imgMetaData);
			}

		}
	}

	private void categoryOperation(MultipartFile file, Long id, String type) throws CustomException {
		if (id != null) {

			CategoriesEntity categoryEntity = categoriesRepository.findByCategoryIdAndStatus(id, true)
					.orElseThrow(() -> new CustomException("CategoryId not found with status in  record..!!", false));
			String path = EcommUriConstants.AWS_BUCKET + Long.toString(categoryEntity.getUsersEntity().getId()) + "/"
					+ type + "/" + Long.toString(categoryEntity.getUsersEntity().getId()) + "/" + Long.toString(id)
					+ "/" + file.getOriginalFilename();

			categoryEntity.setImage(path);
			categoriesRepository.save(categoryEntity);

		}

	}

	private void subCategoryOperation(MultipartFile file, Long id, String type) throws CustomException {
		if (id != null) {

			SubCategoriesEntity subCategoriesEntity = subCategoriesRepository.findById(id)
					.orElseThrow(() -> new CustomException("SubCategoryId not found  in records..!!", false));

			String path = EcommUriConstants.AWS_BUCKET + Long.toString(subCategoriesEntity.getUsersEntity().getId())
					+ "/" + EcommUriConstants.CATEGORIES + "/"
					+ Long.toString(subCategoriesEntity.getCategoriesEntity().getCategoryId()) + "/" + type + "/"
					+ Long.toString(subCategoriesEntity.getSubCategoryId()) + "/" + file.getOriginalFilename();
			subCategoriesEntity.setImage(path);
			subCategoriesRepository.save(subCategoriesEntity);

		}

	}
}
*/