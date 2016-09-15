package org.laidu.bookStore.service;

import org.laidu.bookStore.model.CartModel;

import java.util.List;

/**
 * Created by laidu on 16-9-12.
 */
public interface CartService {
    int addCart(CartModel cartModel);
    int delCart(int id);
    int clean(int id);
    List<CartModel> findListByUid(int uid);
    CartModel findDetial(int id);
    int updateCart(CartModel cartModel);

    int delCartByBid(int uid, int bid);
}
