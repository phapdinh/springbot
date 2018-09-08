package com.springbot.phapdinh.github.web.springbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String showLogin() {
    return "login";
  }
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String showWelcomePage(@RequestParam String name, ModelMap model) {
    model.put("name", name);
    return "welcome";
  }
  @RequestMapping(value="/intro", method=RequestMethod.GET)
  public String introductionMessage(@RequestParam String name, ModelMap model) {
    model.put("name", name);
    return "intro";
  }
}
