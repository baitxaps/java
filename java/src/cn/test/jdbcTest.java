package cn.test;

import cn.huse.HuseJDBCUtils;

import java.sql.*;

public class jdbcTest {
    //170
    public static void test() {
        //jdbcCurd();
        // DBUtilsTest();
        // connect();
        // savaRecord();
        //query();
        //jdbcBatch2();
        //jdbcBatch();
        jdbcTransaction();//185
    }

    private static void jdbcTransaction() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = HuseJDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            String sql = "update account set money=money+? where name=?";
            pstmt = conn.prepareStatement(sql);

            // 扣a 1000元 给b
            pstmt.setDouble(1,-1000);
            pstmt.setString(2,"a");
            pstmt.executeUpdate();
            //
            pstmt.setDouble(1,1000);
            pstmt.setString(2,"b");
            pstmt.executeUpdate();
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚
            try {
                conn.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            HuseJDBCUtils.release(pstmt, conn);
        }
    }

    private static void jdbcBatch2() {
        long begin = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = HuseJDBCUtils.getConnection();
            String sql = "insert into user values(null,?)";
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < 10000; i++) {
                pstmt.setString(1, "name" + i);
                pstmt.addBatch();

                if (i % 1000 == 0) {//ban memory overflow;
                    pstmt.executeBatch();
                    pstmt.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("duration:" + (end - begin) / 1000);

        } catch (Exception e) {
            HuseJDBCUtils.release(pstmt, conn);
        }
    }

    private static void jdbcBatch() {
        Connection conn = null;
        Statement pstmt = null;
        try {
            conn = HuseJDBCUtils.getConnection();
            pstmt = conn.createStatement();
            String sql0 = "create database batch";
            String sql1 = "use batch";
            String sql2 = "create table user(id int primary key auto_increment,name varchar(20))";
            String sql3 = "insert into user values(null,'a')";
            String sql4 = "insert into user values(null,'b')";
            String sql5 = "insert into user values(null,'c')";
            String sql6 = "insert into user values(null,'d')";
            String sql7 = "update user set name = 'f' where id =2";
            String sql8 = "delete from user where id = 1";
            pstmt.addBatch(sql0);
            pstmt.addBatch(sql1);
            pstmt.addBatch(sql2);
            pstmt.addBatch(sql3);
            pstmt.addBatch(sql4);
            pstmt.addBatch(sql5);
            pstmt.addBatch(sql6);
            pstmt.addBatch(sql7);
            pstmt.addBatch(sql8);

            pstmt.executeBatch();

        } catch (Exception e) {
            HuseJDBCUtils.release(pstmt, conn);
        }
    }

    private static void jdbcCurd() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = HuseJDBCUtils.getConnection();
            //  String sql = "insert into user values(null,?,?,?,?)";
            String sql = "update user set username =?,password=?,birthday=?,age=? where id = ?";
            // String sql = "delete from user where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "rhc");
            pstmt.setString(2, "123456");
            pstmt.setString(3, "1986.10.13");
            pstmt.setInt(4, 34);
            pstmt.setInt(5, 3); //update
//          pstmt.setInt(1,5); // delete

            int num = pstmt.executeUpdate();
            if (num > 0) {
                System.out.println("save success!!");
            }

            sql = "select * from user";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

        } catch (Exception e) {
            HuseJDBCUtils.release(rs, pstmt, conn);
        }
    }

    private static boolean login(String username, String password) {
        // username = "aaaa' or '1=1"  password = "aaaaa";
        // username = "aaaa' -- "
        // Boolean l = login(username,password)

        String sql = "select * from user where username = '" + username + "' and password= '" + password + "'";

        // sql = "select * from user where username = 'aaaa or '1=1 ' and password= 'aaaaa'";
        // sql = "select * from user where username = 'aaaa'-- ' and password= 'aaaaa'";
        boolean islogin = false;

        // 防止sql注入：
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = HuseJDBCUtils.getConnection();
            sql = "select * from user where username= ? and password = ?";
            pstmt = conn.prepareStatement(sql);

            // set paramters
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                islogin = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HuseJDBCUtils.release(rs, pstmt, conn);
        }
        return islogin;
    }

    private static void DBUtilsTest() {
        Connection conn = null;
        Statement stms = null;
        ResultSet rs = null;
        try {
            conn = HuseJDBCUtils.getConnection();
            stms = conn.createStatement();
            String sql = "select * from user";
            rs = stms.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HuseJDBCUtils.release(rs, stms, conn);
        }
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










