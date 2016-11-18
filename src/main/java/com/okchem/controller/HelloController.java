package com.okchem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.okchem.models.Users;
import com.okchem.services.UserService;



@RestController
public class HelloController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello(){
		return new ModelAndView("hello").addObject("name",this.userService.getUser(1).getUseNrame());
	}
	
	@RequestMapping("/user")
	public Users getUser(){
		return this.userService.getUser(1);
	}
}
