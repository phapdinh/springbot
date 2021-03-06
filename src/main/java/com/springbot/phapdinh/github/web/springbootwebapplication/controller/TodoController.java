package com.springbot.phapdinh.github.web.springbootwebapplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbot.phapdinh.github.web.springbootwebapplication.service.TodoService;
import com.springbot.phapdinh.github.web.springbootwebapplication.model.Todo;

@Controller
@SessionAttributes("name")
public class TodoController {
  @Autowired
  private TodoService todos;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }

  @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
  public String showTodos(ModelMap model) {
    String name = (String) model.get("name");
    if(name == null || name.length() == 0) {
      return "errors";
    }

    model.put("todos", todos.retrieveTodos(name));
    return "list-todos";
  }

  @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
  public String showAddTodosPage(ModelMap model) {
    model.addAttribute("todo", new Todo(0, (String) model.get("name"), "Default Desc", new Date(), false));
    return "todo";
  }

  @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
  public String showAddTodosPage(ModelMap model, @Valid Todo todo, BindingResult result) {
    if (result.hasErrors()) {
      return "todo";
    }
    todos.addTodo((String) model.get("name"), todo.getDesc(), todo.getTargetDate(), false);
    return "redirect:/list-todos";
  }

  @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
  public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
    Todo todo = todos.retrieveTodo(id);
    model.put("todo", todo);
    return "todo";
  }

  @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
  public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

    if (result.hasErrors()) {
      return "todo";
    }

    todo.setUser((String) model.get("name"));

    todos.updateTodo(todo);

    return "redirect:/list-todos";
  }

  @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
  public String deleteTodo(@RequestParam int id) {
    todos.deleteTodo(id);
    return "redirect:list-todos";
  }

  @RequestMapping(value = "/get-todos", method = RequestMethod.GET)
  public @ResponseBody List<Todo> getTodos() {
    return todos.retrieveTodos("in28Minutes");
  }
}
