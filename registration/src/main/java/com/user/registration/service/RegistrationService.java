package com.user.registration.service;

import java.util.List;

import com.user.registration.model.User;
/**
 * 
 * @author Rajeev
 * RegistrationService is an interface with single userRegistration method
 */
public interface RegistrationService {
	
	public List<String> userRegistration(User customer) throws Exception;
}
