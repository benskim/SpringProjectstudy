package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.web.TwitterController;

//@Component
@Aspect
public class TwitterAspect {
	@Autowired
	private TwitterController tc;
	@Before("execution(* com.sist.web.TwitterController.execute())")
	public void before(){
		tc.hadoopDelete();
		tc.copyFromLocal();
	}
	@After("execution(* com.sist.web.TwitterController.execute())")
	public void after(){
		tc.copyToLocal();
	}
}
