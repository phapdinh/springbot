package com.springbot.phapdinh.github.web.springbootwebapplication;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.springbot.phapdinh.github.web.springbootwebapplication.model.Todo;
import com.springbot.phapdinh.github.web.springbootwebapplication.service.LoginService;
import com.springbot.phapdinh.github.web.springbootwebapplication.service.TodoService;

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
		assertEquals(true, login.validateUser("IN28MINUTES", "PASSWORD"));
		assertEquals(false, login.validateUser("in28inutes", "password"));
	}

	@Test
	public void TodoService() {
		TodoService todoService = new TodoService();
		Todo todo = new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false);
		Todo retrievedTodo = todoService.retrieveTodo(1);
		assertEquals(todo, retrievedTodo);
	}
}
