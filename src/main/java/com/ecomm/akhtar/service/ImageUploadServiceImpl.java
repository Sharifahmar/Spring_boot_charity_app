package com.ecomm.akhtar.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.repository.UsersRepository;
import com.ecomm.akhtar.securityconfig.UserPrincipal;

@Service
public class ImageUploadServiceImpl implements ImageUploadServiceInf {

	@Autowired
	private UsersRepository usersRepository;

	/**
	 * Method is use to save Uploaded files
	 * 
	 * @throws CustomException
	 */
	public Users saveUploadedFiles(List<MultipartFile> files, UserPrincipal currentUser)
			throws IOException, CustomException {
		String currentDirectory = System.getProperty("user.dir");
		Users users = null;
		String imagePath = currentDirectory + File.separator + "IMAGES" + File.separator + currentUser.getId();
		for (MultipartFile file : files) {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(imagePath);
			Path pathNew = Paths.get(imagePath + File.separator + file.getOriginalFilename());
			if (!Files.exists(path)) {
				Files.createDirectories(path);
				Files.write(pathNew, bytes);
				users = updateUserImage(pathNew, currentUser);
			} else {
				Files.write(pathNew, bytes);
				users = updateUserImage(pathNew, currentUser);
			}

		}
		return users;

	}

	private Users updateUserImage(Path pathNew, UserPrincipal currentUser) throws CustomException {

		Users users = new Users();
		UsersEntity userDetails = usersRepository.findByIdAndStatus(currentUser.getId(), true)
				.orElseThrow(() -> new CustomException("User Details not found with specific id ", false));
		userDetails.setProfilePictureUrl(pathNew.toString());
		UsersEntity userDetailsUpdated = usersRepository.save(userDetails);
		BeanUtils.copyProperties(userDetailsUpdated, users);
		return users;

	}

}
