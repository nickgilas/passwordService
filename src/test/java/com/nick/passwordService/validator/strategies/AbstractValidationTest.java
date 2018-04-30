package com.nick.passwordService.validator.strategies;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.nick.passwordService.ValidationResponse;
import com.nick.validator.rules.ValidationMessageType;
import com.nick.validator.rules.ValidationRule;

/**
 * Base test class for all test cases that execute against an instance of
 * {@link ValidationRule} The class is based on the template and strategy design
 * patterns as it defines the overall steps needed for each individual test
 * implementation while it delegates the test logic to the implementations of
 * this class.
 * 
 * @author Nick
 */
@RunWith(SpringRunner.class)
public abstract class AbstractValidationTest<T extends ValidationRule> {

    private T validator;

    private ValidationResponse response;

    @Before
    public void setup() {
	response = new ValidationResponse();
    }

    @Test
    public void testValidatorScenerios() {
	runValidatorScenerios();
    }

    public abstract void runValidatorScenerios();

    public void assertValidationTrueScenerio(String data, String failMessage) {
	resetResponseObject();
	
	validator.validate(data, response);
	assertTrue(getFailedMessage(failMessage), response.isValid());
    }

    private void resetResponseObject() {
	getValidationResponse().getValidationMessages().clear();
	getValidationResponse().setValid(true);
    }

    public void assertValidationFailScenerio(String data, String failMessage) {
	resetResponseObject();
	assertValidationFailScenerio(data, failMessage, null);
    }
    
    public void assertValidationFailScenerio(String data, String failMessage, ValidationMessageType expectedErrorCode) {

	// reset the validation response for this test
	resetResponseObject();
	validator.validate(data, getValidationResponse());
	
	if (expectedErrorCode != null) {
	    assertTrue("Missing validation message in response: " + expectedErrorCode.getPropertyName(),  getValidationResponse().getValidationMessages().contains(expectedErrorCode));
	} else {
	    // expect at least one error message 
	    assertFalse(getFailedMessage(failMessage), response.getValidationMessages().isEmpty());
	}
	
	// not valid verification
	assertTrue(getFailedMessage(failMessage), response.isValid() == false);
	
    }

    private String getFailedMessage(String failMessage) {
	return "Validator failed [" + validator.getClass().getName() + "], message: " + failMessage;
    }
    
    public ValidationResponse getValidationResponse() {
	return response;
    }

    public void setValidator(T validator) {
	this.validator = validator;
    }

    public T getValidator() {
	return validator;
    }

}
