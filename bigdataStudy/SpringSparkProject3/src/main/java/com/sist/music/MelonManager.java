package com.sist.music;
import java.io.FileWriter;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class MelonManager {
   public static void main(String[] arg)
   {
	   MelonManager m=new MelonManager();
	   m.melonManager();
   }
   public List<MusicVO> melonManager()
   {
	   int j=1;
	   List<MusicVO> list=new ArrayList<MusicVO>();
	   try
	   {
		   String[] url={"http://www.melon.com/chart/index.htm","http://www.melon.com/chart/index.htm#params%5Bidx%5D=51"};
		   for(int i=0;i<1;i++)
		   {
			   Document doc=Jsoup.connect(url[i]).get();
			   String str="tr.lst50";
			   if(i==0)
				   str="tr.lst50";
			   else
				   str="tr.lst100";
			   Elements rank=doc.select(str+" div.t_center span.rank ");
			   Elements title=doc.select(str+" div.wrap_song_info span a");
			   Elements singer=doc.select(str+" div.wrap_song_info a");
			   int a=0;
			   int b=1;
			   String data = "";
			   
			   
			   for(int k=0;k<rank.size();k++)
			   {
				   Element r=rank.get(k);
				   Element t=title.get(a);
				   Element s=title.get(b);
				   /*System.out.println(r.text()+" "
						   +t.text()+" "
						   +s.text());*/
				   System.out.println(r.text()+", "+t.text()+", "
						   +s.text());
				   data += r.text()+","+t.text().replace(",", ".")+","+s.text()+"\n";
				   a+=2;
				   b+=2;
			   }
			   data=data.substring(0,data.lastIndexOf("\n"));
			   FileWriter fw = new FileWriter("/home/sist/music_data/melon.csv");
			   fw.write(data);
			   fw.close();
		   }
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return list;
   }
}
