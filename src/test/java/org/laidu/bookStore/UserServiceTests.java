package org.laidu.bookStore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.laidu.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		System.out.println(userService.findByUsernameAndPassword("admin","admin").getUsername());
	}

}
