package com.sist.graph;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sist.mongo.*;
import java.util.*;

@Controller
public class StudentController {
	@Autowired
	private StudentDAO dao;
	@RequestMapping("main/list.do")
	public String main_list(Model model){
		List<StudentVO> list = dao.stdAllData();
		for(StudentVO v1:list){
			v1.setRank(1);
			for(StudentVO v2:list){
				if(v1.getTotal()<v2.getTotal()){
					v1.setRank(v1.getRank()+1);
					v1.setAvg(Math.round(v1.getAvg()));
				}
			}
		}
		model.addAttribute("list", list);
		return "main/list";
	}
	@RequestMapping("main/insert.do")
	public String main_insert(){
		return "main/insert";
	}
	@RequestMapping("main/insert_ok.do")
	public String main_insert_ok(StudentVO vo){
		dao.stdInsert(vo);
		return "redirect:/main/list.do";
	}
}
