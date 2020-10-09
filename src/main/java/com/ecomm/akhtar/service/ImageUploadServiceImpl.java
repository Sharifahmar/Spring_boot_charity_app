package com.ecomm.akhtar.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.akhtar.entity.DonarsEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Donars;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.repository.DonarsRepository;
import com.ecomm.akhtar.repository.UsersRepository;
import com.ecomm.akhtar.securityconfig.UserPrincipal;

@Service
public class ImageUploadServiceImpl implements ImageUploadServiceInf {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private DonarsRepository donarsRepository;

	/**
	 * Method is use to save Uploaded file
	 * 
	 * @throws CustomException
	 * @throws URISyntaxException
	 */
	public Object saveUploadedFiles(MultipartFile files, UserPrincipal currentUser, String component)
			throws IOException, CustomException {
		String imagePath = null;
		Object newRefObj = null;
		String currentDirectory = System.getProperty("user.dir");
		switch (component) {

		case "userProfile":
			imagePath = currentDirectory + File.separator + "images" + File.separator + "User-Profile" + File.separator
					+ currentUser.getId();
			break;

		case "donor":
			imagePath = currentDirectory + File.separator + "images" + File.separator + "Donor" + File.separator
					+ currentUser.getId();
			break;
		}

		Path path = Paths.get(imagePath);
		Path pathNew = Paths.get(path + File.separator + files.getOriginalFilename());
		if (!Files.exists(path)) {
			Files.createDirectories(path);
			Files.write(pathNew, files.getBytes());
			newRefObj = updateImage(pathNew, currentUser, files, component);
		} else {
			Files.write(pathNew, files.getBytes());
			newRefObj = updateImage(pathNew, currentUser, files, component);
		}
		return newRefObj;

	}

	private Object updateImage(Path pathNew, UserPrincipal currentUser, MultipartFile file, String component)
			throws CustomException, IOException {
		Users users = new Users();
		Donars donars = new Donars();
		if ("userProfile".equalsIgnoreCase(component)) {
			UsersEntity userDetails = usersRepository.findByIdAndStatus(currentUser.getId(), true)
					.orElseThrow(() -> new CustomException("User Details not found with specific id ", false));
			userDetails.setProfilePictureUrl(pathNew.toUri().toURL().toString());
			UsersEntity userDetailsUpdated = usersRepository.save(userDetails);
			BeanUtils.copyProperties(userDetailsUpdated, users);
			users.setProfilePictureUrl("http://localhost:8081/images/" + "User-Profile/" + currentUser.getId() + "/"
					+ file.getOriginalFilename());
			return users;
		} else if ("donor".equalsIgnoreCase(component)) {
			DonarsEntity donarsEntity = Optional
					.ofNullable(donarsRepository.findByDonarIdAndStatus(currentUser.getId(), true))
					.orElseThrow(() -> new CustomException("Donar Details not found with specific id ", false));

			donarsEntity.setProfilePictureUrl(pathNew.toUri().toURL().toString());
			DonarsEntity donorDetailsUpdated = donarsRepository.save(donarsEntity);
			BeanUtils.copyProperties(donorDetailsUpdated, donars);
			donars.setProfilePictureUrl("http://localhost:8081/images/" + "Donor/" + currentUser.getId() + "/"
					+ file.getOriginalFilename());
			return donars;

		}

		return null;

	}

}
