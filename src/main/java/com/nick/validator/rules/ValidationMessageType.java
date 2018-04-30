package com.nick.validator.rules;

/**
 * Holds all of the keys found in the Messages[Local].properties files to help create a strongly
 * typed and easily refactored system for managing all message properties.
 */
public enum ValidationMessageType {
    
    MISSING_NUMBER_OR_NOT_LOWERCASE("missing.number.or.not.lowercase"),
    NULL_STRING("null.string"),
    STRING_TOO_SHORT("string.too.short"),
    STRING_TOO_LONG("string.too.long"),
    FOUND_CAPITAL_LETTERS("found.capital.letters"),
    
    NO_DIGIT_FOUND("no.digit"),
    NO_LETTER_FOUND("no.letter"),
    
    VALID_STRING("valid.string"),
    CONTAINS_SEQ_CHARS("string.contains.seq.chars"),
    UNKNOWN_EXCEPTION("unknown.error"),
   ;

    private String propertyName;

    private ValidationMessageType(String propertyName) {

        this.propertyName = propertyName;
    }

    public static final boolean isValidationMessageSuccessful(ValidationMessageType message) {

        return VALID_STRING.equals(message);
    }

    public String getPropertyName() {

        return propertyName;
    }
}
