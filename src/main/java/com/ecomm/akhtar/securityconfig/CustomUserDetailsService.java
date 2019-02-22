package com.ecomm.akhtar.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.akhtar.entity.UsersEntity;
import com.ecomm.akhtar.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UsersRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// Let people login with either username or email
		UsersEntity user = userRepository.findByUserNameOrEmailId(usernameOrEmail, usernameOrEmail).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail));

		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails loadUserById(Long userId) throws Exception {
		UsersEntity user = userRepository.findById(userId).orElseThrow(() -> new Exception("User id not found"));
		return UserPrincipal.create(user);
	}
}