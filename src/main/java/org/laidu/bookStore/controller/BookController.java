package org.laidu.bookStore.controller;

import org.laidu.bookStore.model.BookModel;
import org.laidu.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by laidu on 16-9-13.
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    public List<BookModel> list(){
        return bookService.findList();
    }
}
