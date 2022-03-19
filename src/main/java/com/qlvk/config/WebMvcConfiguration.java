package com.qlvk.config;

import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * WebMvcConfiguration<BR>
 * <BR>
 * Defines callback methods to customize the Java-based configuration for Spring
 * MVC enabled via {@code @EnableWebMvc}<BR>
 * 
 */
@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.addBasenames("classpath:messages/ApplicationResources");
		messageSource.setDefaultEncoding("UTF-8");

		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {

		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(new Locale("vn"));

		return sessionLocaleResolver;
	}

//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		// ... tipicly set username, password, driver class name, jdbc Url
//		dataSource.setSchema("seino_center");
//		dataSource.setUsername("seino_center");
//		dataSource.setPassword("seino_center");
//		dataSource.setUrl("jdbc:postgresql://10.133.222.167:5433/seino_tool?verifyServerCertificate=false&useSSL=false&requireSSL=false");
//		return dataSource;
//	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// Register resource handler webjars resources
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");

		// Register resource handler custom resources
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
	}

}
