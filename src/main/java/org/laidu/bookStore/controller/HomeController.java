package org.laidu.bookStore.controller;

import org.laidu.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by laidu on 16-9-13.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = {"/","/home"})
    public String home(Model model){

        /*if(msg==404)
            model.addAttribute("msg","杜康别nao");*/
        model.addAttribute("bookList",bookService.findList());
        return "index";
    }
}
