package com.nick.validator.rules;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Just an object factory pattern used to 
 * encapsulate the creation of all the pre-defined
 * Implementations of {@code PasswordValidator}
 * 
 * @author Nick
 *
 */
@Component
public class ValidatorFactory {

    @Value("${min.password.length}")
    private int minPasswordLength;
    
    @Value("${max.password.length}")
    private int maxPasswordLength;
    
    private List<ValidationRule> validators;
    
    @PostConstruct
    public void init() {
	
	// create all of the needed PasswordValidator object instances and add to internal cached list
	validators = new ArrayList<>();
	validators.add((ValidationRule) new ValidateLength(minPasswordLength, maxPasswordLength));
	validators.add((ValidationRule) new ValidateCharactersAndDigits());
	validators.add((ValidationRule) new ValidateNonSequentialCharacters());
    }
    
    public List<ValidationRule> getAllValidators() { 
	return validators;
    };

}
