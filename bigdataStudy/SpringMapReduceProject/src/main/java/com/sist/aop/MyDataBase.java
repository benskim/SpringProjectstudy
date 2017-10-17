package com.sist.aop;

import org.springframework.stereotype.Repository;

@Repository
public class MyDataBase {
	//공통관심사 aop
	public void getConnection(){
		System.out.println("getConnection");
	}
	public void disConnection(){
		System.out.println("disConnection");
	}
	//
	public void select(){
		getConnection();
		System.out.println("select call..");
		disConnection();
	}
	public void insert(){
		getConnection();
		System.out.println("insert call..");
		disConnection();
	}
	public void delete(){
		getConnection();
		System.out.println("delete call..");
		disConnection();
	}
	public void update(){
		getConnection();
		System.out.println("update call..");
		disConnection();
	}
	
	
}
