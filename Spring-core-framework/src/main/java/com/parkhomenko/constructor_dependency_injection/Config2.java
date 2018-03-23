package com.parkhomenko.constructor_dependency_injection;

import com.parkhomenko.constructor_dependency_injection.sub_package.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dmytro Parkhomenko
 *         Created on 31.07.17.
 */

@Configuration
public class Config2 {

    @Bean
    public Car car() {
        return new Car(newEngineName(), transmission());
    }

    @Bean()
    public Engine newEngineName() {
        return new Engine("v9", 5);
    }

    @Bean
    public Transmission transmission() {
        return new Transmission("sliding");
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);
        Car car = context.getBean(Car.class);
        System.out.println("car = " + car);
    }

}
