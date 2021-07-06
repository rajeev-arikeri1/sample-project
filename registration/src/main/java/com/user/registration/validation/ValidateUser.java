package com.user.registration.validation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
/**
 * 
 * @author Rajeev 
 * A ValidateUser class for validating userName
 *
 */
public class ValidateUser {
	static final Logger log = LoggerFactory.getLogger(ValidateUser.class);

	public Boolean validateLength(String userName) throws Exception {
		log.info(userName + ":"+ userName.length());
		if (userName.length() >= 9 && userName.length() <= 16) {
			return true;
		}
		return false;
	}

	public Boolean isAlphaNumericAndNotSpecialChar(String userName) throws Exception {
		String pattern = "^[a-zA-Z][a-zA-Z0-9]*$";
		log.info("isAlphaNumericAndNotSpecialChar:"+userName.matches(pattern));
		return userName.matches(pattern);
	}

	public Boolean isForBiddenNames(String userName) throws Exception {
		if(loadForbiddenNames().contains(userName)) {
			log.info(userName + "is Forbidden name");
		}
		return loadForbiddenNames().contains(userName);
	}

	public List<String> loadForbiddenNames() throws Exception {
		List<String> forbiddenNames = new ArrayList<String>();
		forbiddenNames.add("admin");
		forbiddenNames.add("manager");
		forbiddenNames.add("user");
		forbiddenNames.add("administrator");
		forbiddenNames.add("administration");
		forbiddenNames.add("customers");
		return forbiddenNames;
	}

}
