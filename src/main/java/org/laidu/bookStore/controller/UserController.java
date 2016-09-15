package org.laidu.bookStore.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.laidu.bookStore.domain.User;
import org.laidu.bookStore.model.UserModel;
import org.laidu.bookStore.service.UserService;
import org.laidu.bookStore.util.CaptcharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by laidu on 16-9-13.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CaptcharUtil captcharUtil;
    private String captchar;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String preLogin(Model model){
        this.captchar = captcharUtil.getCaptchsr();
        model.addAttribute("captchar", this.captchar);
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model models, User userModel){

        userModel = userService.findByUsernameAndPassword(userModel.getUsername(), userModel.getPassword());
        if(null != userModel){
            request.getSession().setAttribute("user",userModel);
            return "redirect:/";
        }
        return "error";
    }

    @RequestMapping("/register")
    public String preRegister(){
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, UserModel userModel){

        if(userService.addUser(userModel)>0){
            request.getSession().setAttribute("user",userModel);
            return "register_success";
        }
        return "forward:/user/register";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){

        request.getSession().removeAttribute("user");
        return "redirect:/";
    }
}
