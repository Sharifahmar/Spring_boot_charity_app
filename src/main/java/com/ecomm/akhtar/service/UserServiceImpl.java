/**
 *
 */
package com.ecomm.akhtar.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.model.UsersUpdateModel;
import com.ecomm.akhtar.repository.UsersRepository;
import com.ecomm.akhtar.securityconfig.UserPrincipal;

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

	@Override
	public Users getUserDetailsByIdStatus(UserPrincipal currentUser, Boolean status)
			throws CustomException, IOException, URISyntaxException {
		Users users = new Users();
		UsersEntity userDetails = usersRepository.findByIdAndStatus(currentUser.getId(), status)
				.orElseThrow(() -> new CustomException("Data with Userid and Status not found ", false));
		BeanUtils.copyProperties(userDetails, users);
		return users;
	}

	@Override
	public UsersUpdateModel updateUserCurrentContext(UsersUpdateModel users) throws CustomException {
		UsersEntity usersEntityNew2 = new UsersEntity();
		UsersEntity usersEntity = usersRepository.findByPhoneNumberAndStatus(users.getPhoneNumber(), true)
				.orElseThrow(() -> new CustomException("Record not found with phoneNumber and status..!!",false));
		BeanUtils.copyProperties(users, usersEntityNew2);
		usersEntityNew2.setId(usersEntity.getId());
		usersEntityNew2.setProfilePictureUrl(usersEntity.getProfilePictureUrl());
		usersEntityNew2.setPassword(usersEntity.getPassword());
		usersEntityNew2.setStatus(usersEntity.getStatus());
		usersEntityNew2.setProfilePicture(usersEntity.getProfilePicture());
		usersEntityNew2.setRoles(usersEntity.getRoles());
		UsersUpdateModel users2 = new UsersUpdateModel();
		UsersEntity usersEntityNew = usersRepository.save(usersEntityNew2);
		BeanUtils.copyProperties(usersEntityNew, users2);
		return users2;
	}

}
