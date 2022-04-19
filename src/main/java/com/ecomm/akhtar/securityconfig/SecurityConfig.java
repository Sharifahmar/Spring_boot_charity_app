package com.ecomm.akhtar.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwtauthfilter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	private static final String[] AUTH_WHITELIST_POST = {

			"/loginToken", "/registerUser", "/refreshToken", "/user/checkPhoneNumberAvailability",
			"/user/checkEmailAvailability", "/generateKey", "/validateKey", "/donationType", "/donationAmount",
			"/donarSlipDetails", "/acceptorRepo", "/donar/checkPhoneNumberAvailability",
			"/donar/checkEmailAvailability" };

	private static final String[] AUTH_WHITELIST_GET = {

			"/usersentities", "/usersentities/**", "/donationType/**", "/donationType", "/acceptorRepo/**"

	};

	private static final String[] SWAGGER_AUTH_WHITELIST = {

			// -- swagger ui
			"/swagger-resources/configuration/security", "/swagger-resources/configuration/ui", "/swagger-resources",
			"/swagger-ui.html", "/v2/api-docs", "/webjars/**","/profile-images/**","/images/**"

	};

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // access static folder content and bypass security
				.antMatchers("/h2-console/**").permitAll().antMatchers(HttpMethod.GET, AUTH_WHITELIST_GET).permitAll()
				.antMatchers(HttpMethod.POST, AUTH_WHITELIST_POST).permitAll().antMatchers(SWAGGER_AUTH_WHITELIST)
				.permitAll().anyRequest().authenticated();

		// Add our custom JWT security filter
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		http.headers().frameOptions().disable();

	}
}