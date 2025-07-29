package spring.transactionproxy;

import java.sql.Connection;

public class TransactionContext {
    Connection connection;
    boolean active;
    boolean readOnly;

    public TransactionContext(Connection connection, boolean readOnly) {
        this.connection = connection;
        this.readOnly = readOnly;
        this.active = true;
    }
}
