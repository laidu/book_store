package org.laidu.bookStore.service;

import org.laidu.bookStore.model.OrderModel;
import org.laidu.bookStore.model.OrderdetailModel;

import java.util.List;

/**
 * Created by laidu on 16-9-12.
 */
public interface OrderService {
    int addOrder(OrderModel orderModel);
    int delOrder(int id);
    List<OrderModel> findListByUid(int uid);
    int updateOrder(OrderModel orderModel);

    List<OrderdetailModel> findDetailByOid(int oid);
}
