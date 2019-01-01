package com.springbot.phapdinh.github.web.springbootwebapplication;

import static org.junit.Assert.assertEquals;

import com.springbot.phapdinh.github.web.springbootwebapplication.service.LoginService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {

	@Test
	public void LoginService() {
		LoginService login = new LoginService();
		assertEquals(true, login.validateUser("in28minutes", "password"));
		assertEquals(false, login.validateUser("in28inutes", "password"));
	}

}
