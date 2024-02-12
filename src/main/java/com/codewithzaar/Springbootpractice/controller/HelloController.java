package com.codewithzaar.Springbootpractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Home")
public class HelloController
{

	@GetMapping("/Greet")
	public String greet()
	{
		return "Hello World!!";
	}

}
