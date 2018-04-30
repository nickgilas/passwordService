package com.nick.passwordService.validator.strategies;

import org.junit.Before;

import com.nick.validator.rules.ValidateNonSequentialCharacters;
import com.nick.validator.rules.ValidationMessageType;

public class ValidateNonSequentialCharactersTest extends AbstractValidationTest<ValidateNonSequentialCharacters> {

	@Before
	public void setUp() throws Exception {
	    
		super.setValidator(new ValidateNonSequentialCharacters());
	}

	@Override
	public void runValidatorScenerios() {
	    
		assertValidationFailScenerio("babcdabcd", "string contained sequential values", ValidationMessageType.CONTAINS_SEQ_CHARS);
		
		assertValidationTrueScenerio("abc123b123", "string contained non-sequential values");
		
		assertValidationTrueScenerio("abc123b123", "string contained non-sequential values");

	}

}
