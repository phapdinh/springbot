package com.springbot.phapdinh.github.web.springbootwebapplication;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.springbot.phapdinh.github.web.springbootwebapplication.service.LoginService;

@RunWith(Parameterized.class)
public class SpringBootWebApplicationTests {
	private LoginService service = new LoginService();
	private String expect;
	private String username;
	private String password;

	public SpringBootWebApplicationTests(String expect, String username, String password) {
		this.expect = expect;
		this.username = username;
		this.password = password;
	}

	@Parameters
	public static Collection<String[]> enterCredentials() {
		String[][] credentials = { { "true", "in28minutes", "password" }, { "true", "IN28MINUTES", "PASSWORD" }, { "false", "in28inutes", "password" } };
		return Arrays.asList(credentials);
	}

	@Test
	public void LoginService() {
		System.out.println("Credentials with : " + username + " and " + password + " was " + Boolean.parseBoolean(expect));

		assertEquals(Boolean.parseBoolean(expect), service.validateUser(username, password));
	}
}
