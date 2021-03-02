package com.yjcloud.chatroom.demo.controller;

import com.yjcloud.chatroom.demo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    private ProviderService providerService;
    @RequestMapping("/login")
    String login(){
        return "/login";
    }
    @RequestMapping("/index")
    String index(){
        return "/index";
    }

    @ResponseBody
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable(value = "name")String name){

        return providerService.sayHello(name);
    }
    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","jackson");
        modelAndView.setViewName("/test");
        return modelAndView;
    }
}