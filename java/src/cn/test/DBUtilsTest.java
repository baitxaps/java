package cn.test;

import cn.jdbc.HuseJDBCUtils;
import entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DBUtilsTest {
    //DBUtils test
    @Test
    public void DBUtilInsertTest() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        queryRunner.update("insert into account values(null,?,?)", "ddd", 10000);
    }

    @Test
    public void DBUtilUpdateTest() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        queryRunner.update("delete from  account  where id=?", 3);
    }

    @Test
    public void DBUtilDeleteTest() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        queryRunner.update("update  account set name=?,money=? where id=?", "a", 10000, 1);
    }

    @Test
    public void DBUtilQuerySTest() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        Account account = queryRunner.query("select * from account where id = ?",
                new ResultSetHandler<Account>() {
                    @Override
                    public Account handle(ResultSet resultSet) throws SQLException {
                        Account account = new Account();
                        while (resultSet.next()) {
                            account.setId(resultSet.getInt("id"));
                            account.setName(resultSet.getString("name"));
                            account.setMoney(resultSet.getDouble("money"));
                        }
                        return account;
                    }
                }, 1);
        System.out.println(account);
    }


    @Test
    public void DBUtilQueryMTest() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        List<Account> list = queryRunner.query("select * from account", new ResultSetHandler<List<Account>>() {

            @Override
            public List<Account> handle(ResultSet rs) throws SQLException {
                List<Account> entities = new ArrayList<Account>();
                while (rs.next()) {
                    Account account = new Account();
                    account.setId(rs.getInt("id"));
                    account.setName(rs.getString("name"));
                    account.setMoney(rs.getDouble("money"));
                    entities.add(account);
                }
                return entities;
            }
        });
        for (Account entity : list) {
            System.out.println(entity);
        }
    }

    @Test
    public void DBUtilQueryToObjectArrayTest() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        Object[] objs = queryRunner.query("select * from account where id=?", new ArrayHandler(), 1);
        System.out.println(Arrays.toString(objs));
    }

    @Test
    public void DBUtilQueryToArrayListTest() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        List<Object[]> list = queryRunner.query("select * from account", new ArrayListHandler());
        for (Object[] objs : list) {
            System.out.println(Arrays.toString(objs));
        }
    }

    //!!!!
    @Test
    public void DBUtilQueryToBeanTest() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        Account account = queryRunner.query("select * from account where id =?", new BeanHandler<Account>(Account.class), 1);
        System.out.println(account);
    }

    //!!!
    @Test
    public void DBUtilQueryToBeanListTest() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        List<Account> list = queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        for (Account objs : list) {
            System.out.println(objs);
        }
    }

    @Test
    public void DBUtilQueryToMap() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        Map<String, Object> map = queryRunner.query("select * from account where id =?", new MapHandler(), 1);
        System.out.println(map);
    }

    @Test
    public void DBUtilQueryToMapList() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        List<Map<String, Object>> list = queryRunner.query("select * from account", new MapListHandler());
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }


    @Test
    public void DBUtilQueryToColumn() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        List<Object> list = queryRunner.query("select name,money from account",
                new ColumnListHandler("name"));
        for (Object objs : list) {
            System.out.println(objs);
        }
    }

    // single obj
    @Test
    public void DBUtilQueryToScalar() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        Object obj = queryRunner.query("select count(*) from account",
                new ScalarHandler());
        System.out.println(obj);
    }

    // single obj
    /**
     * KeyedHandler :将一条记录装到一个Map集合中，将多条记录封装到一个装有Map集合中，而且外面的Map的Key是可以指定的。
     */
    @Test
    public void DBUtilQueryToKeyed() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
        Map<Object,Map<String,Object>> map = queryRunner.query("select * from account",
                new KeyedHandler("name"));
        for (Object key : map.keySet()) {
            System.out.println(key+" " +map.get(key));
        }
    }

}