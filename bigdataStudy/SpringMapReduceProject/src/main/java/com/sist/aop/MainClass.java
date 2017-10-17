package com.sist.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainClass {
	@Autowired
	private MyDataBase db;
	public static void main(String[] args){
		ApplicationContext app = new ClassPathXmlApplicationContext("app1.xml");
		MainClass mc = (MainClass)app.getBean("mainClass");
		mc.db.select();
		mc.db.insert();
		mc.db.update();
		mc.db.delete();
	}
}
