package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
  @RequestMapping("main.do")
  public String main_main()
  {
	  return "main";
  }
  @RequestMapping("board.do")
  public String main_board()
  {
	  return "board/board";
  }
  @RequestMapping("notice.do")
  public String main_notice()
  {
	  return "notice/notice";
  }
}
