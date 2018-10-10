package com.springbot.phapdinh.github.web.springbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.springbot.phapdinh.github.web.springbootwebapplication.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
  @Autowired
  private TodoService todos;

  @RequestMapping(value="/list-todos", method=RequestMethod.GET)
  public String showTodos(ModelMap model) {
    String name = (String) model.get("name");
		model.put("todos", todos.retrieveTodos(name));
    return "list-todos";
  }

  @RequestMapping(value="/add-todo", method=RequestMethod.POST)
  public String showTodos(ModelMap model) {
    String name = (String) model.get("name");
		model.put("todos", todos.retrieveTodos(name));
    return "add-todo";
  }
}
