package com.user.registration.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class ValidationUserTest {
	
	@Autowired
	public ValidateUser validate;


	@Test
	void testValidateCharLength() throws Exception{
		Boolean bool=validate.validateLength("1");
		assertEquals(false, bool);
		bool=validate.validateLength("rajeev123");
		assertEquals(true, bool);
		bool=validate.validateLength("rajeev123$6789543221");
		assertEquals(false, bool);
	}
	@Test
	void testIsAlphaNumericAndCaseAndSpecial() throws Exception{
		Boolean bool=validate.isAlphaNumericAndNotSpecialChar("$");
		assertEquals(false,bool);
		bool=validate.isAlphaNumericAndNotSpecialChar(" ");
		assertEquals(false,bool);
		bool=validate.isAlphaNumericAndNotSpecialChar("a");
		assertEquals(true,bool);
		bool=validate.isAlphaNumericAndNotSpecialChar("1");
		assertEquals(false,bool);
	}
	@Test
	void testIsForBiddenNames() throws Exception{
		Boolean bool=validate.isForBiddenNames("admin");
		assertEquals(true,bool);
		bool=validate.isForBiddenNames("Rajeev");
		assertEquals(false,bool);
	}

}
