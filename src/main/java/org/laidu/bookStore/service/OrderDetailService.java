package org.laidu.bookStore.service;

import org.laidu.bookStore.domain.Orderdetail;
import org.laidu.bookStore.mapper.OrderdetailMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by laidu on 16-9-14.
 */
public interface OrderDetailService {

    int add(Orderdetail orderdetail);
}
