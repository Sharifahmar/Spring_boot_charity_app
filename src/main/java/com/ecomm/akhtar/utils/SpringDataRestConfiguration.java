/**
 * 
 */
package com.ecomm.akhtar.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.ecomm.akhtar.entity.AcceptorEntity;
import com.ecomm.akhtar.entity.DonationTypeEntity;

/**
 * @author Ahmar
 *
 */
@Configuration
public class SpringDataRestConfiguration extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(DonationTypeEntity.class,AcceptorEntity.class);
	}
}