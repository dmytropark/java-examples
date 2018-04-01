package com.parkhomenko.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EmployeeService implements ApplicationContextAware, BeanFactoryAware, InitializingBean, DisposableBean, BeanNameAware, BeanPostProcessor {
    private Employee employee;

    public EmployeeService(){
        System.out.println("1) EmployeeService no-args constructor called");
    }
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        System.out.println("2) setEmployee");
        this.employee = employee;
    }

    public void destroy() throws Exception {
        System.out.println("9) EmployeeService Closing resources");
    }
    
    public void init() {
        System.out.println("7.5) init-method call");
    }
    
    public void customDestroy() {
        System.out.println("10) custom destroy-method call");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("7) EmployeeService initializing to dummy value");
        if(employee.getName() == null){
            employee.setName("Pankaj");
        }
    }

    public void setBeanName(String name) {
        System.out.println("3) com.parkhomenko.lifecycle.EmployeeService bean name is " + name);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4) setBeanFactory: " + beanFactory.toString());
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("5) setApplicationContext: " + applicationContext);
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("6) postProcessBeforeInitialization: " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("8) postProcessAfterInitialization: " + beanName);
        return bean;
    }
}
