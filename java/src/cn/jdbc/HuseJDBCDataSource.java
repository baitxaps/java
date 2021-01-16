package cn.jdbc;
import cn.jdbc_bak.HuseJDBCUtils_Bak;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class HuseJDBCDataSource implements DataSource {
    private List<Connection> connList = new ArrayList<Connection>();
    public HuseJDBCDataSource() {
        for (int i=1;i<=3;i++){
            connList.add(HuseJDBCUtils_Bak.getConnection());
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = connList.remove(0);
        HuseConnectWrapper connWrapper = new HuseConnectWrapper(conn,connList);

        return  connWrapper;
    }

    public void addBack(Connection conn){
        connList.add(conn);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Connection getConnection(String username, String password)
            throws SQLException {
        return null;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void setLogWriter(PrintWriter arg0) throws SQLException {
        // TODO Auto-generated method stub
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setLoginTimeout(int arg0) throws SQLException {
        // TODO Auto-generated method stub

    }
}
