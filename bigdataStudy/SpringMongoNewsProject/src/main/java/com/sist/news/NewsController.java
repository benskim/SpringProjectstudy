package com.sist.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.manager.NewsManager;
import com.sist.mongo.*;
import com.sist.r.RManager;

import java.util.*;
@Controller
public class NewsController {
   @Autowired
	private NewsDAO dao;
   @Autowired
   private NewsManager mgr;
    @Autowired
    private RManager rm;
   @RequestMapping("main/list.do")
   public String main_list(String page,String data,Model model)
   {
	   if(data==null)
		   data="야구";
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   dao.newsDrop();
	   mgr.newsData(data);
	   List<NewsVO> list=dao.newsAllData(curpage);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("list", list);
	   model.addAttribute("totalpage", 5);
	   model.addAttribute("data", data);
	    rm.rGraph();
	   return "main/list";
   }
}













