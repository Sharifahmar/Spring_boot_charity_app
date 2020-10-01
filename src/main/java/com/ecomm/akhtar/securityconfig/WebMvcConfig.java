package com.ecomm.akhtar.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.ecomm.akhtar.constants.EcommUriConstants;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry
               .addResourceHandler("/images/**")
               .addResourceLocations(EcommUriConstants.PROFILE_PICTURE_STORE_LOCATION)
               .setCachePeriod(3600)
               .resourceChain(true)
               .addResolver(new PathResourceResolver());
    }
  
}
