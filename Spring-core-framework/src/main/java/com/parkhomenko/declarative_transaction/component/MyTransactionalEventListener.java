package com.parkhomenko.declarative_transaction.component;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.09.16.
 */

@Component
public class MyTransactionalEventListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleOrderCreatedEvent() { //TODO add event here with Event publisher from transaction !!!
        System.out.println("Transactional Event listener works !!!");
    }
}
