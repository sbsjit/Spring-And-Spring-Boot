package com.shreejit.springProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shreejit.springProject.dao.UserDao;
import com.shreejit.springProject.model.User;
import com.sun.mail.smtp.DigestMD5;

@Controller
public class SignUpController {
	
	@Autowired  //
	private UserDao uDao; // UserDao user = new UserDaoImpl();  is the work done by autowiring
	
	
	@RequestMapping(value = "/userSignUp", method = RequestMethod.GET)
	public String getSignUpForm() {
		
		
		return "signUp";
	}
	
	@RequestMapping(value = "/userSignUp", method = RequestMethod.POST)
	public String saveUserData(@ModelAttribute User u, Model model) {
		
		/*PrintWriter out=new PrintWriter(System.out);
		out.println("Signed Up");*/
		
		//Encryption
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		uDao.userSignUp(u);
		
		return "login";
	}
	
}
