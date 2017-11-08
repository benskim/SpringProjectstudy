package com.sist.blog;

import java.net.*;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.sist.r.RManager;

import java.io.*;

@Component
public class NaverBlogManager {
	
	public static void main(String[] args){
//		RManager rm = new RManager();
		NaverBlogManager nbm = new NaverBlogManager();
		String data = "연애 책";
		nbm.naverBlogData(data);
		nbm.naverDesciptionData();
		System.out.println("data..save");
//		rm.wordCloud();
		/*
library(KoNLP)
library(stringr)
data1 <- readLines("/home/sist/book_data/rest.txt")
data2 <- sapply(data1,extractNoun,USE.NAMES = F)
news1<-unlist(data2) #2dim -> 1dim
news<-str_replace_all(news1,"[[^가-힣]]","")
news3<-Filter(function(x){nchar(x)>=2},news) #length limit
news4<-table(news3)
news5<-head(sort(news4,decreasing = T),500)
news5
#연애컨설팅, 여자,남자, 결혼,매력, 당신, 상담, 솔로, 연인,장거리연애,관계,공감,모태
#연애스킬,연애혁명,낭만,남녀,관심,이성,연애세포,연애시집

str_extract_all(news,"연애[가-힣]",) #replace_all(news1,"[연애[가-힣]]","연애")
news3<-Filter(function(x){nchar(x)>=2},news) #length limit
news4<-table(news3)
news5<-head(sort(news4,decreasing = T),150)
news5
		 */
	}
	
	
	
	public void naverBlogData(String data) {
		String clientId = "ozfy8CF6GuuzaooS9bjM";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "WHAz50MSVA";// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode(data, "UTF-8");
			//String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text; // json결	과																		
			String apiURL = "https://openapi.naver.com/v1/search/blog.xml?display=100&query="+ text; //xml 결과
			//display=100 -> item 100
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			//System.out.println(response.toString());
			FileWriter fw = new FileWriter("/home/sist/book_data/rest.xml");
			fw.write(response.toString());
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void naverDesciptionData(){
		try {
			JAXBContext jc = JAXBContext.newInstance(Rss.class);
			Unmarshaller un = jc.createUnmarshaller();
			//String을 매개변수로 받을 수 없으므로 xml로 받고 변환작업거쳐야 
			Rss rss = (Rss)un.unmarshal(new File("/home/sist/book_data/rest.xml"));
			List<Item> list = rss.getChannel().getItem();
			String data="";
			for(Item i:list){
				data+=i.getDescription()+"\n";
			}
			FileWriter fw = new FileWriter("/home/sist/book_data/rest.txt");
			fw.write(data);
			fw.close();
					
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
