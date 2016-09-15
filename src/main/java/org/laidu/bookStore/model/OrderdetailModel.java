package org.laidu.bookStore.model;

import org.laidu.bookStore.domain.Orderdetail;

import java.util.List;

/**
 * Created by laidu on 16-9-12.
 */
public class OrderdetailModel extends Orderdetail{
    private BookModel book;
    private OrderModel order;

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }
}
