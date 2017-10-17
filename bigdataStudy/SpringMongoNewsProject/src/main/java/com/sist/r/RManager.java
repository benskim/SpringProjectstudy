package com.sist.r;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;
// /home/sist/bigdataDev/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMongoNewsProject/  
@Component
public class RManager {
	public void rGraph(){
		try {
			RConnection rc = new RConnection();
			rc.voidEval("library(KoNLP)");
			rc.voidEval("library(rJava)");
			rc.voidEval("library(RMongo)");
			rc.voidEval("library(stringr)");
			rc.voidEval("library(plotrix)");
			
			rc.voidEval("mongo<-mongoDbConnect(\"mydb\",\"211.238.142.23\",27017)");
			rc.voidEval("data<-dbGetQuery(mongo,\"news\",\"{}\")");
			
			rc.voidEval("data2<-sapply(data$description, extractNoun,USE.NAMES = F)");
			rc.voidEval("news1<-unlist(data2) ");
			rc.voidEval("news2<-str_replace_all(news1,\"[[^가-힣]]\",\"\")");
			rc.voidEval("news3<-Filter(function(x){nchar(x)>=2 && nchar(x)<=5},news2)");
			rc.voidEval("news4<-table(news3)");
			rc.voidEval("news5<-head(sort(news4,decreasing = T),10)");
			
			rc.voidEval("png(\"/home/sist/bigdataDev/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMongoNewsProject/main/news.png\")");
			rc.voidEval("bp<-barplot(news5,col=rainbow(10),las=2)");//ylim =c(0,100),
			rc.voidEval("pct<-round(news5/sum(news5)*100,1)");
			rc.voidEval("th_names=names(news5)");
			rc.voidEval("th_lables=paste(th_names,\"\n\",\"(\",pct,\"%)\")");
			rc.voidEval("pie3D(bp,labels=th_lables,cex=0.1,explode = 0.1)");
			rc.voidEval("dev.off()");
			rc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
