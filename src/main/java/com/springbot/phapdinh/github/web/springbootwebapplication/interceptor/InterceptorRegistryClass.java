package com.springbot.phapdinh.github.web.springbootwebapplication.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class InterceptorRegistryClass extends WebMvcConfigurerAdapter {
   @Autowired
   Interceptor interceptor;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(interceptor);
   }
}