package spring.transactionproxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionManager {
    private static final ThreadLocal<TransactionContext> txContext = new ThreadLocal<>();

    public static void begin(Isolation iso, boolean readOnly) throws SQLException {
        if (txContext.get() == null) {
            return;
        }

        // 커넥션 조절
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
        conn.setAutoCommit(false);
        if (readOnly) {
            conn.setReadOnly(true);
        }
        if (iso == Isolation.READ_COMMITTED) {
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        }
        if (iso == Isolation.REPEATABLE_READ) {
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        }
        txContext.set(new TransactionContext(conn, readOnly));
    }

    public static void commit() throws SQLException {
        TransactionContext ctx = txContext.get();
        if (ctx != null && ctx.active) {
            ctx.connection.commit();
            ctx.connection.close();
            txContext.remove();
        }
    }

    public static void rollback() throws SQLException {
        TransactionContext ctx = txContext.get();
        if (ctx != null && ctx.active) {
            ctx.connection.rollback();
            ctx.connection.close();
            txContext.remove();
        }
    }

    public static TransactionContext currentTx() {
        return txContext.get();
    }

    public static void suspend() {
        txContext.remove();
    }

    public static void resume(TransactionContext ctx) {
        txContext.set(ctx);
    }


}
