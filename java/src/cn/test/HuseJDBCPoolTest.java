package cn.test;
import cn.jdbc.HuseJDBCDataSource;
import cn.jdbc.HuseJDBCUtils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class HuseJDBCPoolTest {

    //Druid file properties to set
    @Test
    public void druidTest_property() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DataSource dataSource = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/cn/jdbc/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            conn = dataSource.getConnection();
            String sql = "select * from account";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            HuseJDBCUtils.release(rs, pstmt, conn);
        }
    }


    //Druid Paramters to set
    @Test
    public void druidTest_param() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DruidDataSource dataSource = null;
        try {
            conn = HuseJDBCUtils.getConnection();
            dataSource = new DruidDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql:///web_events");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");

            String sql = "select * from account";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            HuseJDBCUtils.release(rs, pstmt, conn);
        }
    }

    // Custom jdbc Tool to set
    @Test
    public void test() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        HuseJDBCDataSource dataSource = null;
        try {
            // conn = HuseJDBCUtils.getConnection();
            dataSource = new HuseJDBCDataSource();
            conn = dataSource.getConnection();

            String sql = "select * from account";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            HuseJDBCUtils.release(rs,pstmt,conn);
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            dataSource.addBack(conn);
        }
    }
}
