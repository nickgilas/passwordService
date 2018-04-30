package com.nick.validator.rules;

import com.nick.passwordService.ValidationResponse;

public interface ValidationRule {

    /**
     * Used to define the needed behavior that concrete 
     * implementation will be responsible for implementing 
     * the discrete rules. Based on the strategy design pattern.
     * 
     * @param val the string to be evaluated
     * @return a {@link ValidationResponse} instance where 
     * the success or failed messages will be added for the caller
     * 
     * @author Nick
     */
     abstract void validate(String value, ValidationResponse response);
}