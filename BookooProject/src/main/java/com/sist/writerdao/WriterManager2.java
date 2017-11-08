package com.sist.writerdao;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("wm")
public class WriterManager2 {

	@Autowired
	private WriterDAO dao;
	
	public static void main(String[] args) {
		String[] xml ={"application-context.xml", "application-mongo.xml", "application-hadoop.xml"};
		ApplicationContext app = new ClassPathXmlApplicationContext(xml);
	
		WriterManager2 w = (WriterManager2)app.getBean("wm");
		w.WriterTop100();
	
		/*WriterManager wm = new WriterManager();
		wm.Writer300();*/
		System.out.println("db완료");
	}
	
	public List<WriterVO> WriterTop100(){
		List<WriterVO> list = new ArrayList<WriterVO>();
		
		try{
			//int[] sortType = {1,2};
			int[] wCategory = {11,12,13,14,15,16,17,18,19};
			int k=1;
			
			
				for(int j=0; j<wCategory.length; j++){
					
					try{
						
					
					//System.out.println(wCategory[j]);
					for(k=1; k<=10; k++){ // => 11~15 update 해야 함..
						//System.out.println("http://bookdb.co.kr/bdb/PersonDictionary.do?_method=authorList&sc.page=" + k +"&sc.writerCategoryNo="+wCategory[j]+"&sc.sortType="+sortType[i]);
												
						Document doc = Jsoup.connect("http://bookdb.co.kr/bdb/PersonDictionary.do?_method=authorList&sc.page="+k+"&sc.sortType=1&sc.writerCategoryNo="+wCategory[j]).get();
					/*
					 * div.listWrap div.wPic  a img.bd      → .attr(“src”) 작가이미지
                                                                  
     <dt><a href="/bdb/PersonDictionary.do?_method=writerDetail&prsnNo=26051138&writerCategoryNo=16&sc.page=1">호아킴 데 포사다</a>                                         
                                                                                
                                </dt>  div.listWrap dl dt a  → .text() 작가 이름 
       div.listWrap dl dt a  → .text() 작가 번호  .substring(~~~.IndexOf(prsnNo=)+1),lastindexof(“&w”)-1)
                                
                                <dd class="pubook">출간도서 : <span>20</span>종</dd>
                                
                                <dd class="sell">누적판매수 :<span>274,932</span>권</dd>                                              
                        </dl>	div.listWrap dl dd.pubook span  → .text() 출간도서
                        <ol>		div.listWrap dl dd.sell span → .text().replace(“,”,””) 누적판매수
                                
                                <li>
                                        <div class="bookView">
	div.listWrap ol li div.bookView span.bShadow a  →  .attr(“href”) 북 상세 링크   ==> isbn가져와야함
	div.listWrap ol li div.bookView span.bShadow img.bd  →  .attr(“src”)  북이미지
	div.listWrap ol li p.bookName a   → .text()    북네임
ISBN  ====>  div.bookInfoBox ul.bInfo_txt li  .last   .text()      .replace(“ISBN : ”,””).trim
	 * 
						*/
						
						Elements wnames = doc.select("div.listWrap dl dt a");
						Elements wnos = doc.select("div.listWrap dl dt a");
						Elements wpics = doc.select("div.listWrap div.wPic  a img.bd");
						//Elements winfos = doc.select("div.listWrap dl dd.bone");
						Elements wpublishedbs = doc.select("div.listWrap dl dd.pubook span");
						Elements waccbooks = doc.select("div.listWrap dl dd.sell span");
						//Elements wweekbooks = doc.select(""); 주간판매량인데 보류
						Elements wbtitle1s = doc.select("div.listWrap ol li p.bookName a");
								//div.prod_title > p
						Elements wbimg1s = doc.select("div.listWrap ol li div.bookView span.bShadow img.bd");
					
						
					try {
							
						
						for(int x=0; x<wnames.size(); x++){
							
							int wrank = ((x+1)+(k-1)*10); //작가 출력 순서 임시
							Element el_wname = wnames.get(x);
							Element el_wno = wnos.get(x);
							
							String wname = el_wname.text();
							String wno = el_wno.attr("href"); 
								wno = wno.substring(wno.indexOf("prsnNo=")+7, wno.lastIndexOf("&w"));
								//작가 번호  .substring(~~~.IndexOf(prsnNo=)+1),lastindexof(“&w”)-1)
							Element el_wpic = wpics.get(x);
							String wpic = el_wpic.attr("src");
							
							Element wpublishedb = wpublishedbs.get(x);
							Element waccbook = waccbooks.get(x);
							/*Element el_winfo = winfos.get(x);
							String winfo = el_winfo.text();*/
							String wpubooks = wpublishedb.text().replace(",", "");
							String waccbs = waccbook.text().replace(",", "");
							
						//작가소개 가져오기	
							Document doc3 = Jsoup.connect("http://bookdb.co.kr/bdb/PersonDictionary.do?_method=writerDetail&prsnNo="+Integer.parseInt(wno)).get(); 
							Elements el_wrintro = doc3.select("span#txtWrapView1");
							Element e_wintros = el_wrintro.get(0);
							String wintro = e_wintros.text();
							System.out.println((wCategory[j])+" "+ wrank + " " + wno + " " + wname + " " + wpic+" "+wpubooks+"권"+waccbs+"권");
							
						//	System.out.println("작가소개 : "+wintro);
							
							
							//for(int b=0; b<5; b++){
							
								Element wbtitles1 = wbtitle1s.get(5*x+0); //링크 가져오는 용, 제목 아님.
								Element wbtitles2 = wbtitle1s.get(5*x+1);
								Element wbtitles3 = wbtitle1s.get(5*x+2);
								Element wbtitles4 = wbtitle1s.get(5*x+3);
								Element wbtitles5 = wbtitle1s.get(5*x+4);
								
								/*String wbtitle1 = wbtitles1.text().replace("[품절]", "").trim();
								wbtitle1 = wbtitle1.replace("[절판]", "").trim();
								wbtitle1 = wbtitle1.replace("[일시품절]","").trim();*/
								Element wbimgs1 = wbimg1s.get(5*x+0);
								String wbimg1 = wbimgs1.attr("src");
								Element wbimgs2 = wbimg1s.get(5*x+1);
								String wbimg2 = wbimgs2.attr("src");
								Element wbimgs3 = wbimg1s.get(5*x+2);
								String wbimg3 = wbimgs3.attr("src");
								Element wbimgs4 = wbimg1s.get(5*x+3);
								String wbimg4 = wbimgs4.attr("src");
								Element wbimgs5 = wbimg1s.get(5*x+4);
								String wbimg5 = wbimgs5.attr("src");
								//System.out.println(wbimg);
								
						//책제목	
								//1
								String wblink1 = wbtitles1.attr("href");								
								Document doc_link1 = Jsoup.connect(wblink1).get(); //책 링크->isbn
								Elements elems_wb_titles1 = doc_link1.select("div.prod_title p"); //책제목 잘려서 다시 받아옴.
								Element elem_wb_titles1 = elems_wb_titles1.first();								
								String wb_temp_titles1 = elem_wb_titles1.text();
								String wb_titles1="";								
								if(wb_temp_titles1.lastIndexOf("[")>=0){
									wb_titles1 = wb_temp_titles1.substring(0, (wb_temp_titles1.lastIndexOf("[")
											)).trim();
								}else if(wb_temp_titles1.lastIndexOf(":")>=0){
									wb_titles1 = wb_temp_titles1.substring(0, (wb_temp_titles1.lastIndexOf(":")
											)).trim();
								}else{								
									wb_titles1 = wb_temp_titles1;
								}
								//2
								String wblink2 = wbtitles2.attr("href");								
								Document doc_link2 = Jsoup.connect(wblink2).get(); //책 링크->isbn
								Elements elems_wb_titles2 = doc_link2.select("div.prod_title p"); //책제목 잘려서 다시 받아옴.
								Element elem_wb_titles2 = elems_wb_titles2.first();								
								String wb_temp_titles2 = elem_wb_titles2.text();
								String wb_titles2="";								
								if(wb_temp_titles2.lastIndexOf("[")>=0){
									wb_titles2 = wb_temp_titles2.substring(0, (wb_temp_titles2.lastIndexOf("[")
											)).trim();
								}else if(wb_temp_titles2.lastIndexOf(":")>=0){
									wb_titles2 = wb_temp_titles2.substring(0, (wb_temp_titles2.lastIndexOf(":")
											)).trim();
								}else{								
									wb_titles2 = wb_temp_titles2;
								}
								
								//3
								String wblink3 = wbtitles3.attr("href");								
								Document doc_link3 = Jsoup.connect(wblink3).get(); //책 링크->isbn
								Elements elems_wb_titles3 = doc_link3.select("div.prod_title p"); //책제목 잘려서 다시 받아옴.
								Element elem_wb_titles3 = elems_wb_titles3.first();								
								String wb_temp_titles3 = elem_wb_titles3.text();
								String wb_titles3="";								
								if(wb_temp_titles3.lastIndexOf("[")>=0){
									wb_titles3 = wb_temp_titles3.substring(0, (wb_temp_titles3.lastIndexOf("[")
											)).trim();
								}else if(wb_temp_titles3.lastIndexOf(":")>=0){
									wb_titles3 = wb_temp_titles3.substring(0, (wb_temp_titles3.lastIndexOf(":")
											)).trim();
								}else{								
									wb_titles3 = wb_temp_titles3;
								}
								//4
								String wblink4 = wbtitles4.attr("href");								
								Document doc_link4 = Jsoup.connect(wblink4).get(); //책 링크->isbn
								Elements elems_wb_titles4 = doc_link4.select("div.prod_title p"); //책제목 잘려서 다시 받아옴.
								Element elem_wb_titles4 = elems_wb_titles4.first();								
								String wb_temp_titles4 = elem_wb_titles4.text();
								String wb_titles4="";								
								if(wb_temp_titles4.lastIndexOf("[")>=0){
									wb_titles4 = wb_temp_titles4.substring(0, (wb_temp_titles4.lastIndexOf("[")
											)).trim();
								}else if(wb_temp_titles4.lastIndexOf(":")>=0){
									wb_titles4 = wb_temp_titles4.substring(0, (wb_temp_titles4.lastIndexOf(":")
											)).trim();
								}else{								
									wb_titles4 = wb_temp_titles4;
								}
								//5
								String wblink5 = wbtitles5.attr("href");								
								Document doc_link5 = Jsoup.connect(wblink5).get(); //책 링크->isbn
								Elements elems_wb_titles5 = doc_link5.select("div.prod_title p"); //책제목 잘려서 다시 받아옴.
								Element elem_wb_titles5 = elems_wb_titles5.first();								
								String wb_temp_titles5 = elem_wb_titles5.text();
								String wb_titles5="";								
								if(wb_temp_titles5.lastIndexOf("[")>=0){
									wb_titles5 = wb_temp_titles5.substring(0, (wb_temp_titles5.lastIndexOf("[")
											)).trim();
								}else if(wb_temp_titles5.lastIndexOf(":")>=0){
									wb_titles5 = wb_temp_titles5.substring(0, (wb_temp_titles5.lastIndexOf(":")
											)).trim();
								}else{								
									wb_titles5 = wb_temp_titles5;
								}
								
							
							//ISBN 가져오기....	
							//1
								Elements wbisbns1 = doc_link1.select("div.bookInfoBox ul.bInfo_txt li");
								Element elem_wbisbn1 = wbisbns1.last();
								String wbisbn1 = elem_wbisbn1.text();
								if(wbisbn1.substring(0, 1).equals("저")||wbisbn1.substring(0, 1).equals("역")
										||wbisbn1.substring(0, 1).equals("그")||wbisbn1.substring(0, 1).equals("출")
										||wbisbn1.substring(0, 1).equals("발")||wbisbn1.substring(0, 1).equals("쪽")
										||wbisbn1.substring(0, 1).equals("제")){
									wbisbn1 = "0";
								}else{
									wbisbn1 = wbisbn1.replace("ISBN : ", "").trim();
								}
							//2		
								Elements wbisbns2 = doc_link2.select("div.bookInfoBox ul.bInfo_txt li");
								Element elem_wbisbn2 = wbisbns2.last();
								String wbisbn2 = elem_wbisbn2.text();
								if(wbisbn2.substring(0, 1).equals("저")||wbisbn2.substring(0, 1).equals("역")
										||wbisbn2.substring(0, 1).equals("그")||wbisbn2.substring(0, 1).equals("출")
										||wbisbn2.substring(0, 1).equals("발")||wbisbn2.substring(0, 1).equals("쪽")
										||wbisbn2.substring(0, 1).equals("제")){
									wbisbn2 = "0";
								}else{
									wbisbn2 = wbisbn2.replace("ISBN : ", "").trim();
								}
							//3	
								Elements wbisbns3 = doc_link3.select("div.bookInfoBox ul.bInfo_txt li");
								Element elem_wbisbn3 = wbisbns3.last();
								String wbisbn3 = elem_wbisbn3.text();
								if(wbisbn3.substring(0, 1).equals("저")||wbisbn3.substring(0, 1).equals("역")
										||wbisbn3.substring(0, 1).equals("그")||wbisbn3.substring(0, 1).equals("출")
										||wbisbn3.substring(0, 1).equals("발")||wbisbn3.substring(0, 1).equals("쪽")
										||wbisbn3.substring(0, 1).equals("제")){
									wbisbn3 = "0";
								}else{
									wbisbn3 = wbisbn3.replace("ISBN : ", "").trim();
								}
							//4	
								Elements wbisbns4 = doc_link4.select("div.bookInfoBox ul.bInfo_txt li");
								Element elem_wbisbn4 = wbisbns4.last();
								String wbisbn4 = elem_wbisbn4.text();
								if(wbisbn4.substring(0, 1).equals("저")||wbisbn4.substring(0, 1).equals("역")
										||wbisbn4.substring(0, 1).equals("그")||wbisbn4.substring(0, 1).equals("출")
										||wbisbn4.substring(0, 1).equals("발")||wbisbn4.substring(0, 1).equals("쪽")
										||wbisbn4.substring(0, 1).equals("제")){
									wbisbn4 = "0";
								}else{
									wbisbn4 = wbisbn4.replace("ISBN : ", "").trim();
								}
							//5	
								Elements wbisbns5 = doc_link5.select("div.bookInfoBox ul.bInfo_txt li");
								Element elem_wbisbn5 = wbisbns5.last();
								String wbisbn5 = elem_wbisbn5.text();
								if(wbisbn5.substring(0, 1).equals("저")||wbisbn5.substring(0, 1).equals("역")
										||wbisbn5.substring(0, 1).equals("그")||wbisbn5.substring(0, 1).equals("출")
										||wbisbn5.substring(0, 1).equals("발")||wbisbn5.substring(0, 1).equals("쪽")
										||wbisbn5.substring(0, 1).equals("제")){
									wbisbn5 = "0";
								}else{
									wbisbn5 = wbisbn5.replace("ISBN : ", "").trim();
								}
		
								//  .last   .text()      .replace(“ISBN : ”,””).trim
								System.out.println(" 책"+1+" "+wbisbn1+" "+wb_titles1 + " 이미지 : "+wbimg1);
								System.out.println(" 책"+2+" "+wbisbn2+" "+wb_titles2 + " 이미지 : "+wbimg2);
								System.out.println(" 책"+3+" "+wbisbn3+" "+wb_titles3 + " 이미지 : "+wbimg3);
								System.out.println(" 책"+4+" "+wbisbn4+" "+wb_titles4 + " 이미지 : "+wbimg4);
								System.out.println(" 책"+5+" "+wbisbn5+" "+wb_titles5 + " 이미지 : "+wbimg5);
						
						//vo값 채움		
								
								WriterVO vo = new WriterVO();
								
								vo.setWcate(wCategory[j]);
								//랭크는 누적 판매수로 정렬하면 나오긴 한데..편하게 쓰기 위해..
								vo.setWrank(wrank);
								vo.setWno(Integer.parseInt(wno));
								vo.setWname(wname);
								vo.setWpic(wpic);
								vo.setWpubbs(Integer.parseInt(wpubooks));
								vo.setWacc(Integer.parseInt(waccbs));
								vo.setWintro(wintro);

							
									vo.setWbisbn1(wbisbn1);
									vo.setWbtitle1(wb_titles1);
									vo.setWbimg1(wbimg1);										
								
									vo.setWbisbn2(wbisbn2);
									vo.setWbtitle2(wb_titles2);
									vo.setWbimg2(wbimg2);
								
									vo.setWbisbn3(wbisbn3);
									vo.setWbtitle3(wb_titles3);
									vo.setWbimg3(wbimg3);
								
									vo.setWbisbn4(wbisbn4);
									vo.setWbtitle4(wb_titles4);
									vo.setWbimg4(wbimg4);
								
									vo.setWbisbn5(wbisbn5);
									vo.setWbtitle5(wb_titles5);
									vo.setWbimg5(wbimg5);								
					
								list.add(vo);
								dao.writerInsert(vo);
							//}
						} // 1 : 1~~10 11~20 21~30
						
					} catch (Exception ex) {
						System.out.println("x : " + ex.getMessage());
						ex.printStackTrace();
					}
			  	}
				}catch(Exception ex){
					System.out.println("k" + ex.getMessage());
					ex.printStackTrace();
				}
					
			}	
			
			
			
		}catch(Exception ex){
			System.out.println("Writer100 : " + ex.getMessage());
			ex.printStackTrace();
			
		}
		
		
		return list;
		
	}

}

















