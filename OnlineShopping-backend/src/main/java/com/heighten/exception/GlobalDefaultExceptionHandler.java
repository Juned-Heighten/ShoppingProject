package com.heighten.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{   
		ModelAndView mv=null;
		mv=new ModelAndView("error");
		mv.addObject("errorTitle", "The Page is Not Constructed");
		mv.addObject("errorDesc","Under Construction");
		mv.addObject("title", "404 Error Page");
		
		
		return mv;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerForProductNotFoundException()
	{   
		ModelAndView mv=null;
		mv=new ModelAndView("error");
		mv.addObject("errorTitle", "The Product is not Available");
		mv.addObject("errorDesc","Product you are looking is not availabe");
		mv.addObject("title", "Product Not Found");
		return mv;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{   
		ModelAndView mv=null;
		mv=new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your Admin");
		mv.addObject("errorDesc",ex.toString());
		mv.addObject("title", "Error");
		return mv;
	}
}