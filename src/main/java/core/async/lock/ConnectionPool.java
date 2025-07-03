package core.async.lock;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final List<Connection> pool = new ArrayList<>();

    public synchronized Connection getConnection() {
        while (pool.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return pool.remove(0);
    }
    public synchronized void releaseConnection(Connection connection) {
        pool.add(connection);
        notify();
    }

}
