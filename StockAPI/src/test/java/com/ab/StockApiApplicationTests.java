package com.ab;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ab.dtos.UserDto;
import com.ab.services.UserService;

@SpringBootTest
class StockApiApplicationTests {

	@Autowired
	UserService userService;
	/**
	@Test
	public void registerUser() {
		UserDto newUser = new UserDto("Test", "User", "testing@example.com", "password1234", 0.0);
		assertEquals(true, this.userService.register(newUser));
	}
**/


}
