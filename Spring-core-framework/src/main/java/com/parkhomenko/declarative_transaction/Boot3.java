package com.parkhomenko.declarative_transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.09.16.
 */

public class Boot3 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("tx-context-3.xml");
        FooService fooService = (FooService) ctx.getBean("fooService");
        fooService.updateFoo(new Foo());
    }
}
