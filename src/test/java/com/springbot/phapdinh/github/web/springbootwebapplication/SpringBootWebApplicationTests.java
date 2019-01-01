package com.springbot.phapdinh.github.web.springbootwebapplication;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.springbot.phapdinh.github.web.springbootwebapplication.model.Todo;
import com.springbot.phapdinh.github.web.springbootwebapplication.service.LoginService;
import com.springbot.phapdinh.github.web.springbootwebapplication.service.TodoService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {
	@Autowired
	private TodoService todos;

	@Autowired
	private LoginService service;

	@Test
	public void LoginService() {
		assertEquals(true, service.validateUser("in28minutes", "password"));
		assertEquals(true, service.validateUser("IN28MINUTES", "PASSWORD"));
		assertEquals(false, service.validateUser("in28inutes", "password"));
	}

	@Test
	public void TodoService() {
		Todo todo = new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false);
		Todo retrievedTodo = todos.retrieveTodo(1);
		assertEquals(todo, retrievedTodo);
	}
}
