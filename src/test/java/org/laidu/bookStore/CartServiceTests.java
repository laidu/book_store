package org.laidu.bookStore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.laidu.bookStore.domain.Cart;
import org.laidu.bookStore.model.CartModel;
import org.laidu.bookStore.service.CartService;
import org.laidu.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTests {

	@Autowired
	private CartService cartService;

	@Test
	public void contextLoads() {

		for (CartModel cart:cartService.findListByUid(1))
			System.out.println(cart.getBook().getTitle());
	}

}
