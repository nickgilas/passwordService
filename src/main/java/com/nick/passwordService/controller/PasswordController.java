package com.nick.passwordService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nick.passwordService.PasswordService;
import com.nick.passwordService.ValidationResponse;
import com.nick.validator.rules.ValidationMessageType;

/**
 * Spring MVC rest controller for handing incoming HTTP
 * requests and returning responses.
 */
@RestController
public class PasswordController  {
    private static Logger LOG = LoggerFactory.getLogger(PasswordController.class);
    
    @Autowired
    private PasswordService passwordService;
    
    @Autowired
    private Environment env;
    
    /**
     * HTTP POST Endpoint to evaluate and provide a response
     * back to the client regarding the validation results.
     *  
     * @param password to be validated
     * 
     * @return a {@link ValidationResponse} with client messages and status
     */
    @GetMapping(path="/validate/{password}")    
    public ValidationResponse validatePassword(@PathVariable(required = true) String password) {
	
	ValidationResponse response = passwordService.validate(password);
	convertMessages(response);
	return response;
	
    }
    
    private void convertMessages(ValidationResponse response) {

	// convert all of the ValidationResponse.messages java enum values to value in application properties file
	for (ValidationMessageType type : response.getValidationMessages()) {
	    String clientMessage = env.getProperty(type.getPropertyName());
	    response.addClientMessage(clientMessage);
	    LOG.trace("Converting message: " + type.getPropertyName() + " -> " + clientMessage);
	}
    }

}
