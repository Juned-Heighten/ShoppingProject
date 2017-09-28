package com.heighten.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/home")
	public String showPage(ModelMap m)
	{   
		m.addAttribute("greeting", "Welcome To Online Shopping Project");
		return "home";
	}

}
