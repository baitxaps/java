package cn.test;

import java.sql.*;

public class jdbcTest {
    //170
    public static void test() {
        // connect();
        // savaRecord();
        query();
    }

    private static void query() {
        Connection conn = null;
        Statement stms = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_data",
                    "root", "123456");
            stms = conn.createStatement();

            String sql = "select * from user";

            rs = stms.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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


    private static void savaRecord() {
        Connection conn = null;
        Statement stms = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_data",
                    "root", "123456");
            stms = conn.createStatement();

            String sql = "insert into user values(null,'awang','eeee','1990-1-1',21)";
            sql = "update user set password='abc',username='william' where id = 2";
            sql = "delete from user where id=3";
            int num = stms.executeUpdate(sql);
            if (num > 0) {
                System.out.printf("crud table success!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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


    private static void connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_data", "root", "123456");

        Statement statement = conn.createStatement();

        String sql = "select * from user";
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            System.out.print(rs.getInt("id") + " ");
            System.out.print(rs.getString("username") + " ");
            System.out.print(rs.getString("password") + " ");
            System.out.print(rs.getString("nickname") + " ");
            System.out.print(rs.getInt("age") + " ");
            System.out.println();
        }

        rs.close();
        statement.close();
        conn.close();
    }
}










