package cn.jdbc;

import java.sql.Connection;
import java.util.List;

public class HuseConnectWrapper extends ConnectionWrapper {
    private Connection conn;
    private List<Connection> connList;

    public HuseConnectWrapper(Connection conn, List<Connection> connList) {
        super(conn);
        this.conn = conn;
        this.connList = connList;
    }

//    @Override
//    public void close() throws SQLException {
//       // super.close();
//        connList.add(conn);
//    }
}
