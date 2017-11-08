package com.sist.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

import com.sist.dao.*;
@Controller
public class MultiDataBoardController {
   @Autowired
   private DataBoardService service;
   @RequestMapping("board/list.do")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<BoardVO> list=service.databoardAllData(curpage);
	   model.addAttribute("list", list);
	   return "board/list"; // */* => {1}/{2}.jsp
   }
   @RequestMapping("board/insert.do")
   public String board_insert()
   {
	   return "board/insert";
   }
   @RequestMapping("board/insert_ok.do")
   public String board_insert_ok(DataBoardVO uploadForm)
   throws Exception
   {
	   List<MultipartFile> list=uploadForm.getFiles();
	   String temp1="";
	   String temp2="";
	   if(list.size()>0)
	   {
	    for(MultipartFile mf:list)
	     {
		   String strName=mf.getOriginalFilename();
		   File f=new File("/home/sist/download/"+strName);
		   mf.transferTo(f);
		   temp1+=f.getName()+",";
		   temp2+=f.length()+",";
	     }
	    // a.jpg,b.jpg
	    temp1=temp1.substring(0,temp1.lastIndexOf(","));
	    temp2=temp2.substring(0,temp2.lastIndexOf(","));
	    uploadForm.setFilename(temp1);
	    uploadForm.setFilesize(temp2);
	    uploadForm.setFilecount(list.size());
	   }
	   else
	   {
		    uploadForm.setFilename("");
		    uploadForm.setFilesize("");
		    uploadForm.setFilecount(0);
	   }
	   BoardVO vo=new BoardVO();
	   vo.setName(uploadForm.getName());
	   vo.setSubject(uploadForm.getSubject());
	   vo.setContent(uploadForm.getContent());
	   vo.setPwd(uploadForm.getPwd());
	   vo.setFilename(uploadForm.getFilename());
	   vo.setFilesize(uploadForm.getFilesize());
	   vo.setFilecount(uploadForm.getFilecount());
	   vo.setRegdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	   service.databoardInsert(vo);
	   return "redirect:/board/list.do";
   }
   @RequestMapping("board/content.do")
   public String board_content(int no,Model model)
   {
	   
	   return "board/content";
   }
}







