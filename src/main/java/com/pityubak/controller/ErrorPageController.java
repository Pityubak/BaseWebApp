package com.pityubak.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorPageController implements ErrorController {

	@RequestMapping("/error")
	public String error(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		Integer statusCode = Integer.valueOf(status.toString());
		if (status != null) {
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "errors/error-404";
			} else if (statusCode == HttpStatus.FORBIDDEN.value()) {
				return "errors/error-403";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "errors/error-500";
			} else if (statusCode == HttpStatus.BAD_GATEWAY.value()) {
				return "errors/error-502";
			}
		}
		return "error";
	}

	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public String errorFromView(HttpServletRequest request, @RequestAttribute String status) {
		if (status != null) {
			if (status == HttpStatus.NOT_FOUND.toString()) {
				return "errors/error-404";
//			}else if(status==HttpStatus.FORBIDDEN.value()) {
//				return "errors/error-403";
//			}else if(statusCode==HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//				return "errors/error-500";
//			}else if(statusCode==HttpStatus.BAD_GATEWAY.value()) {
//				return "errors/error-502";
//			}
			}
		}
		return "error";
	}

	@Override
	public String getErrorPath() {
		return "error";
	}

}
