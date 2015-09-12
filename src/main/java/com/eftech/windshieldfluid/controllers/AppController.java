package com.eftech.windshieldfluid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
   public String index() {
       //map.put("msg", "Hello Spring 4 Web MVC!");
       return "index";
   }
}
