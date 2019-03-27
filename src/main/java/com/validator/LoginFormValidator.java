package com.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.User;
import com.service.UserServiceImplementation;

@Component
public class LoginFormValidator implements Validator {

	@Autowired
	private UserServiceImplementation userServiceImplementation;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.username");
		//for this need to use @Valid annotation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.password");
		User userForm = (User) target;
		String username = userForm.getUsername().trim();
//        if (username.isEmpty()) {
//            errors.rejectValue("username", null, "Username is required!");
//        }
        
        String password = userForm.getPassword();
//        if (password.isEmpty()) {
//            errors.rejectValue("password", null, "Password is required!");
//        }

		if(!username.isEmpty() && !password.isEmpty())
		{
			try {
                userServiceImplementation.getUser(username, password);
            } catch (IllegalArgumentException ex) {
                errors.rejectValue("username", null, ex.getMessage() + "!");
            }
		}
	}
}
//==================================================================================================
//String username = userForm.getUsername().trim();
//if (username.isEmpty()) {
//    errors.rejectValue("username", "NotEmpty.userCommand.username");
//   // errors.rejectValue("username", null, "NotEmpty.username");
//}
//String password = userForm.getPassword();
//if (password.isEmpty()) {
//    errors.rejectValue("password", null, "Password is required!");
//}		

