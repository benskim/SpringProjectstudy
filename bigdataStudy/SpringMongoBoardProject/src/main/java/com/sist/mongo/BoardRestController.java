package com.sist.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;
// javascript => @ResponseBody
@RestController
public class BoardRestController {
   @Autowired
   private BoardDAO dao;
   @RequestMapping("board/update_ok.do")
   public String board_update_ok(BoardVO vo)
   {
	   String js="";
	   boolean bCheck=dao.boardUpdateOk(vo);
	   if(bCheck==false)
	   {
		   js="<script>alert(\"비밀번호가 틀립니다\");history.back();</script>";
	   }
	   else
	   {
		   js="<script>location.href=\"content.do?no="+vo.getNo()+"\";</script>";
	   }
	   return js;
   }
}








