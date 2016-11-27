package com.parkhomenko.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.11.16.
 */

@Component("commentValidator")
public class CommentFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentFormValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return CommentEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        LOGGER.debug("Spring validator works");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "text.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone.required");
    }
}
