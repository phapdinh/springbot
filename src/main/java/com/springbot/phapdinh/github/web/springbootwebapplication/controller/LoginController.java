package com.springbot.phapdinh.github.web.springbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.springbot.phapdinh.github.web.springbootwebapplication.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
  @Autowired
  private LoginService service;

  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String showLogin() {
    return "login";
  }

  @RequestMapping(value="/login", method=RequestMethod.POST)
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

  @RequestMapping(value="/intro", method=RequestMethod.GET)
  public String introductionMessage(@RequestParam String name, ModelMap model) {
    model.put("name", name);
    return "intro";
  }
}
