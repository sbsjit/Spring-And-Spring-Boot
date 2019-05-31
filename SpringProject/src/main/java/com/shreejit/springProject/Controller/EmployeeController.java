package com.shreejit.springProject.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shreejit.springProject.dao.EmployeeDao;
import com.shreejit.springProject.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao eDao;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getEmployeeForm(Model model, HttpSession session) {

		if (StringUtils.isEmpty(session.getAttribute("activeUser"))) {
			return "login";
		}

		model.addAttribute("emodel", new Employee());
		return "employeeForm";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee emp, Model model, HttpSession session) {

		if (StringUtils.isEmpty(session.getAttribute("activeUser"))) {
			return "login";
		}

		eDao.addEmployee(emp);
		model.addAttribute("elist", eDao.getAllEmployee());

		return "home";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") int id, Model model,HttpSession session) {

		if(StringUtils.isEmpty(session.getAttribute("activeUser"))) {
			return "login";
		}	
		eDao.deleteEmployee(id);
		model.addAttribute("elist", eDao.getAllEmployee());
		return "home";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editEmployee(@PathVariable("id") int id, Model model,HttpSession session) {

		if(StringUtils.isEmpty(session.getAttribute("activeUser"))) {
			return "login";
		}
		model.addAttribute("emodel", eDao.getById(id));
		return "editForm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String editEmployee(@ModelAttribute Employee emp, Model model,HttpSession session) {
		if(StringUtils.isEmpty(session.getAttribute("activeUser"))) {
			return "login";
		}
		eDao.updateEmployee(emp);
		model.addAttribute("elist", eDao.getAllEmployee());
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model,HttpSession session) {
		if(StringUtils.isEmpty(session.getAttribute("activeUser"))) {
			return "login";
		}
		model.addAttribute("elist", eDao.getAllEmployee());
		return "home";

	}

}
