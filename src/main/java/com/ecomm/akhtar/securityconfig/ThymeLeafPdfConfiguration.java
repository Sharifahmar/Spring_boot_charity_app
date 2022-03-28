/**
 * 
 */
package com.ecomm.akhtar.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * @author Asus
 *
 */
@Configuration
public class ThymeLeafPdfConfiguration {
	@Bean
	public ClassLoaderTemplateResolver emailTemplateResolver() {
		ClassLoaderTemplateResolver pdfTemplateResolver = new ClassLoaderTemplateResolver();
		pdfTemplateResolver.setPrefix("templates/");
		pdfTemplateResolver.setSuffix(".html");
		pdfTemplateResolver.setTemplateMode("HTML");
		pdfTemplateResolver.setCharacterEncoding("UTF-8");
		pdfTemplateResolver.setOrder(1);
		return pdfTemplateResolver;
	}

}
