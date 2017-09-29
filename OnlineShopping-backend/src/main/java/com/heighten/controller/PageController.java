package com.heighten.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping("/home")
	public String showPage(ModelMap m)
	{   
		m.addAttribute("greeting", "Welcome To Online Shopping Project");
		return "home";
	}
	@RequestMapping("/test")
	public String showGreeting(@RequestParam(value="key",required=false) String v,ModelMap m)
	{    
		if(v==null)
		{
			v= "Default Value";
		}
				m.addAttribute("MSG", v);
		 
		return "home";
	}
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView showPath(@PathVariable("greeting") String v)
	{
		ModelAndView mv=null;
		mv=new ModelAndView("home");  
		mv.addObject("MSG",v);
		//mv.setViewName("home");
		return mv;
	}

}
