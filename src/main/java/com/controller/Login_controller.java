package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.service.UserServiceImplementation;
import com.validator.LoginFormValidator;

@Controller
public class Login_controller {

	@Autowired
	private UserServiceImplementation userServiceImplementation;
	@Autowired
	private LoginFormValidator loginFormValidator;
	
	@RequestMapping(value="/login", method=RequestMethod.GET) // if not specify anything then by default method=RequestMethod.GET
	public ModelAndView loginPage()
	{
		ModelAndView mv = new ModelAndView("login", "userCommand", new User());// this code when spring form use
		return mv;
	}
	
	@RequestMapping(value="/submit", method = RequestMethod.POST)
	public ModelAndView submit(@Valid HttpServletRequest request, @ModelAttribute("userCommand") User command, BindingResult result)
	{
		loginFormValidator.validate(command, result); // validator  check user and password correct or not
		if (result.hasErrors()) { // if not correct
            return new ModelAndView("login");
        }
		List<User> list = userServiceImplementation.getEmployeeByName(command.getUsername());
		if(!list.isEmpty())
		{
			request.getSession().setAttribute("userLogged", command.getUsername());
			return new ModelAndView("viewIndividualUser", "list", list);
		}
		return new ModelAndView("login");	
	}
	
	@RequestMapping(value="/loginWithSecurity", method=RequestMethod.GET) // if not specify anything then by default method=RequestMethod.GET
	public ModelAndView loginWithSecurityPage()
	{
		ModelAndView mv = new ModelAndView("login_using_spring_security", "userCommand", new User());// this code when spring form use
		return mv;
	}
	@RequestMapping(value="/option", method=RequestMethod.GET) // if not specify anything then by default method=RequestMethod.GET
	public ModelAndView optionPage()
	{
		ModelAndView mv = new ModelAndView("options_where_to_go");// vew name
		return mv;
	}
}
