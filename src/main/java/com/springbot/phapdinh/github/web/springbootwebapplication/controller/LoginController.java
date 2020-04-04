package com.springbot.phapdinh.github.web.springbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.springbot.phapdinh.github.web.springbootwebapplication.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
  @Autowired
  private LoginService service;

  @GetMapping(value={"/login", "/"})
  public String showLogin(ModelMap model) {
    String name = (String) model.get("name");
    if(name == null || name.length() == 0) {
      return "login";
    }
    return "welcome";
  }

  @PostMapping(value="/login")
  public String showWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
    boolean isValidUser = service.validateUser(name, password);
    if(isValidUser) {
      model.put("name", name);
      return "welcome";
    } else {
      model.put("errorMessage", "Invalid Credentials");
      return "login";
    }
  }

  @GetMapping(value="/intro")
  public String introductionMessage(@RequestParam String name, ModelMap model) {
    model.put("name", name);
    return "intro";
  }
}
