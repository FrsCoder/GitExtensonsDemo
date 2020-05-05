package com.frs.stu;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.frs.c3p0.C3P0Util;

public class TestDBUtil {
	@Test
	public void query1() throws SQLException{
		QueryRunner qr=new QueryRunner(C3P0Util.getdatasource());
		String sql="insert into stu(id,name,password,address) values(null,?,?,?)";
		qr.insert(sql, new ScalarHandler<>(),new Object[]{"大米","555444","银河"});
		System.out.println("成功");
	}
	@Test
	public void query2() throws SQLException{
		QueryRunner qr=new QueryRunner(C3P0Util.getdatasource());
		String sql="select * from stu";
		List<Map<String,Object>> map=qr.query(sql, new MapListHandler());
		for(Map<String,Object> maps:map){
			for(Map.Entry<String, Object> entry:maps.entrySet()){
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
			System.out.println("--------------------------");
		}
	}
	@Test
	public void query() throws SQLException{
		QueryRunner qr=new QueryRunner(C3P0Util.getdatasource());
		String sql="select * from stu";
		List<Student> student=qr.query(sql, new BeanListHandler<Student>(Student.class));
		for(Student stu:student){
			System.out.println(stu.toString());
		}
	}
	
}
