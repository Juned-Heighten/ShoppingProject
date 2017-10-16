package com.heighten.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.h.dao.CategoryDao;
import com.h.dao.ProductDao;
import com.h.dto.Category;
import com.h.dto.Product;
import com.heighten.exception.ProductNotFoundException;

@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDao dao;
	@Autowired
	ProductDao pDao;

	@RequestMapping("/home")
	public String showPage(ModelMap m) {

		m.addAttribute("greeting", "Welcome To Online Shopping Project");
		m.addAttribute("title", "Home");
		m.addAttribute("userClickHome", true);

		logger.info("Inside PageController showPage Method--->>INFO");
		logger.debug("Inside PageController showPage Method--->>DEBUG");
		List<Category> listCat = dao.list();
		m.addAttribute("listCat", listCat);
		System.out.println("Itemsssssssssss" + listCat);
		return "home";
	}

	@RequestMapping(value = "/contact")
	public String contact(ModelMap m) {
		System.out.println("Contact Method");
		m.addAttribute("title", "Contact Us");
		m.addAttribute("cnt", true);
		return "home";
	}

	@RequestMapping(value = "/about")
	public String about(ModelMap m) {
		System.out.println("About Us method");
		m.addAttribute("title", "About Us");
		m.addAttribute("abt", true);
		return "home";
	}

	@RequestMapping("/test")
	public String showGreeting(@RequestParam(value = "key", required = false) String v, ModelMap m) {
		if (v == null) {
			v = "Default Value";
		}
		m.addAttribute("MSG", v);

		return "home";
	}

	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView showPath(@PathVariable("greeting") String v) {
		ModelAndView mv = null;
		mv = new ModelAndView("home");
		mv.addObject("MSG", v);
		// mv.setViewName("home");
		return mv;
	}

	/**
	 * Show All Products
	 */
	@RequestMapping("/show/all/products")
	public String showAllProducts(ModelMap m) {
		List<Category> listCat = dao.list();
		m.addAttribute("listCat", listCat);
		m.addAttribute("title", "All Products");
		m.addAttribute("sap", true);
		return "home";
	}

	/**
	 * Load Products on the basis of Category
	 */

	@RequestMapping("/show/category/{id}/products")
	public String showCategoryProduct(@PathVariable("id") int id, ModelMap m) {
		Category c = null;
		c = dao.get(id);
		m.addAttribute("c", c);
		m.addAttribute("listCat", dao.list());
		m.addAttribute("title", c.getName());
		m.addAttribute("scp", true);
		return "home";
	}

	/**
	 * View Single Poduct
	 * 
	 * @throws ProductNotFoundException
	 */
	@RequestMapping(value = "/show/{id}/products")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv = null;
		Product p = null;
		mv = new ModelAndView("home");
		p = pDao.get(id);
		if (p == null) {
			throw new ProductNotFoundException();
		}
		p.setViews(p.getViews() + 1);
		pDao.update(p);
		mv.addObject("title", p.getName());
		mv.addObject("product", p);
		mv.addObject("userClickShowProduct", true);
		return mv;

	}

	/**
	 * Having Similar mapping to our Flow Id
	 * 
	 * @param m
	 * @return to avoid it use order=-1 in xml
	 */
	/*
	 * @RequestMapping(value="/register") public String register(ModelMap m) {
	 * return "home"; }
	 */

	@RequestMapping("/login")
	public ModelAndView showLogin(@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {

		ModelAndView m = null;
		m = new ModelAndView("login");
		if (error != null) {
			m.addObject("message", "Enter invalid credential");
		}
		if (logout != null) {
			m.addObject("logout", "Successfully logged out !");
		}
		m.addObject("title", "Login");
		return m;

	}

	@RequestMapping(value = "/access-denied")
	public ModelAndView showAccessDenied() {
		ModelAndView mv = null;
		mv = new ModelAndView("error");
		mv.addObject("title", "403 Access denied");
		mv.addObject("errorTitle", "Aha! caught you");
		mv.addObject("errorDesc", "You are not authorized to view this page");
		return mv;
	}

	@RequestMapping(value = "perform-logout")
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		// Fetch The Autentication Object
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(req, resp, auth);
		}
		return "redirect:/login?logout";
	}

}
