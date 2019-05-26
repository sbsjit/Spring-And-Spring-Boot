package com.shreejit.springProject.Controller;

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
	public String CheckUser(@ModelAttribute User u, Model model) {
		 if(uDao.userLogin(u.getUsername(), u.getPassword())) {
			 
			 model.addAttribute("user", u.getUsername());
			 
			 model.addAttribute("elist",eDao.getAllEmployee());
			 
			 return "home";
		 }
		 
		 model.addAttribute("error", "USER doesnt exists!!!");
		return "login";
	}
	
}
