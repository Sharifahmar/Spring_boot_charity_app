package com.ecomm.akhtar.controller;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.entity.RolesEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.exception.CustomException;
import com.ecomm.akhtar.model.ApiResponseModel;
import com.ecomm.akhtar.model.IdentityAvailability;
import com.ecomm.akhtar.model.RoleName;
import com.ecomm.akhtar.model.StatusModel;
import com.ecomm.akhtar.model.UserSummary;
import com.ecomm.akhtar.model.Users;
import com.ecomm.akhtar.model.UsersCheckRequest;
import com.ecomm.akhtar.repository.RolesRepository;
import com.ecomm.akhtar.repository.UsersRepository;
import com.ecomm.akhtar.securityconfig.CurrentUser;
import com.ecomm.akhtar.securityconfig.UserPrincipal;
import com.ecomm.akhtar.service.UserServiceInf;

@RestController
public class UserController {

	@Autowired
	private UserServiceInf userServiceInf;

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private RolesRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping(EcommUriConstants.USER_ME_URI)
	// @PreAuthorize("hasRole('USER')")
	public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) throws CustomException {

		if (ObjectUtils.isEmpty(currentUser)) {

			throw new CustomException("No record found in session", false);
		}
		return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
	}

	@PostMapping(EcommUriConstants.USERNAME_EXIST_URI)
	public ResponseEntity<IdentityAvailability> checkUsernameAvailability(@RequestBody UsersCheckRequest user) {
		Boolean isAvailable = userServiceInf.existsByUserName(user.getUserName());
		return new ResponseEntity<>(new IdentityAvailability(isAvailable, "Username already exists..!!"),
				HttpStatus.OK);
	}

	@PostMapping(EcommUriConstants.EMAIL_EXIST_URI)
	public ResponseEntity<IdentityAvailability> checkEmailAvailability(@RequestBody UsersCheckRequest user) {

		Boolean isAvailable = userServiceInf.existsByEmailId(user.getEmail());

		if (isAvailable) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new IdentityAvailability(isAvailable, "Email not exist..!!"));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new IdentityAvailability(isAvailable, "Email already exist..!!"));
		}

	}

	@PostMapping(EcommUriConstants.USERS_DETAILS_BY_ID_STATUS)
	public ResponseEntity<Users> getUserDetailsByIdStatus(@Valid @CurrentUser UserPrincipal currentUser,
			@RequestBody StatusModel status) throws CustomException {
		if (ObjectUtils.isEmpty(currentUser)) {

			throw new CustomException("No record found in session", false);
		}

		Users user = userServiceInf.getUserDetailsByIdStatus(currentUser.getId(), status.getStatus());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping(EcommUriConstants.REGISTER_USER_URI)
	public ResponseEntity<Users> registerUser(@Valid @RequestBody Users user) {
		try {
			if (userRepository.existsByUserName(user.getUserName())) {
				return new ResponseEntity(new ApiResponseModel("Username is already taken!", false),
						HttpStatus.BAD_REQUEST);
			}

			if (userRepository.existsByEmailId(user.getEmailId())) {
				return new ResponseEntity(new ApiResponseModel("Email Address already in use!", false),
						HttpStatus.BAD_REQUEST);
			}

			UsersEntity usersEntity = new UsersEntity();
			BeanUtils.copyProperties(user, usersEntity);
			usersEntity.setPassword(passwordEncoder.encode(user.getPassword()));
			usersEntity.setStatus(true);
			RolesEntity userRole = roleRepository.findByRoleName(RoleName.ROLE_USER)
					.orElseThrow(() -> new CustomException("User Role not set.", false));

			usersEntity.setRoles(Collections.singleton(userRole));
			UsersEntity result = userRepository.save(usersEntity);
			Users usersNew = new Users();
			BeanUtils.copyProperties(result, usersNew);

			return new ResponseEntity<>(usersNew, HttpStatus.OK);

		} catch (CustomException e) {

			e.printStackTrace();

			return new ResponseEntity(new ApiResponseModel("Error Occur while User Registration !", false),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
