package com.user.registration.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.registration.model.User;
import com.user.registration.validation.ValidateUser;

@Service
/**
 * 
 * @author Rajeev 
 * RegistrationServiceImpl implements RegistrationService interface
 * It validates all the required rules for userName such as
 * Length,SpecialCharacter,Alphanumeric and Forbidden names
 */
public class RegistrationServiceImpl implements RegistrationService {

	static final Logger log = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Autowired
	public ValidateUser customerValidation;

	/**
	 * @param user
	 * @return List<String>
	 */
	public List<String> userRegistration(User customer) throws Exception {
		List<String> customerList = new ArrayList<>();
		log.info("Inside RegistrationServiceImpl class");
		if (customer == null) {
			customerList.add("Username and Password cannot be null");
			log.info("Inside userRegistration method customer object: Username and Password cannot be null");
		} else {
			customerList.clear();
			if (customerValidation.isForBiddenNames(customer.getUserName())) {
				customerList.add("Username is Forbidden");
				log.info("Inside userRegistration method customer object: Username is Forbidden");
			}
			if (!customerValidation.validateLength(customer.getUserName())) {
				customerList.add("Username must be 9 to 16 characters in length");
				log.info(
						"Inside userRegistration method customer object: Username must be 9 to 16 characters in length");
			}
			if (!customerValidation.isAlphaNumericAndNotSpecialChar(customer.getUserName())) {
				customerList.add("Username Must be alphanumeric and should not contain special characters");
				log.info(
						"Inside userRegistration method customer object: Username Must be alphanumeric and should not contain special characters");
			} 
			if (customerList.isEmpty()){
				customerList.add("Customer Registration is Successful!");
				log.info("Inside userRegistration method customer object: Customer Registration is Successful!");
			}
		}
		return customerList;
	}

}
