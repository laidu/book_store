package org.laidu.bookStore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.laidu.bookStore.model.BookModel;
import org.laidu.bookStore.service.BookService;
import org.laidu.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {

	@Autowired
	private BookService bookService;

	@Test
	public void contextLoads() {

		for (BookModel book:bookService.findList())
			System.out.println(book.getTitle());
	}

}
