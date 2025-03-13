package com.cosmetic.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	 @GetMapping("/home")
	    public String home() {
	        return "home.html";
	    }
	 
//	 @GetMapping("/order")
//	    public String order() {
//	        return "order.html";
//	    }
}
