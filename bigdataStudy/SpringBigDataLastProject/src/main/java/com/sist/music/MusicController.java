package com.sist.music;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.MusicDAO;
import com.sist.mgr.MusicVO;

@Controller
public class MusicController {
	@Autowired
	private MusicDAO dao;
	@RequestMapping("music/main.do")
	public String music_main(String page,Model model){
		if(page==null){
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<MusicVO> list=dao.musicTop50(curpage);
		int totalpage=dao.musicTotalPage();
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "music/main";
	}
	@RequestMapping("music/graph.do")
	public String music_graph(){
		return "music/graph";
	}
}
