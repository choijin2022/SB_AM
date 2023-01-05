package com.cji.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class usrAPITestController {

	@RequestMapping("/usr/home/APITest")
	public String showMain() {
		return "usr/home/APITest";
	}
	
	
	
	
}
