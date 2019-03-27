package com.validator;

import static com.global.Globals_for_web.isValidEmailAddress;
import static com.global.Globals_for_web.isValidUKPostcode;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.User;
import com.service.UserServiceImplementation;

@Component
public class RegistrationFormValidator implements Validator {

	@Autowired
	private UserServiceImplementation userServiceImplementation;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.sex");
		// email empty check @NotEmpty annotation in model in User class // just for all type learning
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ddate", "NotEmpty.joiningdate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subcription", "NotEmpty.subcription");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine", "NotEmpty.addressLine");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postcode", "NotEmpty.postCode");
		
		User registrationForm = (User) target;
		
		String userName = registrationForm.getUsername();
		if(!userName.isEmpty() && userServiceImplementation.exists(userName))
		{
			errors.rejectValue("username", null, "User name is already exist!");
		}
		String password = registrationForm.getPassword();
		String password2 = registrationForm.getPassword2();
		if(!password.isEmpty() && !password.equals(password2))
		{
			errors.rejectValue("password2", null, "Password and retype password not match!");
		}
		
//		Date ddatee = registrationForm.getDdate();
//		if(ddatee==null)
//		{
//			errors.rejectValue("ddate", null, "Joining date is required!");
//		}
		
		String email = registrationForm.getEmail();
		if(!email.isEmpty() && !isValidEmailAddress(email))
		{
			errors.rejectValue("email", null, "Put a valid email address!");
		}
		String postcode = registrationForm.getPostcode();
		if(!postcode.isEmpty() && !isValidUKPostcode(postcode))
		{
			errors.rejectValue("postcode", null, "This is not a valid UK postcode!");
		}
	}
}

//=============================================================================================
//User registrationForm = (User) target;
//
//String userName = registrationForm.getUsername();
//if(userName.isEmpty())
//{
//	errors.rejectValue("username", null, "User name is required!");
//}
//else if(userServiceImplementation.exists(userName))
//{
//	errors.rejectValue("username", null, "User name is already exist!");
//}
//
//String password = registrationForm.getPassword();
//String password2 = registrationForm.getPassword2();
//if(password.isEmpty())
//{
//	errors.rejectValue("password", null, "Password is required!");
//}
//else if(!password.equals(password2))
//{
//	errors.rejectValue("password2", null, "Password and retype password not match!");
//}
//// Sex validation
//String sex = registrationForm.getSex();
//if (sex == null) {
//    errors.rejectValue("sex", null, "Sex is required!");
//}
//String email = registrationForm.getEmail();
//if(!email.isEmpty() && !isValidEmailAddress(email))
//{
//	errors.rejectValue("email", null, "Put a valid email address!");
//}
//Date ddate = registrationForm.getDdate();
//if(ddate==null)
//{
//	errors.rejectValue("ddate", null, "Joining date is required!");
//}
//Double subscription = registrationForm.getSubcription();
//if(subscription==null)
//{
//	errors.rejectValue("subcription", null, "Subscription is required!");
//}
//String address = registrationForm.getAddressLine();
//if(address.isEmpty())
//{
//	errors.rejectValue("addressLine", null, "Address is required!");
//} 
//String postcode = registrationForm.getPostcode();
//if (postcode.isEmpty()) {
//    errors.rejectValue("postcode", null, "Postcode is required!");
//}
//else if(!isValidUKPostcode(postcode))
//{
//	errors.rejectValue("postcode", null, "This is not a valid UK postcode!");
//}