package org.laidu.bookStore.serviceImpl;

import org.laidu.bookStore.domain.Orderdetail;
import org.laidu.bookStore.mapper.OrderdetailMapper;
import org.laidu.bookStore.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by laidu on 16-9-14.
 */
@Service
public class OrderDetailServiceimpl  implements OrderDetailService {

    @Autowired
    public OrderdetailMapper orderdetailMapper;
    @Override
    public int add(Orderdetail orderdetail) {
        return orderdetailMapper.insertSelective(orderdetail);
    }
}
