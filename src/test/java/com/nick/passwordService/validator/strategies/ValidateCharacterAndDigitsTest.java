package com.nick.passwordService.validator.strategies;

import org.junit.Before;

import com.nick.validator.rules.ValidateCharactersAndDigits;
import com.nick.validator.rules.ValidationMessageType;

public class ValidateCharacterAndDigitsTest extends AbstractValidationTest<ValidateCharactersAndDigits> {

    @Before
    public void setup() {
	super.setup();
	super.setValidator(new ValidateCharactersAndDigits());
    }

    @Override
    public void runValidatorScenerios() {
	
	assertValidationTrueScenerio("1234ght", "Valid string starting with digits should not have failed validation");
	assertValidationTrueScenerio("abc1234", "Valid string starting with character should not have failed validation");
	
	assertValidationFailScenerio("12345","string should have failed as it contains all digits", ValidationMessageType.MISSING_NUMBER_OR_NOT_LOWERCASE);
	
	assertValidationFailScenerio("abcde", "string should have failed with no digits included", ValidationMessageType.MISSING_NUMBER_OR_NOT_LOWERCASE);
	
	assertValidationFailScenerio("aBcdef", "string should have failed with uppercase characters included", ValidationMessageType.FOUND_CAPITAL_LETTERS);
	
    }
}
