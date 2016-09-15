package org.laidu.bookStore.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.laidu.bookStore.domain.Cart;
import org.laidu.bookStore.model.CartModel;
import org.laidu.bookStore.model.UserModel;
import org.laidu.bookStore.service.BookService;
import org.laidu.bookStore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by laidu on 16-9-13.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model) {

        UserModel userModel = (UserModel) request.getSession().getAttribute("user");
        if (userModel != null) {

            List<CartModel> cartModelList = cartService.findListByUid(userModel.getId());
            float totalprice = 0f;
            for (CartModel var:cartModelList){

                totalprice += var.getTotalprice();
            }
            model.addAttribute("totalprice", totalprice);
            model.addAttribute("cartList", cartModelList);
            return "cart";
        }
        return "redirect:/user/login";

    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, int[] bid) {

        UserModel userModel = (UserModel) request.getSession().getAttribute("user");
        CartModel cart = new CartModel();
        for (int var:bid){
            cart.setUid(userModel.getId());
            cart.setBid(var);
            cart.setCounts(1);
            cart.setPrice(bookService.findDetial(var).getPrice());
            cart.setTotalprice(bookService.findDetial(var).getPrice());
            cartService.addCart(cart);
        }

        return "redirect:/cart/list";
    }
    @RequestMapping("/del")
    public  String del(@RequestParam("cartId") int cid){

        cartService.delCart(cid);
        return "redirect:/cart/list";
    }

    @RequestMapping("/delByBid")
    public  String delByBid(@RequestParam("bid") int bid, HttpServletRequest request){

        UserModel userModel = (UserModel) request.getSession().getAttribute("user");

        if (userModel != null) {

            cartService.delCartByBid(userModel.getId(),bid);
            return "redirect:/cart/list";
        }
        return "redirect:/user/login";
    }

    @RequestMapping("/clean")
    public String calen(HttpServletRequest request){

        UserModel userModel = (UserModel) request.getSession().getAttribute("user");
        if (userModel != null) {

            cartService.clean(userModel.getId());
        }
        return "redirect:/cart/list";
    }

}
