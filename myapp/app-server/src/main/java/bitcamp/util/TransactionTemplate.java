package bitcamp.util;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransactionTemplate {
    TransactionTemplate txManager;

    public TransactionTemplate(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public Object execute(TransactionCallback cb) throws Exception {

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("tx1");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);

        try {
            Object rv = cb.doInTransaction(status);
            txManager.commit(status);
            return rv;
        } catch (Exception e) {

            txManager.rollback(status);
            throw e;
        }
    }

    }
 }
