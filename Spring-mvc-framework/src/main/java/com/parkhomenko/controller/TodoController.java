package com.parkhomenko.controller;

import com.parkhomenko.Todo;
import com.parkhomenko.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dmytro Parkhomenko
 *         Created on 03.12.16.
 */

@Controller
public class TodoController {

    private final TodoService service;

    private final MessageSource messageSource;

    @Autowired
    public TodoController(MessageSource messageSource, TodoService service) {
        this.messageSource = messageSource;
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAll(Model model) {
        List<Todo> models = service.findAll();
        model.addAttribute("todos", models);
        return "todo/list";
    }

    @RequestMapping(value = "/testexample", method = RequestMethod.GET)
    public Map<String, String> get() {
        Map<String, String> res = new HashMap<String, String>();
        res.put("key1", "val1");
        res.put("key2", "val2");
        return res;
    }
}