package com.sist.r;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;

@Component
public class RManager {
	public void twitterView(){
		try {
			RConnection rc = new RConnection();
			rc.voidEval("data<-read.table(\"/home/sist/csv_data/twitter_result.txt\")");
			rc.voidEval("png(\"/home/sist/bigdataDev/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringRandJavaProject/main/twitter.png\")");
			rc.voidEval("barplot(data$V2, names.arg = data$V1,col=rainbow(4))");
			rc.voidEval("dev.off()");
			rc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
