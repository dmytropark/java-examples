package com.parkhomenko.declarative_transaction;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.09.16.
 */

public class DefaultFooService3 implements FooService {

    private final PlatformTransactionManager txManager;

    public DefaultFooService3(PlatformTransactionManager txManager) {
        this.txManager = txManager;
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
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // explicitly setting the transaction name is something that can only be done programmatically
        def.setName("SomeTxName");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);
        try {

            // execute your business logic here
            System.out.println(" some update operation here !!!");

            if(true) {
                throw new Exception("Rollback test exception");
            }
        }
        catch (Exception ex) {
            txManager.rollback(status);
            throw new RuntimeException(ex.getMessage());
        }
        txManager.commit(status);
    }
}
