package com.sist.r;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RManager {
	//
	public String graph(int no){//highchart : json form
		String json="";
		switch(no){
			case 0:
			case 1:
				json = createJson(empSalPieGraph());
				break;
		}
		return json;
		
	}
	//no당 그래프 하나씩
	public List<RdataVO> empSalPieGraph(){
		List<RdataVO> list = new ArrayList<RdataVO>();
		try {
			RConnection rc = new RConnection();
			rc.voidEval("emp<-read.csv(\"/home/sist/csv_data/emp.csv\",header=T,sep=\",\")");
			//rEngine - eval - data parsing : from R to java
			REXP p = rc.eval("emp$ename");
			String[] ename = p.asStrings();
			p=rc.eval("emp$sal");
			int[] sal = p.asIntegers();
			rc.close();
			for(int i=0;i<ename.length;i++){
				RdataVO vo  = new RdataVO();
				vo.setKey(ename[i]);
				vo.setValue(sal[i]);
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	//
	public String createJson(List<RdataVO> list){
		/*
		 *  name: 'Chrome',
            y: 24.03,
            sliced: true,
            selected: true
        }, {
            name: 'Firefox',
            y: 10.38
        }, {
            name: 'Safari',
            y: 4.77
        }, {
            name: 'Opera',
            y: 0.91
        }, {
            name: 'Proprietary or Undetectable',
            y: 0.2
		 */
		String json = "";
		try {
			//simple
			JSONArray arr = new JSONArray();
			for(RdataVO vo : list ){
				JSONObject obj = new JSONObject();
				obj.put("name", vo.getKey());
				obj.put("y", vo.getValue());
				arr.add(obj);				
				
			}
			json = arr.toJSONString();
			System.out.println(json);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return json;
	}
	public static void main(String[] args){		
		RManager r = new RManager();
		r.createJson(r.empSalPieGraph());
	}
}
