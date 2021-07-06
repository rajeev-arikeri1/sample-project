package com.user.registration.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.user.registration.model.User;
import com.user.registration.service.RegistrationServiceImpl;

@RestController
/**
 * 
 * @author Rajeev
 * UserRegistrationController is the controller class for registration application 
 * It is entry point for customer registration
 */
public class UserRegistrationController {
	
	static final Logger log = 
	        LoggerFactory.getLogger(UserRegistrationController.class);
	
	@Autowired
	public RegistrationServiceImpl service;
    /**
     * 
     * @param exception
     * @param request
     * @return ResponseEntity<>
     */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleException(Exception exception, WebRequest request) {
		List<String> details = new ArrayList<>();
		log.info("Inside handleException method get localized Message:" + exception.getLocalizedMessage());
		details.add(exception.getLocalizedMessage());
		log.info("Inside handleException method get message:" + exception.getMessage());
		details.add(exception.getMessage());
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
    /**
     * 
     * @param newUser
     * @return List<String>
     * @throws Exception
     */
	@PostMapping(path = "/user")
	List<String> userRegistration(@RequestBody User newUser) throws Exception {
		log.info("Inside userRegistration method where username:" + newUser.getUserName());
		return service.userRegistration(newUser);
	}

}
