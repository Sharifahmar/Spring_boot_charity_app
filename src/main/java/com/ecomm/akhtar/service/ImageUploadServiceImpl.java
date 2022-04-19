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

import com.ecomm.akhtar.entity.AcceptorEntity;
import com.ecomm.akhtar.entity.DonarsEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.Acceptor;
import com.ecomm.akhtar.model.Donars;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.repository.DonarsRepository;
import com.ecomm.akhtar.repository.UsersRepository;
import com.ecomm.akhtar.repository.AcceptorRepository;

@Service
public class ImageUploadServiceImpl implements ImageUploadServiceInf {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private DonarsRepository donarsRepository;

	@Autowired
	private AcceptorRepository acceptorRepository;

	/**
	 * Method is use to save Uploaded file
	 * 
	 * @throws CustomException
	 * @throws URISyntaxException
	 */
	public Object saveUploadedFiles(MultipartFile files, Long id, String component)
			throws IOException, CustomException {
		String imagePath = null;
		Object newRefObj = null;
		String currentDirectory = System.getProperty("user.dir");
		switch (component) {

		case "userProfile":
			imagePath = currentDirectory + File.separator + "profile-images" + File.separator + "User-Profile" + File.separator
					+ id;
			break;

		case "donor":
			imagePath = currentDirectory + File.separator + "profile-images" + File.separator + "Donor" + File.separator + id;
			break;

		case "acceptor":
			imagePath = currentDirectory + File.separator + "profile-images" + File.separator + "Acceptor" + File.separator
					+ id;
			break;
		}

		Path path = Paths.get(imagePath);
		Path pathNew = Paths.get(path + File.separator + files.getOriginalFilename());
		if (!Files.exists(path)) {
			Files.createDirectories(path);
			Files.write(pathNew, files.getBytes());
			newRefObj = updateImage(pathNew, id, files, component);
		} else {
			Files.write(pathNew, files.getBytes());
			newRefObj = updateImage(pathNew, id, files, component);
		}
		return newRefObj;

	}

	private Object updateImage(Path pathNew, Long id, MultipartFile file, String component)
			throws CustomException, IOException {
		Users users = new Users();
		Donars donars = new Donars();
		Acceptor acceptor = new Acceptor();
		if ("userProfile".equalsIgnoreCase(component)) {
			UsersEntity userDetails = usersRepository.findByIdAndStatus(id, true)
					.orElseThrow(() -> new CustomException("User Details not found with specific id ", false));
			userDetails.setProfilePicture(pathNew.toUri().toURL().toString());
			userDetails.setProfilePictureUrl(
					"http://localhost:8081/profile-images/" + "User-Profile/" + id + "/" + file.getOriginalFilename());
			UsersEntity userDetailsUpdated = usersRepository.save(userDetails);
			BeanUtils.copyProperties(userDetailsUpdated, users);
			return users;
		} else if ("donor".equalsIgnoreCase(component)) {
			DonarsEntity donarsEntity = Optional.ofNullable(donarsRepository.findByDonarIdAndStatus(id, true))
					.orElseThrow(() -> new CustomException("Donar Details not found with specific id ", false));

			donarsEntity.setProfilePicture(pathNew.toUri().toURL().toString());
			donarsEntity.setProfilePictureUrl(
					"http://localhost:8081/profile-images/" + "Donor/" + id + "/" + file.getOriginalFilename());
			DonarsEntity donorDetailsUpdated = donarsRepository.save(donarsEntity);
			BeanUtils.copyProperties(donorDetailsUpdated, donars);
			return donars;

		} else if ("acceptor".equalsIgnoreCase(component)) {
			Optional<AcceptorEntity> acceptorEntity = Optional
					.ofNullable(acceptorRepository.findByAcceptorIdAndStatus(id, true))
					.orElseThrow(() -> new CustomException("Acceptor Details not found with specific id ", false));
			acceptorEntity.get().setProfilePicture(pathNew.toUri().toURL().toString());
			acceptorEntity.get().setProfilePictureUrl(
					"http://localhost:8081/profile-images/" + "Acceptor/" + id + "/" + file.getOriginalFilename());
			AcceptorEntity acceptorDetailsUpdated = acceptorRepository.save(acceptorEntity.get());
			BeanUtils.copyProperties(acceptorDetailsUpdated, acceptor);
			return acceptor;
		}

		return null;

	}

}
