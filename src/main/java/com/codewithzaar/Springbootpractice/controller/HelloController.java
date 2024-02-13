package com.codewithzaar.Springbootpractice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Home")
public class HelloController
{

	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@GetMapping("/Greet")
	public String greet()
	{
		return welcomeMessage; //Welcome to spring boot application!! from Application Property
	}

}
