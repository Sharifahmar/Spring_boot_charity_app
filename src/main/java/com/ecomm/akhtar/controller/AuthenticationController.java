package com.ecomm.akhtar.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.akhtar.constants.EcommUriConstants;
import com.ecomm.akhtar.entity.JwtRefreshTokenEntity;
import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.model.JwtAuthenticationResponse;
import com.ecomm.akhtar.model.LoginRequest;
import com.ecomm.akhtar.model.RefreshTokenRequest;
import com.ecomm.akhtar.repository.JwtRefreshTokenRepository;
import com.ecomm.akhtar.repository.UsersRepository;
import com.ecomm.akhtar.securityconfig.JwtTokenProvider;
import com.ecomm.akhtar.securityconfig.UserPrincipal;

import springfox.documentation.swagger.web.ApiResourceController;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsersRepository userRepository;

	
	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private JwtRefreshTokenRepository jwtRefreshTokenRepository;

	@Value("${app.jwtExpirationInMs}")
	private long jwtExpirationInMs;

	String encryptKey = "";

	String privateKey = "";

	@PostMapping(EcommUriConstants.LOGIN_TOKEN)
	public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		String accessToken = tokenProvider.generateToken(userPrincipal);
		String refreshToken = tokenProvider.generateRefreshToken();
		saveRefreshToken(userPrincipal, refreshToken);
		return ResponseEntity.ok(new JwtAuthenticationResponse(accessToken, refreshToken, jwtExpirationInMs));
	}

	@PostMapping(EcommUriConstants.REFRESH_TOKEN_URI)
	public ResponseEntity<?> refreshAccessToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest)
			throws Exception {
		return jwtRefreshTokenRepository.findById(refreshTokenRequest.getRefreshToken()).map(jwtRefreshToken -> {
			UsersEntity user = jwtRefreshToken.getUser();
			String accessToken = tokenProvider.generateToken(UserPrincipal.create(user));
			return ResponseEntity
					.ok(new JwtAuthenticationResponse(accessToken, jwtRefreshToken.getToken(), jwtExpirationInMs));
		}).orElseThrow(() -> new Exception("Invalid Refresh Token"));
	}

	private void saveRefreshToken(UserPrincipal userPrincipal, String refreshToken) {
		// Persist Refresh Token
		JwtRefreshTokenEntity jwtRefreshToken = new JwtRefreshTokenEntity(refreshToken);
		jwtRefreshToken.setUser(userRepository.getOne(userPrincipal.getId()));
		Instant expirationDateTime = Instant.now().plus(360, ChronoUnit.DAYS);
		jwtRefreshToken.setExpirationDateTime(expirationDateTime);
		jwtRefreshTokenRepository.save(jwtRefreshToken);
	}

}
