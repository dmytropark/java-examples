package com.parkhomenko.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.11.16.
 */

@RestController
public class ControllerWithSpringValidator {

    @Autowired
    @Qualifier("commentValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @PostMapping(value = "/spring/validator/comment")
    public String addComment(@Valid @RequestBody CommentEntity commentEntity, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "error";
        }

        //do some job here

        return "created";
    }
}
