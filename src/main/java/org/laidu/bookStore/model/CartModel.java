package org.laidu.bookStore.model;

import org.laidu.bookStore.domain.Book;
import org.laidu.bookStore.domain.Cart;

/**
 * Created by laidu on 16-9-12.
 */
public class CartModel extends Cart{
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
