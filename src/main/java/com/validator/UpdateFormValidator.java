package com.validator;

import static com.global.Globals_for_web.isValidEmailAddress;
import static com.global.Globals_for_web.isValidUKPostcode;

//import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.User;

@Component
public class UpdateFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.sex");
		// email empty check @NotEmpty annotation in model in User class // just for all type learning
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "NotEmpty.dob");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ddate", "NotEmpty.joiningdate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subcription", "NotEmpty.subcription");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine", "NotEmpty.addressLine");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postcode", "NotEmpty.postCode");
		
		User updateForm = (User) target;
		
		String email = updateForm.getEmail();
		if(!email.isEmpty() && !isValidEmailAddress(email))
		{
			errors.rejectValue("email", null, "Put a valid email address!");
		}
		String postcode = updateForm.getPostcode();
		if(!postcode.isEmpty() && !isValidUKPostcode(postcode))
		{
			errors.rejectValue("postcode", null, "This is not a valid UK postcode!");
		}
	}
}
