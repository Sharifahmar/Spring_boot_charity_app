/**
 *
 */
package com.ecomm.akhtar.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.entity.ImagesEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.ImagesModel;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.repository.ImagesRepository;
import com.ecomm.akhtar.repository.UsersRepository;

/**
 * @author Ahmar
 *
 */
@Component
public class UserServiceImpl implements UserServiceInf {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private ImagesRepository imagesRepository;

	@Override
	public Boolean existsByPhoneNumber(String phoneNumber) {
		return !usersRepository.existsByPhoneNumber(phoneNumber);

	}

	@Override
	public Boolean existsByEmailId(String emailId) {
		return !usersRepository.existsByEmail(emailId);

	}

	///@Cacheable(value = "users")
	@Override
	public Users getUserDetailsByIdStatus(Long id, Boolean status) throws CustomException {
		UsersEntity userDetails = usersRepository.findByIdAndStatus(id, status)
				.orElseThrow(() -> new CustomException("Data with Userid and Status not found ", false));
		Optional<ImagesEntity> usersImage = imagesRepository.findByIdImgAndStatus(id, status);
		Users users = new Users();
		if (usersImage.isPresent()) {
			BeanUtils.copyProperties(userDetails, users);
			ImagesModel imagesModel = new ImagesModel();
			imagesModel.setFileName(usersImage.get().getFileName());
			imagesModel.setFileSize(usersImage.get().getFileSize());
			imagesModel.setFileType(usersImage.get().getFileType());
			imagesModel.setId(usersImage.get().getId());
			imagesModel.setStatus(usersImage.get().getStatus());
			imagesModel.setFilePath(usersImage.get().getFilePath());
			users.setImages(imagesModel);

		} else {
			BeanUtils.copyProperties(userDetails, users);
//			ImagesModel imagesModel = new ImagesModel();
//			imagesModel.setFileName(EcommUriConstants.AWS_BUCKET_DEFAULT_IMAGE);
//			users.setImages(imagesModel);
		}

		return users;
	}

	@Override
	public Users updateUserCurrentContext(Users users) throws Exception {

		UsersEntity usersEntity = usersRepository.findByIdAndStatus(users.getId(), true)
				.orElseThrow(() -> new Exception("Record not found with userID and status..!!"));
		BeanUtils.copyProperties(users, usersEntity);
		Users users2 = new Users();
		UsersEntity usersEntityNew = usersRepository.save(usersEntity);
		BeanUtils.copyProperties(usersEntityNew, users2);
		return users2;
	}

}
