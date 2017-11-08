package com.sist.hive;
import java.sql.*;
public class HiveMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try
        {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            String url="jdbc:hive2://localhost:10000/default";
            Connection conn=DriverManager.getConnection(url,"hive","hive");
            String sql="SELECT ename,job,hiredate,dname,loc FROM emp,dept2 "
            		     +"WHERE emp.deptno=dept2.deptno";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
            	System.out.println(rs.getString(1)+" "
            			+rs.getString(2)+" "
            			+rs.getString(3)+" "
            			+rs.getString(4)+" "
            			+rs.getString(5));
            }
       }catch(Exception ex)
        {
          System.out.println(ex.getMessage());	
        }
	}

}
