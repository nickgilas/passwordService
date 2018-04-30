package com.nick.validator.rules;

import java.util.regex.Pattern;

import com.nick.passwordService.ValidationResponse;

public class ValidateCharactersAndDigits implements ValidationRule {

    private Pattern upperCasePattern = Pattern.compile("[A-Z]");
    private Pattern letterAndDigitPattern = Pattern.compile("[a-z]+\\d+|\\d+[a-z]+");
    
    @Override
    public void validate(String value, ValidationResponse response) {

	if (upperCasePattern.matcher(value).find()) {
	    response.setValid(false);
	    response.addValidationMessage(ValidationMessageType.FOUND_CAPITAL_LETTERS);
	}
	
	if (letterAndDigitPattern.matcher(value).find() == false) {
	    response.setValid(false);
	    response.addValidationMessage(ValidationMessageType.MISSING_NUMBER_OR_NOT_LOWERCASE);
	}
    }

}
