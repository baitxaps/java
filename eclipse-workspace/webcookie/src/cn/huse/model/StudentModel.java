package cn.huse.model;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.huse.utils.HuseJDBCUtils;

public class StudentModel {
	@Test
	public void test() {
		try {
			StudentModel stuModel = new StudentModel();
			List<Student> list = stuModel.findAll();
			for (Student s : list) {
				System.out.print(s.getSname());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Student> findAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(HuseJDBCUtils.getDataSource());
		List<Student> list = queryRunner.query("select * from student", new BeanListHandler<Student>(Student.class));
		return list;
	}
}
