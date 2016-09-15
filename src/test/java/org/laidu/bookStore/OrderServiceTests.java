package org.laidu.bookStore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.laidu.bookStore.domain.Order;
import org.laidu.bookStore.model.OrderModel;
import org.laidu.bookStore.model.OrderdetailModel;
import org.laidu.bookStore.service.OrderService;
import org.laidu.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void contextLoads() {
        for (OrderModel orderModel:orderService.findListByUid(1))
        System.out.println(orderModel.getId());
    }

    @Test
    public void getDetailByOid() {
        for (OrderdetailModel var : orderService.findDetailByOid(21))
            System.out.println(var.getId());
    }

    @Test
    public void getKey() {
        OrderModel orderModel = new OrderModel();
        orderModel.setUid(1);
        orderModel.setReceiver("");
        orderModel.setTotalprice(12f);
        orderModel.setRphone("132");
        orderModel.setBuydate(new Date());
        orderService.addOrder(orderModel);
        System.out.println(orderModel.getId());
    }

}
