package com.shreejit.springProject.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shreejit.springProject.dao.EmployeeDao;
import com.shreejit.springProject.dao.UserDao;
import com.shreejit.springProject.model.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserDao uDao;
	@Autowired
	private EmployeeDao eDao;
	
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String getLoginForm() {
		
		
		
		return "login";
	}
	
	
	
	//Binding 
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String CheckUser(@ModelAttribute User u) {
		 if(u.getUsername().equals("admin") && u.getPassword().equals("root")) {
			 return "home";
		 }
		
		return "index";
	}*/
	
	//Static Login Check
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String CheckUser(@ModelAttribute User u, Model model) {
		 if(u.getUsername().equals("admin") && u.getPassword().equals("root")) {
			 
			 model.addAttribute("user", u.getUsername());
			 
			 return "home";
		 }
		 
		 model.addAttribute("error", "USER doesnt exists!!!");
		return "login";
	}*/
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String CheckUser(@ModelAttribute User u, Model model, HttpSession session, HttpServletRequest req) throws IOException {
		
		String input=req.getParameter("g-recaptcha-response");
		Boolean result=VerifyRecaptcha.verify(input);
		
		if(result) {
			if(uDao.userLogin(u.getUsername(), u.getPassword())) {
				 
				 session.setAttribute("activeUser",u.getUsername());
				 session.setMaxInactiveInterval(5*60);
				 
				 
				 model.addAttribute("user", u.getUsername());
				 
				 model.addAttribute("elist",eDao.getAllEmployee());
				 
				 return "home";
			 }	
			else {
				 model.addAttribute("error", "USER doesnt exists!!!");
					return "login";
			}
		}
		
			model.addAttribute("error", "You are not a human!!!");
			return "login";
		
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "login";
	}
	
	
}
