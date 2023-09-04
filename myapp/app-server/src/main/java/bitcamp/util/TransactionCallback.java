package bitcamp.util;

import org.springframework.transaction.TransactionStatus;

//트랜잭션으로 처리할 작업을 갖고있는 객체 사용법
public interface TransactionCallback {
    Object doInTransaction(TransactionStatus status);
}
