package com.parkhomenko.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

/**
 * @author Dmytro Parkhomenko
 *         Created on 09.09.16.
 */

@RunWith(MockitoJUnitRunner.class)
public class AnimalTester {

    private Animal animal;

    @Before
    public void setUp() {
        animal = mock(Animal.class);
    }

    @Test
    public void test_mock_call() {
        animal.eat();

        Assert.assertEquals(24, animal.getAge());
    }

}
