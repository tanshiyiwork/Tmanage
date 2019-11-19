package com.github.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @RequestMapping(value= {"/","/welcome**"},method= RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView welcome = new ModelAndView();
        welcome.addObject("title","welcome");
        welcome.addObject("message","this is a security page");
        welcome.setViewName("hello");
        return welcome;
    }

    @RequestMapping(value="/admin**",method=RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView welcome = new ModelAndView();
        welcome.addObject("title","admin");
        welcome.addObject("message","this is a admin page");
        welcome.setViewName("admin");
        return welcome;
    }

}
