package com.pityubak.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGeneral {
	
	@ExceptionHandler
	public String exception(Model model,Exception ex) {
		model.addAttribute("exception", ex);
		return "";
	}

}
