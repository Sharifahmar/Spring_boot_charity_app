package com.ecomm.akhtar.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
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
	 * @throws URISyntaxException
	 */
	public Users saveUploadedFiles(MultipartFile files, UserPrincipal currentUser) throws IOException, CustomException {
		Users users = null;
		String currentDirectory = System.getProperty("user.dir");
		String imagePath = currentDirectory + File.separator + "IMAGES" + File.separator + currentUser.getId();
		Path path = Paths.get(imagePath);
		Path pathNew = Paths.get(path + File.separator + files.getOriginalFilename());
		if (!Files.exists(path)) {
			Files.createDirectories(path);
			Files.write(pathNew, files.getBytes());
			users = updateUserImage(pathNew, currentUser);
		} else {
			Files.write(pathNew, files.getBytes());
			users = updateUserImage(pathNew, currentUser);
		}

		return users;

	}

	private Users updateUserImage(Path pathNew, UserPrincipal currentUser) throws CustomException, IOException {

		Users users = new Users();
		UsersEntity userDetails = usersRepository.findByIdAndStatus(currentUser.getId(), true)
				.orElseThrow(() -> new CustomException("User Details not found with specific id ", false));
		userDetails.setProfilePictureUrl(pathNew.toFile().toString());
		UsersEntity userDetailsUpdated = usersRepository.save(userDetails);
		BeanUtils.copyProperties(userDetailsUpdated, users);
		users.setProfilePictureUrl(FileUtils.readFileToByteArray(pathNew.toFile()));	
		return users;

	}

}
