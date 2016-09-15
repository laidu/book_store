package org.laidu.bookStore.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.laidu.bookStore.domain.Orderdetail;
import org.laidu.bookStore.model.CartModel;
import org.laidu.bookStore.model.OrderModel;
import org.laidu.bookStore.model.OrderdetailModel;
import org.laidu.bookStore.model.UserModel;
import org.laidu.bookStore.service.CartService;
import org.laidu.bookStore.service.OrderDetailService;
import org.laidu.bookStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by laidu on 16-9-13.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model) {
        UserModel userModel = (UserModel) request.getSession().getAttribute("user");
        if (userModel != null) {
            model.addAttribute("orderList", orderService.findListByUid(userModel.getId()));
            return "orderlist";
        }

        return "redirect: /user/login";
    }

    @RequestMapping("/detail/{oid}")
    public String detail(HttpServletRequest request, Model model,
                         @PathVariable int oid) {

        if (null != request.getSession().getAttribute("user")) {

            model.addAttribute("orderList", orderService.findDetailByOid(oid));
            return "orderDetail";
        }
        return "redirect:/user/login";

    }

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String pay(HttpServletRequest request, Model model) {

        UserModel userModel = (UserModel) request.getSession().getAttribute("user");
        if (userModel != null) {

            List<CartModel> cartModelList = cartService.findListByUid(userModel.getId());
            float totalprice = 0f;
            for (CartModel var : cartModelList) {

                totalprice += var.getTotalprice();
            }
            model.addAttribute("totalprice", totalprice);
            model.addAttribute("cartList", cartModelList);
            return "pay";
        }
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/payFinish",method = RequestMethod.POST)
    public String pay(HttpServletRequest request, Model model,
                      @RequestParam("receiver") String receiver,
                      @RequestParam("raddress") String raddress,
                      @RequestParam("rphone") String rphone) {
        if (null != request.getSession().getAttribute("user")) {
            UserModel userModel = (UserModel) request.getSession().getAttribute("user");
            List<CartModel> cartModel = cartService.findListByUid(userModel.getId());
            OrderModel orderModel = new OrderModel();
            orderModel.setUid(userModel.getId());
            orderModel.setBuydate(new Date());
            float totalprice = 0f;
            for (CartModel var : cartModel) {
                totalprice += var.getTotalprice();
            }
            orderModel.setReceiver(receiver);
            orderModel.setRaddress(raddress);
            orderModel.setRphone(rphone);
            orderModel.setTotalprice(totalprice);
            orderService.addOrder(orderModel);
            OrderdetailModel orderdetailModel = new OrderdetailModel();
            orderdetailModel.setOid(orderModel.getId());
            for (CartModel var:cartModel){
                orderdetailModel.setBid(var.getBid());
                orderdetailModel.setCounts(var.getCounts());
                orderdetailModel.setBuyprice(var.getPrice());
                orderDetailService.add(orderdetailModel);
            }
            return "redirect:/order/list";
        }
        return "redirect:/user/login";
    }

}
