/**
 *
 */
package com.ecomm.akhtar.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.model.UsersUpdateModel;
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


	@Override
	public Boolean existsByPhoneNumber(String phoneNumber) {
		return !usersRepository.existsByPhoneNumber(phoneNumber);

	}

	@Override
	public Boolean existsByEmailId(String emailId) {
		return !usersRepository.existsByEmail(emailId);

	}

	/// @Cacheable(value = "users")
	@Override
	public Users getUserDetailsByIdStatus(Long id, Boolean status) throws CustomException, IOException {
		Users users = new Users();
		UsersEntity userDetails = usersRepository.findByIdAndStatus(id, status)
				.orElseThrow(() -> new CustomException("Data with Userid and Status not found ", false));
		BeanUtils.copyProperties(userDetails, users);
		users.setProfilePictureUrl(FileUtils.readFileToByteArray(new File(userDetails.getProfilePictureUrl())));
		return users;
	}

	@Override
	public UsersUpdateModel updateUserCurrentContext(UsersUpdateModel users) throws Exception {
		UsersEntity usersEntity = usersRepository.findByPhoneNumberAndStatus(users.getPhoneNumber(), true)
				.orElseThrow(() -> new Exception("Record not found with phoneNumber and status..!!"));
		BeanUtils.copyProperties(users, usersEntity);
		UsersUpdateModel users2 = new UsersUpdateModel();
		UsersEntity usersEntityNew = usersRepository.save(usersEntity);
		BeanUtils.copyProperties(usersEntityNew, users2);
		return users2;
	}

}
