package com.parkhomenko.validation;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.11.16.
 */

@RestController
public class ControllerWithHibernateValidator {

    @PostMapping(value = "/hibernate/validator/comment")
    public String addComment(@Valid @RequestBody CommentEntity commentEntity, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "error";
        }

        //do some job here

        return "created";
    }
}
