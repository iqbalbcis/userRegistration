package com.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.global.Globals_for_web;
import com.model.User;
import com.service.UserServiceImplementation;
import com.validator.RegistrationFormValidator;
import com.validator.UpdateFormValidator;

@Controller
public class Registration_controller {
	
	@Autowired
	private UserServiceImplementation userServiceImplementation;
	@Autowired
	private RegistrationFormValidator registrationFormValidator;
	@Autowired
	private UpdateFormValidator updateFormValidator;
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView rgeisterForm() {
		ModelAndView mv = new ModelAndView("register", "userCommand", new User());
		return mv;
	}
	@ModelAttribute
	public void setupDateForForm(Model model) {
		model.addAttribute("dobDays", Globals_for_web.DAYS_OF_MONTH); // DAYS_OF_MONTH list
		model.addAttribute("dobMonths", Globals_for_web.MONTHS_OF_YEAR); //here list now, if MONTHS_OF_YEAR is map, for map, value will come in item
		model.addAttribute("dobYears", Globals_for_web.birthYears()); // return type list
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@Valid @ModelAttribute("userCommand") User command, BindingResult result) {
		// @valid uses bsc hibernate validation used for email field
		
		registrationFormValidator.validate(command, result);
		if (result.hasErrors()) { // if not correct
            return new ModelAndView("register");
        }
		String dob = ""+command.getDobDay()+"/"+command.getDobMonth()+"/"+command.getDobYear();
		DateFormat format = new SimpleDateFormat("dd/MMMM/yyyy");
        try {
			command.setDateOfBirth(new Date(format.parse(dob).getTime()));
		} catch (ParseException e) {
			System.out.println(e);
		} // custom date has been set, other will get automatically
       
        userServiceImplementation.insertData(command);
		return new ModelAndView("redirect:/success");
	}

	@RequestMapping(value="/success", method=RequestMethod.GET)
	public ModelAndView viewIndividualUser()
	{
		return new ModelAndView("success"); // if correct
	}
	@RequestMapping(value="/viewAllUsers", method=RequestMethod.GET) // it going html and jsp form
	public ModelAndView viewAllUsers()
	{
		List<User> list = userServiceImplementation.getAllUsers();
		if(!list.isEmpty())
		{
			return new ModelAndView("viewAllUsers", "list", list); // if correct
		}
		return new ModelAndView("redirect:/registration");
	}
	@RequestMapping(value="/editUser/{id}")  
    public ModelAndView edit(@PathVariable long id){ // model attaribute spring form doesn't work
		User user = userServiceImplementation.find(id);
		return new ModelAndView("editUserForUpdate","userCommand", user);  
		// form and value declare should be in spring form // otherwise won't come automatically(form:input)
		//just set Modelattribute 'userCommand' to edit form then user value will come to the field automatically
    }
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@Valid @ModelAttribute("userCommand") User user, BindingResult result) {
		// @valid uses bsc hibernate validation used for email field
		updateFormValidator.validate(user, result);
		if (result.hasErrors()) { // if not correct
            return new ModelAndView("editUserForUpdate");
        }
		User updateUser = userServiceImplementation.find(user.getUserId());
		//System.out.println(updateUser.getUserId());
		updateUser.setUsername(user.getUsername());
		updateUser.setSex(user.getSex());
		updateUser.setEmail(user.getEmail());
		updateUser.setDateOfBirth(user.getDateOfBirth());
		updateUser.setDdate(user.getDdate());
		updateUser.setSubcription(user.getSubcription());
		updateUser.setAddressLine(user.getAddressLine());
		updateUser.setPostcode(user.getPostcode());
		userServiceImplementation.updateUser(updateUser);
        return new ModelAndView("redirect:/viewAllUsers");
	}
	
	@RequestMapping(value="/deleteUser/{id}", method = RequestMethod.GET)  
    public ModelAndView deleteUser(@PathVariable long id){ 
		userServiceImplementation.deleteUser(id);
		return new ModelAndView("redirect:/viewAllUsers");
    }
}

//=======================================================================
//@RequestMapping(value="/updateUser")  
//public ModelAndView updateUser(@RequestParam Map<String, String> map){ 
//	//hence edit form not contain(date type)  of all data of User then @ModelAttribute("userCommand") User command won't work in this case
//	
//	User user = userServiceImplementation.find(Long.parseLong(map.get("userId")));
//	//System.out.println(user.getUserId());
//	user.setUsername(map.get("username"));
//  user.setSex(map.get("sex"));
//	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	try {
//		user.setDateOfBirth(format.parse(map.get("dateOfBirth")));
//	} catch (ParseException e) {
//		System.out.println(e);
//	}
//	user.setDdate(java.sql.Date.valueOf(LocalDate.parse(map.get("ddate"))));
//	user.setSubcription(Double.parseDouble(map.get("subcription")));
//	user.setAddressLine(map.get("addressLine"));
//	user.setPostcode(map.get("postcode"));
//	
//  userServiceImplementation.updateUser(user);
//
//	return new ModelAndView("redirect:/viewAllUsers");
//}