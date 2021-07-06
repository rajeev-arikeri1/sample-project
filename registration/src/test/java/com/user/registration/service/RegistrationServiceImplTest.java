package com.user.registration.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.registration.model.User;
@SpringBootTest
class RegistrationServiceImplTest {
	
	@Autowired
	RegistrationService serviceImpl;


	@Test
	void testUserRegistration() throws Exception{
		User customer=new User();
		customer.setUserName("123");
		List<String> list=serviceImpl.userRegistration(customer);
		assertEquals("Username must be 9 to 16 characters in length",list.get(0));
		assertEquals("Username Must be alphanumeric and should not contain special characters",list.get(1));
		customer.setUserName("administrator");
		list=serviceImpl.userRegistration(customer);
		assertEquals("Username is Forbidden",list.get(0));
		
	}

}
