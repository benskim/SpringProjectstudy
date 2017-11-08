package com.sist.mgr;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.MusicDAO;

@Component("mm")
public class MusicManager {
	@Autowired
	private MusicDAO dao;

	public static void main(String[] arg) {
		try {
			ApplicationContext app = new ClassPathXmlApplicationContext("application-context.xml");
			MusicManager m = (MusicManager) app.getBean("mm");
			List<MusicVO> list = m.genieTop100();
			for (MusicVO vo : list) {
				m.dao.musicInsert(vo);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public List<MusicVO> genieTop100() {
		List<MusicVO> list = new ArrayList<MusicVO>();

		try {
			String[] url = { "http://www.genie.co.kr/chart/top100",
					"http://www.genie.co.kr/chart/top100?ditc=D&ymd=20171024&hh=10&rtm=Y&pg=2" };
			for (int k = 0; k < 1; k++) {
				Document doc = Jsoup.connect(url[k]).get();
				Elements rank = doc.select("tr.list td.number");
				Elements title = doc.select("tr.list td.info a.title");
				Elements singer = doc.select("tr.list td.info a.artist");
				Elements poster = doc.select("tr.list td a.cover img");
				Elements id = doc.select("tr.list td span.rank");
				String data = "";
				for (int i = 0; i < title.size(); i++) {
					Element r = rank.get(i);
					Element t = title.get(i);
					Element s = singer.get(i);
					System.out.println(
							r.text().substring(0, r.text().lastIndexOf(" ")) + " " + t.text() + " " + s.text());
					data += r.text().substring(0, r.text().lastIndexOf(" ")) + "," + t.text().replace(",", "") + ","
							+ s.text() + "\n";
					String ss = t.text().replace(",", "");
					int index = ss.indexOf("(");
					if (index > 0) {
						ss = ss.substring(0, index).trim();
					}
					String key = youtubeGetKeyData(ss);
					System.out.println(key);
					MusicVO vo = new MusicVO();
					vo.setRank(Integer.parseInt(r.text().substring(0, r.text().lastIndexOf(" ")).trim()));
					vo.setTitle(t.text());
					vo.setSinger(s.text());
					vo.setPoster("http:" + poster.get(i).attr("src"));
					String str = id.get(i).text().replaceAll("[^0-9]", "");
					if (str.length() < 1)
						str = "0";
					vo.setIdIncrement(str);
					vo.setStatus(id.get(i).text().replaceAll("[^가-힣]", ""));
					vo.setKey(key);
					list.add(vo);
				}
				data = data.substring(0, data.lastIndexOf("\n"));
				FileWriter fw = new FileWriter("/home/sist/music_data/genie.csv");
				fw.write(data);
				fw.close();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	public String youtubeGetKeyData(String title) {
		// https://www.youtube.com/results?search_query=%EC%97%B0%EC%95%A0%EC%86%8C%EC%84%A4
		String key = "";
		try {
			String url = "https://www.youtube.com/results?search_query=" + title;
			Document doc = Jsoup.connect(url).get();
			String pattern = "/watch\\?v=[^가-힣]+";
			// \\.
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(doc.toString());
			while (m.find()) {
				key = m.group();
				break;
			}
			key = key.substring(key.indexOf("=") + 1, key.indexOf("\""));
			System.out.println(key);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return key;
	}

	public List<RankData> genieRank() {
		List<RankData> list = new ArrayList<RankData>();
		try {
			Document doc = Jsoup.connect("http://www.genie.co.kr/chart/top100").get();
			Elements rank = doc.select("div.aside_keyword ul li span");
			Elements data = doc.select("div.aside_keyword ul li a");
			for (int i = 0; i < 10; i++) {
				Element r = rank.get(i);
				Element d = data.get(i);
				String str = d.text();
				int index = str.indexOf("(");
				if (index > 0) {
					str = str.substring(0, str.indexOf("(")).trim();
				}
				System.out.println(r.text() + " " + str);
				RankData rd = new RankData();
				rd.setRank(r.text());
				rd.setData(str);
				list.add(rd);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
}