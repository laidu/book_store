package org.laidu.bookStore.serviceImpl;

import org.laidu.bookStore.mapper.OrderMapper;
import org.laidu.bookStore.mapper.OrderdetailMapper;
import org.laidu.bookStore.model.OrderModel;
import org.laidu.bookStore.model.OrderdetailModel;
import org.laidu.bookStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by laidu on 16-9-13.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public int addOrder(OrderModel orderModel) {
        return orderMapper.insertSelective(orderModel);
    }

    @Override
    public int delOrder(int id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OrderModel> findListByUid(int uid) {
        return orderMapper.findListByUid(uid);
    }

    @Override
    public int updateOrder(OrderModel orderModel) {
        return orderMapper.updateByPrimaryKeySelective(orderModel);
    }

    @Override
    public List<OrderdetailModel> findDetailByOid(int oid) {
        return orderdetailMapper.findDetailByOid(oid);
    }
}
