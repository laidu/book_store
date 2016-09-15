package org.laidu.bookStore.model;

import org.laidu.bookStore.domain.Order;

/**
 * Created by laidu on 16-9-12.
 */
public class OrderModel extends Order {
    private BookModel book;

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }
}
