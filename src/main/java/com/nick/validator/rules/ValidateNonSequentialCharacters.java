package com.nick.validator.rules;

import java.util.regex.Pattern;

import com.nick.passwordService.ValidationResponse;

public class ValidateNonSequentialCharacters implements ValidationRule {

	private Pattern checkSequenceRepetition = Pattern.compile("(\\w{2,})\\1");
	
	@Override
	public void validate(String value, ValidationResponse response) {

	    if (checkSequenceRepetition.matcher(value).find()) {
		    response.setValid(false);
		    response.addValidationMessage(ValidationMessageType.CONTAINS_SEQ_CHARS);
		}
		
	}

}
