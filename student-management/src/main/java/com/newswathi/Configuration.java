package com.newswathi;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import ch.qos.logback.core.db.DriverManagerConnectionSource;

@org.springframework.context.annotation.Configuration
public class Configuration {
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("locale/customer/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public DataSource dataSource() {
		// JDBC driver name and database URL
		String jdbcDriver = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost/STUDENT";

		// Database credentials
		String username = "root";
		final String password = "@24kulavayal92";
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(jdbcDriver);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource());
	}
}
