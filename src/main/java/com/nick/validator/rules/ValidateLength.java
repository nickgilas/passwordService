package com.nick.validator.rules;

import org.apache.commons.lang3.StringUtils;

import com.nick.passwordService.ValidationResponse;

public class ValidateLength implements ValidationRule {

    private final int minPasswordLength;    
    private final int maxPasswordLength;
    
    public ValidateLength(int minPasswordLength, int maxPasswordLength) {
	super();
	this.minPasswordLength = minPasswordLength;
	this.maxPasswordLength = maxPasswordLength;
    }

    @Override
    public void validate(String val, ValidationResponse response) {
	
	if (StringUtils.isEmpty(val)) {
	    response.addValidationMessage(ValidationMessageType.NULL_STRING);
	    response.setValid(false);
	    return;
	}
	
	if (val.length() < minPasswordLength) {
	    response.addValidationMessage(ValidationMessageType.STRING_TOO_SHORT);
	    response.setValid(false);
	    
	} else if (val.length() > maxPasswordLength) {
	    response.setValid(false);
	    response.addValidationMessage(ValidationMessageType.STRING_TOO_LONG);
	}
    }

}
