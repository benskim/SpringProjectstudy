package com.sist.aop2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect //메모리할당안됨. 공통부분표시
@Component
public class MyCommon {
	@Autowired
	private MyDataBase db;
	@Before("execution(* com.sist.aop2.MyDataBase.aop*())")//returnType, paramType
	public void before(){
		db.getConnection();
	}
	@After("execution(* com.sist.aop2.MyDataBase.aop*())")
	public void after(){
		db.disConnection();
	}
}
