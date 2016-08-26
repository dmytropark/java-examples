package com.parkhomenko.minimal_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Dmytro Parkhomenko
 *         Created on 26.08.16.
 */

@Component
public class MinimalSpringAppXMLSchemaBasedConfiguration {
    @Autowired
    private Foo myBean;

    public void sayHello() {
        System.out.println(myBean.run("Hello World - "));
    }

    public static void main(final String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("minimal-app-application-config.xml");
        final MinimalSpringAppXMLSchemaBasedConfiguration bean = context.getBean(MinimalSpringAppXMLSchemaBasedConfiguration.class);
        bean.sayHello();
    }
}
