package com.parkhomenko;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Dmytro Parkhomenko
 *         Created on 03.12.16.
 */

public class WebAppConfig implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(ServletWebMvcAppContext.class);

        ServletRegistration.Dynamic registration = container.addServlet("todoservlet", new DispatcherServlet(mvcContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("/todo/*");

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootWebAppContext.class);
        // since we registered RootConfig instead of passing it to the constructor
        rootContext.refresh();
        container.addListener(new ContextLoaderListener(rootContext));
    }
}
