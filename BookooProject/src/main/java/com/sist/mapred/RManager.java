package com.sist.mapred;


import java.util.ArrayList;
import java.util.List;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;

@Component
public class RManager {
    public void wordCloud(){
    	  try{
            RConnection rc=new RConnection();
            rc.voidEval("library(KoNLP)");
            rc.voidEval("library(wordcloud)");
            rc.voidEval("library(stringr)");
            rc.voidEval("reply<-readLines(\"/home/sist/pj_bookreply/bookreply.txt\")");
            rc.voidEval("png(\"/home/sist/bigdataDev/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SecondBookooProject1/main/wordcloud.png\")");
            rc.voidEval("data<-sapply(reply,extractNoun,USE.NAMES = F)");
            rc.voidEval("data2<-unlist(data)");
            rc.voidEval("data3<-str_replace_all(data2,\"[^[가-힣]]\",\"\")");
            rc.voidEval("data4<-Filter(function(x){nchar(x)>=2},data3)");
            rc.voidEval("data5<-table(data4)");
            rc.voidEval("data6<-head(sort(data5,decreasing = T),100)");
            rc.voidEval("wordcloud(names(data6),freq = data6, min.freq = 3,rot.per = 0.25,scale = c(5,0.5),random.order = F,random.color = F,colors = rainbow(15))");
            rc.voidEval("dev.off()"); // 그림끝내고 저장
            rc.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public List<RDataVO> feelGraph(){
    	List<RDataVO> list=
 			   new ArrayList<RDataVO>();
        	try{
            RConnection rc=new RConnection();
            rc.voidEval("feel<-read.table(\"/home/sist/pj_bookreply/bresult\")");
            REXP p=rc.eval("feel$V1");
            String[] fname=p.asStrings();
            p=rc.eval("feel$V2");
            int[] fvalue=p.asIntegers();
            rc.close();
            if(fname.length!=0){
	            for(int i=0;i<fname.length;i++)
		 		   {
		 			   RDataVO vo=new RDataVO();
		 			   vo.setKey(fname[i]);
		 			   vo.setValue(fvalue[i]);
		 			   list.add(vo);
		 		   }
            }else{
            	for(int i=0;i<2;i++)
		 		   {
		 			   RDataVO vo=new RDataVO();
		 			   vo.setKey("No Data");
		 			   vo.setValue(0);
		 			   list.add(vo);
		 		   }
            	}
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
        }
        return list;
    }
}