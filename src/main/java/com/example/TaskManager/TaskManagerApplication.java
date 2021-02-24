package com.example.TaskManager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({ "com.example.Taskmaster" })
@PropertySources(value = { @PropertySource("classpath:/application.properties") })
public class TaskManagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskManagerApplication.class, args);
	}


}


