package com.springbot.phapdinh.github.web.springbootwebapplication.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbot.phapdinh.github.web.springbootwebapplication.service.TodoService;
import com.springbot.phapdinh.github.web.springbootwebapplication.model.Todo;

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

  @RequestMapping(value="/add-todo", method=RequestMethod.GET)
  public String showAddTodosPage(ModelMap model) {
    model.addAttribute("todo", new Todo(0, (String) model.get("name"), "Default Desc", new Date(), false));
    return "todo";
  }

  @RequestMapping(value="/delete-todo", method=RequestMethod.GET)
  public String deleteTodo(@RequestParam int id, ModelMap model) {
    todos.deleteTodo(id);
    return "redirect:list-todos";
  }

  @RequestMapping(value="/add-todo", method=RequestMethod.POST)
  public String showAddTodosPage(ModelMap model, @Valid Todo todo, BindingResult result) {
    if(result.hasErrors()) {
			return "todo";
		}
    todos.addTodo((String) model.get("name"), todo.getDesc(), new Date(), false);
    return "redirect:/list-todos";
  }
}
