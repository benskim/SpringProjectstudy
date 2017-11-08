package com.sist.manager;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.rankdao.RankDAO;

@Component
public class BookRankManager implements Serializable{
	@Autowired
	private RankDAO rdao;
	public static void main(String[] args) {
		String[] xml={"application-context.xml","application-mongo.xml"};
		ApplicationContext app=new ClassPathXmlApplicationContext(xml);
		BookRankManager brm=(BookRankManager)app.getBean("bookRankManager");
		
	}
}
