package spring;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransactionEx {
    private DataSource dataSource;

    public JdbcTransactionEx(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void transferMoney(
            long fromAccountId,
            long toAccountId,
            int amount
    ) throws SQLException {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            // 입금 처리
            try (PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance = balance - ? where id = ?")) {
                ps.setInt(1, amount);
                ps.setLong(2, fromAccountId);
                ps.executeUpdate();
            }
            // 출금 처리
            try (PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance = balance + ? where id = ?")) {
                ps.setInt(1, amount);
                ps.setLong(2, fromAccountId);
                ps.executeUpdate();
            }
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

}
