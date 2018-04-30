package com.nick.passwordService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nick.validator.rules.ValidationMessageType;

/**
 * DTO that is used to communicate with clients as to the
 * results and messages of the resulting evaluation.
 *  
 * @author Nick
 *
 */
public class ValidationResponse implements Serializable{

    private static final long serialVersionUID = 9108527528780005514L;
    private boolean isValid = true;
    
    // external clients will look at the client messages 
    @JsonIgnore
    private List<ValidationMessageType> validationMessages = new ArrayList<>();

    private List<String> clientMessages = new ArrayList<>();
    
    public boolean isValid() {
	return isValid;
    }

    public void setValid(boolean isValid) {
	this.isValid = isValid;
    }

    public List<String> getClientMessages() {
	return clientMessages;
    }

    public void setValidationMessages(List<ValidationMessageType> validationMessages) {
	this.validationMessages = validationMessages;
    }
    
    public void addClientMessage(String message) {
	this.clientMessages.add(message);
    }
   
    public void addValidationMessage(ValidationMessageType validationMessage) {
	validationMessages.add(validationMessage);
	
    }

    public List<ValidationMessageType> getValidationMessages() {
	return validationMessages;
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
