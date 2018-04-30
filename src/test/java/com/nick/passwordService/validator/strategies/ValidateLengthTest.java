package com.nick.passwordService.validator.strategies;

import org.junit.Before;

import com.nick.validator.rules.ValidateLength;
import com.nick.validator.rules.ValidationMessageType;

public class ValidateLengthTest extends AbstractValidationTest<ValidateLength> {

    	private static final int MIN_LENGTH = 5;
    	private static final int MAX_LENGTH = 12;
    	
	@Before
	public void setUp() throws Exception {
	    super.setup();
	    setValidator(new ValidateLength(MIN_LENGTH, MAX_LENGTH));
	}

	@Override
	public void runValidatorScenerios() {
	    
	    // null & empty
	    assertValidationFailScenerio(null, "Null string didn't fail validation", ValidationMessageType.NULL_STRING);

	    assertValidationFailScenerio("", "Empty string didn't fail validation", ValidationMessageType.NULL_STRING);

	    // min length
	    assertValidationFailScenerio("ab", "sting too short didn't fail validation", ValidationMessageType.STRING_TOO_SHORT);
	    
	    // max length
	    assertValidationFailScenerio("abcd1234567891011", "string too long didn't fail validation", ValidationMessageType.STRING_TOO_LONG);
	   
	    // Valid
	    assertValidationTrueScenerio("123fgh", "valid string failed validation");
	    
	}

}
