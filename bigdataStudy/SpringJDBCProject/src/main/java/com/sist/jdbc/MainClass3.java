package com.sist.jdbc;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

public class MainClass3 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@211.238.142.38:1521:ORCL";
			Connection conn = DriverManager.getConnection(url,"scott","tiger");
			String sql = "SELECT empno,ename,job,hiredate,sal,deptno FROM emp";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			CSVWriter cw = new CSVWriter(new FileWriter("/home/sist/csv_data/emp.csv"));
			List<String[]> list = new ArrayList<String[]>();
			while(rs.next()){
//				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "
//						+rs.getString(3));
				String[] ss = {
						String.valueOf(rs.getInt(1)),
						rs.getString(2),
						rs.getString(3),
						rs.getDate(4).toString(),
						String.valueOf(rs.getInt(5)),
						String.valueOf(rs.getInt(6))
				};
				list.add(ss);
			}
			cw.writeAll(list);
			cw.close();
			rs.close();
			ps.close();
			conn.close();
			//C11
			//OJDBC14.JAR있으면 오라클 사용가능하다
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

}
