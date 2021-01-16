package cn.jdbc;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.*;

public class HuseJDBCUtils {
    // A static connectionPool ,to run only 1 exec
    private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // Get connectionPool method
    public static Connection getConnection()throws SQLException {
        return dataSource.getConnection();
    }

    // Get the connectionPool
    public static DataSource getDataSource(){
        return dataSource;
    }

    public static void release(Statement stmst, Connection conn) {
        if (stmst != null) {
            try {
                stmst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmst = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}

















