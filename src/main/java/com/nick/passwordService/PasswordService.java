package com.nick.passwordService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.validator.rules.ValidationMessageType;
import com.nick.validator.rules.ValidationRule;
import com.nick.validator.rules.ValidatorFactory;

/**
 * This service class is responsible for controlling all aspects of 
 * password validation process. It utilizes one or more instances of the {@link ValidationRule}
 * that are configured in the {@link ValidatorFactory} to evaluate each password validation request.
 * A {@link ValidationResponse} is the DTO object for communicating success/failure and internationalized
 * error messages.
 * </br>
 * Currently, the validation attributes that needs to handled properly include:
 * <ol>
 * <li>Cannot be empty
 * <li>Must be between 5 and 12 characters in length
 * <li>Must contain at least one digit and one letter
 * <li>Cannot contain any sequence of characters immediately followed by the
 * same sequence
 * </ol>
 * 
 * @author Nick
 *
 */
@Service
public class PasswordService {
    private static Logger LOG = LoggerFactory.getLogger(PasswordService.class);
    
    @Autowired
    private ValidatorFactory validatorFactory;

    public ValidationResponse validate(String password) {
	
	LOG.trace("Starting to validate password: " + password);
	ValidationResponse response = new ValidationResponse();
	
	try {
	   
	    for (ValidationRule validator: validatorFactory.getAllValidators()) {

		 validator.validate(password, response);
	    }
	    
	    if (response.isValid()) {
		response.addValidationMessage(ValidationMessageType.VALID_STRING);
	    }
	    
	} catch (Exception e) {
	    LOG.error("Error occurred during validation process: " + e.getMessage(), e);
	    response.setValid(false);
	    response.addValidationMessage(ValidationMessageType.UNKNOWN_EXCEPTION);
	}
	LOG.trace("Result of response: " + response);
	return response;
    }
   
}
