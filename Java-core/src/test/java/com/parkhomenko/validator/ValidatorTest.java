package com.parkhomenko.validator;

import com.parkhomenko.enum_validation.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Dmytro Parkhomenko
 *         Created on 26.10.16.
 */

public class ValidatorTest {

    @Test
    public void testValidatorForDOB() {

        Set<ValidationStrategy> strategies = new LinkedHashSet<>();

        strategies.add(UserValidationStrategy.DATE_OF_BIRTH);

        strategies.add(UserValidationStrategy.CITY);

        UserInput input = new UserInput();

        input.setUserValid(true);

        input.setDateOfBirth("");

        UserValidationContext ctxUser = new UserValidationContext(strategies);

        Assert.assertEquals(ValidationType.DATE_OF_BIRTH, ctxUser.execute(input));
    }
}
