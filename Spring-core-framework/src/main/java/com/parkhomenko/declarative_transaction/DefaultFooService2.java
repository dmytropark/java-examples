package com.parkhomenko.declarative_transaction;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.09.16.
 */

public class DefaultFooService2 implements FooService {

    // single TransactionTemplate shared amongst all methods in this instance
    private final TransactionTemplate transactionTemplate;

    // use constructor-injection to supply the PlatformTransactionManager
    public DefaultFooService2(PlatformTransactionManager transactionManager) {
        Assert.notNull(transactionManager, "The 'transactionManager' argument must not be null.");
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    public Foo getFoo(String fooName) {
        return null;
    }

    public Foo getFoo(String fooName, String barName) {
        return null;
    }

    public void insertFoo(Foo foo) {

    }

    public void updateFoo(Foo foo) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {

                    // execute your business logic here
                    System.out.println(" some update operation here !!!");

                }  catch (Exception ex) {
                    status.setRollbackOnly();
                }
            }
        });
    }
}
