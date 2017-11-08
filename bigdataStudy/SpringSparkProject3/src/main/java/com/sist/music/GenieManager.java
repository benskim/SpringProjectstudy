package com.sist.music;
import java.io.FileWriter;
import java.net.URLEncoder;
// MapReduce , Spark (part-00000) => hive 
// flume : 데이터 수집 => SparkSQL innerJoin
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import com.sist.dao.MusicDAO;
public class GenieManager {
	@Autowired
	private MusicDAO dao;
	public static void main(String[] arg)
   {
	   GenieManager g=new GenieManager();
	   g.genieTop100();
   }
   public List<MusicVO> genieTop100()
   {
	   List<MusicVO> list=
			   new ArrayList<MusicVO>();
	   /*
	    *  <tr class="list rank-1" songId="87463771">
    <td class="check"><input type="checkbox" class="select-check" title=" 연애소설 (Feat. 아이유) "/>
   <td class="number">1
       <span class="rank"><span class="rank-none"><span class="hide">유지</span></span></span>
   </td>
    <td><a href="#" class="cover"  onclick="fnViewAlbumLayer(80991334); return false;" ontouchend="fnViewAlbumLayer(80991334); return false;" ><span class="mask"></span><img onerror="this.src='//image.genie.co.kr/imageg/web/common/blank_68.gif';" src="//image.genie.co.kr/Y/IMAGE/IMG_ALBUM/080/991/334/80991334_1508741715086_1_140x140.JPG" alt="연애소설 (Feat. 아이유)" /></a></td>
    <td class="link"><a href="#" class="btn-basic btn-info" onclick="fnViewSongInfo(87463771); return false;" ontouchend="fnViewSongInfo(87463771); return false;" >곡 제목 정보 페이지</a></td>
      <td class="info">
           <a href="#" class="title ellipsis" title="연애소설 (Feat. 아이유)" onclick="fnPlaySong('87463771;','1'); return false;" ontouchend="fnPlaySong('87463771;','1'); return false;">
연애소설 (Feat. 아이유)</a>
            <a href="#" class="artist ellipsis"onclick="fnViewArtist(14943161); return false;" ontouchend="fnViewArtist(14943161); return false;" >에픽하이 (EPIK HIGH)</a>           <div class="toggle-button-box" id="hide-button">
               <button type="button" class="btn artist-etc"onclick="fnRelationArtistList('87463771'); artist_etc_layer._show(this);return false;" ontouchend="fnRelationArtistList('87463771'); artist_etc_layer._show(this);return false;" >외</button>
               <dl class="list" id="RelationArtist_87463771">
               </dl>
           </div>
	    */
	   try
	   {
		   String[] url={"http://www.genie.co.kr/chart/top100","http://www.genie.co.kr/chart/top100?ditc=D&ymd=20171024&hh=10&rtm=Y&pg=2"};
		   for(int k=0;k<1;k++)
		   {
			   Document doc=Jsoup.connect(url[k]).get();
			   Elements rank=doc.select("tr.list td.number");
			   Elements title=doc.select("tr.list td.info a.title");
			   Elements singer=doc.select("tr.list td.info a.artist");
			   String data = "";
			   for(int i=0;i<title.size();i++)
			   {
				   Element r=rank.get(i);
				   Element t=title.get(i);
				   Element s=singer.get(i);
				   System.out.println(r.text().substring(0,r.text().lastIndexOf(" "))+" "
						   +t.text()+" "
						   +s.text());
				   data +=r.text().substring(0,r.text().lastIndexOf(" "))+","
						   +t.text().replace(",", ".")+","
						    +s.text()+"\n";
				   String key =youtubeGetKeyData(t.text().replace(",", ""));
			   }
			   data=data.substring(0,data.lastIndexOf("\n"));
			   FileWriter fw = new FileWriter("/home/sist/music_data/genie.csv");
			   fw.write(data);
			   fw.close();
		   }
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return list;
   }
   public String youtubeGetKeyData(String title){
	   String key="";
	   try {
		   String url ="https://www.youtube.com/results?search_query="
				   +URLEncoder.encode(title,"UTF-8");
		   Document doc = Jsoup.connect(url).get();
		   String pattern = "watch\\?v=[^가-힣]+";//?:앞글자의 존재여부 상관없음 의미함
		   Pattern p = Pattern.compile(pattern);
		   Matcher m = p.matcher(doc.toString());
		   if(m.find()){
			   key=m.group();
		   }
		   //_s84FLFVQM8
		   key = key.substring(key.indexOf("=")+1, key.indexOf("\""));
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	   return key;
   }
}







