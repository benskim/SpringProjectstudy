package com.sist.mapred;
import java.net.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
@Component //메모리 할당
public class NaverManager {
	public void naverBlogData(String data)
	{
		String clientId = "EggiXJb8aQmT3pU0wXvj";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "3EI2WxGzOI";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(data, "UTF-8");
            //String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
            String apiURL = "https://openapi.naver.com/v1/search/blog.xml?display=100&query="+ text; // xml 결과 // display=100& 100개를 갖고 온다
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            //System.out.println(response.toString());
            FileWriter fw=new FileWriter("/home/sist/pj_bookreply/bookreply.xml");
            fw.write(response.toString());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
	}
	public void naverReplyData()
	{
		try
		{
			JAXBContext jc=JAXBContext.newInstance(Rss.class);
			Unmarshaller un=jc.createUnmarshaller();
			Rss rss=(Rss)un.unmarshal(new File("/home/sist/pj_bookreply/bookreply.xml"));
			List<Item> list=rss.getChannel().getItem();
			String data="";
			for(Item i:list)
			{
				data+=i.getDescription()+"\n";
			}
			FileWriter fw=new FileWriter("/home/sist/pj_bookreply/bookreply.txt");
			fw.write(data);
			fw.close();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
