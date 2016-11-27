package com.parkhomenko.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.11.16.
 */

@RestController
public class ControllerWithSpringAndHibernateValidators {

    @Autowired
    @Qualifier("commentValidator")
    private Validator validator;

    @PostMapping(value = "/springhibernate/validator/comment")
    public String addComment(@Valid @RequestBody CommentEntity commentEntity, BindingResult bindingResult) {

        validator.validate(commentEntity, bindingResult);

        if(bindingResult.hasErrors()) {
            return "error";
        }

        //do some job here

        return "created";
    }
}
