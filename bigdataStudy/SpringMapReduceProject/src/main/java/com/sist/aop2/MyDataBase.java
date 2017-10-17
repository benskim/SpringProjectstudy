package com.sist.aop2;

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
	//pattern으로 적용대상 구별
	public void aopSelect(){
	
		System.out.println("select call..");
	
	}
	public void aopInsert(){
	
		System.out.println("insert call..");
	
	}
	public void aopDelete(){
		
		System.out.println("delete call..");
		
	}
	public void aopUpdate(){
	
		System.out.println("update call..");
		
	}
	
	
}
