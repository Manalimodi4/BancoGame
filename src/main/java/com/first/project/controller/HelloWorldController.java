package com.first.project.controller;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloWorldController {
	
	@RequestMapping(value="/greetingOld", method= RequestMethod.GET)
	public String greet() {
		
		return "Hello World @ " + new Date();
	}

}
