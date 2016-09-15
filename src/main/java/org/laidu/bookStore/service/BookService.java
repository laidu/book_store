package org.laidu.bookStore.service;

import org.laidu.bookStore.model.BookModel;

import java.util.List;

/**
 * Created by laidu on 16-9-12.
 */
public interface BookService {

    int addBook(BookModel bookModel);
    int delBook(int id);
    List<BookModel> findList();
    BookModel findDetial(int id);
    int updataBook(BookModel bookModel);
}
