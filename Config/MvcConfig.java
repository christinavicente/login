package com.example.TaskManager.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/new-user").setViewName("new-user");
        registry.addViewController("/login-error").setViewName("login-error");
        registry.addViewController("/create-tasks").setViewName("login");
        registry.addViewController("/delete-tasks").setViewName("login");
        registry.addViewController("/display-tasks").setViewName("login");
        registry.addViewController("/update-tasks").setViewName("login");
    }

}