package com.parkhomenko.enum_validation;

/**
 * @author Dmytro Parkhomenko
 *         Created on 26.10.16.
 */

public enum UserValidationStrategy implements ValidationStrategy {

    DATE_OF_BIRTH (ValidationType.DATE_OF_BIRTH) {

        @Override
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.getDateOfBirth().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    CITY (ValidationType.CITY) {

        @Override
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.getCity().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    UNSUPPORTED (ValidationType.UNSUPPORTED) {

        @Override
        public <T extends UserInput> boolean validate(T input) {
            return false;
        }
    };

    private ValidationType validationType;

    private UserValidationStrategy(ValidationType validationType) {
        this.validationType = validationType;
    }

    @Override
    public ValidationType getValidationType() {
        return validationType;
    }
}
