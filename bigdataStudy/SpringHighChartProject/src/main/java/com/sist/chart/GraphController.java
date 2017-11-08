package com.sist.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.r.RManager;

@Controller
public class GraphController {
	@Autowired
	private RManager rm;
	@RequestMapping("main/main.do")
	public String main_main(){
		return "main/main";
	}
	@RequestMapping("main/graph.do")
	public String main_graph(String no, Model model) {
		if (no == null) {
			no = "0";
		}
		int index = Integer.parseInt(no);
		String json = rm.graph(index);
		model.addAttribute("json", json);
		String url="";
		if(index==0){
			url="main/graph";	
		} else if(index==1){
			url="main/graph2";
		}
		
		return url;
	}

}
