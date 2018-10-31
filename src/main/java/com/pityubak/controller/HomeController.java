package com.pityubak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pityubak.service.UserService;

@Controller
public class HomeController {
	
	
	private UserService service;
	
	
	@Autowired
	public void setService(UserService service) {
		this.service = service;
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String firstPage() {
		return "firstpage";
	}
	
	@RequestMapping(value="/secondpage", method=RequestMethod.GET)
	public String secondPage() {
		return "secondpage";
	}
	
	@RequestMapping(value="/thirdpage", method=RequestMethod.GET)
	public String thirdPage(Model model) {
		model.addAttribute("users",service.findAll());
		return "thirdpage";
	}

}
