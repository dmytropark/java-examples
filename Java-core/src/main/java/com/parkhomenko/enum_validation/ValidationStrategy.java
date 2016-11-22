package com.parkhomenko.enum_validation;

/**
 * @author Dmytro Parkhomenko
 *         Created on 26.10.16.
 */

public interface ValidationStrategy {
    <T extends UserInput> boolean validate(T input);
    ValidationType getValidationType();
}
