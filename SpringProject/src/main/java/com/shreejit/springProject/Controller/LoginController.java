package com.shreejit.springProject.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shreejit.springProject.dao.EmployeeDao;
import com.shreejit.springProject.dao.UserDao;
import com.shreejit.springProject.model.User;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@Autowired
	private UserDao uDao;
	@Autowired
	private EmployeeDao eDao;

	
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String getLoginForm() {
		logger.info("Login FOrm opened!!");
		return "login";
	}

	// Binding
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * CheckUser(@ModelAttribute User u) { if(u.getUsername().equals("admin") &&
	 * u.getPassword().equals("root")) { return "home"; }
	 * 
	 * return "index"; }
	 */

	// Static Login Check
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * CheckUser(@ModelAttribute User u, Model model) {
	 * if(u.getUsername().equals("admin") && u.getPassword().equals("root")) {
	 * 
	 * model.addAttribute("user", u.getUsername());
	 * 
	 * return "home"; }
	 * 
	 * model.addAttribute("error", "USER doesnt exists!!!"); return "login"; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String CheckUser(@ModelAttribute User u, Model model, HttpSession session, HttpServletRequest req)
			throws IOException {

		//Decryption
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		
		String input = req.getParameter("g-recaptcha-response");
		Boolean result = VerifyRecaptcha.verify(input);

		if (result) {
			
			
			if (uDao.userLogin(u.getUsername(), u.getPassword())) {

				logger.info("Login Success");
				
				session.setAttribute("activeUser", u.getUsername());
				session.setMaxInactiveInterval(5 * 60);

				model.addAttribute("user", u.getUsername());

				model.addAttribute("elist", eDao.getAllEmployee());

				return "home";
			} else {
				
				logger.info("Login failed!!");
				model.addAttribute("error", "USER doesnt exists!!!");
				return "login";
			}
		}
		logger.info("Login failed!!");
		model.addAttribute("error", "You are not a human!!!");
		return "login";

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		logger.info("Logout success !!");
		session.invalidate();
		return "login";
	}

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String fbLogin() {

		// String secret_key = "c85c3bbaeded9ce1ea6af891cc8733c2";
		// String app_id = "1439123129660532";

		return "redirect:https://www.facebook.com/dialog/oauth?client_id=429582644539983&redirect_uri=http://localhost:8080/springProject/authorize/facebook&response_type=code&scope=email";
	}

	@RequestMapping(value = "/authorize/facebook", method = RequestMethod.GET)
	public String saveFbUser(String code, Model model, HttpServletRequest request) {

		model.addAttribute("elist", eDao.getAllEmployee());

		return "home";

	}

	

	@RequestMapping(value = "/gmail", method = RequestMethod.GET)
	public String gmailLogin(){
		
		//String secret_key = "c85c3bbaeded9ce1ea6af891cc8733c2";
		//String app_id = "1439123129660532";
		
		return "redirect:https://www.gmail.com/dialog/oauth?client_id=979773237172-vikerglhrku9h7co38v1tqsq326o4k1o.apps.googleusercontent.com\r\n" + 
				"&redirect_uri=http://localhost:8080/springProject/authorize/gmail&response_type=code&scope=email";
	}
	
	
	
	@RequestMapping(value = "/authorize/gmail", method = RequestMethod.GET)
	public String saveGmailUser(String code, Model model, HttpServletRequest request){
		
		model.addAttribute("elist", eDao.getAllEmployee());
		
	      return "home";
	      
	      
	      
	      }
	
}
