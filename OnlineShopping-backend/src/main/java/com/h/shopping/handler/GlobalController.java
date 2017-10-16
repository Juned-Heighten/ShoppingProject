package com.h.shopping.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.h.dao.UserDao;
import com.h.dto.User;
import com.h.shopping.model.UserModel;

@ControllerAdvice
public class GlobalController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private HttpSession session;
	private UserModel userModel = null;

	@ModelAttribute("userModel")
	private UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			// Add The UserModel
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			// Fetch The User
			User u = userDao.getByEmail(auth.getName());

			// If user is present
			if (u != null) {
				// Create a new UserModel Object To pass the user Details
				userModel = new UserModel();
				userModel.setId(u.getId());
				userModel.setEmail(u.getEmail());
				userModel.setRole(u.getRole());
				userModel.setFullName(u.getFirstName() + " " + u.getLastName());
				if (userModel.getRole().equals("USER")) {
					// Set The Cart
					userModel.setCart(u.getCart());
				}
				// set the UserModel in session
				session.setAttribute("userModel", userModel);
				return userModel;

			}
		}
		return (UserModel) session.getAttribute("userModel");
	}

}
