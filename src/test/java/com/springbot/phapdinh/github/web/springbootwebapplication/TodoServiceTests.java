package com.springbot.phapdinh.github.web.springbootwebapplication;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.springbot.phapdinh.github.web.springbootwebapplication.model.Todo;
import com.springbot.phapdinh.github.web.springbootwebapplication.service.TodoService;

import org.junit.Test;

public class TodoServiceTests {
    private TodoService todos = new TodoService();

    @Test
    public void TodoService() {
		Todo retrievedTodo0 = todos.retrieveTodo(0);
		Todo todo = new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false);
		Todo retrievedTodo1 = todos.retrieveTodo(1);
		assertEquals(todo, retrievedTodo1);
		assertEquals(null, retrievedTodo0);
	}
}