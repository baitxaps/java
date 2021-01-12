package cn.huse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class HuseJDBCUtils {
    private static final String driverClassName;
    private static final String url;
    private static final String username;
    private static final String password;

//    static {
//        driverClassName = "com.mysql.jdbc.Driver";
//        url = "jdbc:mysql://localhost:3306/web_data";
//        username = "root";
//        password = "123456";
//    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/cn/huse/db.properties"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverClassName = properties.getProperty("driverClassName");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    public static void loadDriver() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            loadDriver();
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Statement stms, Connection conn) {
        if (stms != null) {
            try {
                stms.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stms = null;
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

    public static void release(ResultSet rs, Statement stms, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }

        if (stms != null) {
            try {
                stms.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stms = null;
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

















