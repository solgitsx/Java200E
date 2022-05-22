package kr.co.infopub.chapter.s094;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RequestFromBillboardHot {

	ArrayList<Billbaord> billboards=new ArrayList<Billbaord>();
	
	public ArrayList<Billbaord> getBillboards() {
		return billboards;
	}
	public RequestFromBillboardHot(){
		billboards.clear();
	}
	public  void getBillboardData(String newUrls){
	billboards.clear();
	HttpGet request = new HttpGet(newUrls);  // HttpGet 생성
	Document doc = null;  
    // 자동 finally 처리용 
    try (CloseableHttpClient httpClient = HttpClients.createDefault(); 
   	  CloseableHttpResponse response = httpClient.execute(request)){
    	StringBuffer sb=new StringBuffer();
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity);
            sb.append(result);                // 모든 내용을 읽어온다.
        }
        doc=Jsoup.parse(sb.toString());      // 읽은 내용을 Document로 만든다.

        String r1="flex--column.flex--xy-center.";
        String r2="flex--no-shrink > span.chart-element__rank__number";
        String o1="span.chart-element__information__song.";
        String o2="text--truncate.color--primary";
        String i1="span.chart-element__information__artist.";
        String i2="text--truncate.color--secondary";
        String rank="li > button > span.chart-element__rank."+r1+r2;
        String song="li > button > span.chart-element__information > "+o1+o2;
        String singer="li > button > span.chart-element__information > "+i1+i2;
        //String image="li > button > span.chart-element__image.flex--no-shrink";
        Elements ranks = doc.select(rank);     // 랭킹 : 모든 내용에서 랭킹 찾기
        Elements songs = doc.select(song);     // 노래 : 모든 내용에서 노래  찾기
        Elements singers = doc.select(singer); // 가수 : 모든 내용에서 가수 찾기
        //Elements images = doc.select(image); // 이미지 : 모든 내용에서 이미지 찾기
        // 빌보드 객체에 랭킹, 노래, 가수를 저장, 빌보드 객체를 리스트에 저장
        for (int i = 0; i < ranks.size(); i++) {
        	Billbaord board=new Billbaord();
        	board.setRank(Integer.parseInt(ranks.get(i).text()));
        	board.setSong(songs.get(i).text());
        	board.setArtist(singers.get(i).text());
/*          String ss=images.get(i).attr("style");
        	if(ss!=null && !ss.trim().equals("") && ss.indexOf("https")!=-1) {
        		ss=ss.substring(ss.indexOf("https"));
        		ss=ss.substring(0,ss.length()-3);
        	}
        	board.setImagesrc(ss);*/
        	billboards.add(board);   // 빌보드 객체를 리스트에 저장
		}
    } catch (IOException e) {
		System.out.println("Billboard Parsing error !!! ");
	}
 }
 public void printBillboard(){
	for (Billbaord ss : billboards) {
		System.out.println(ss);
	}
 }
 public String getTimeDate(String newUrls) {  //s091에서 설명
     HttpGet request = new HttpGet(newUrls); // HttpClient를 이용하여
     CloseableHttpClient httpClient=null;
     CloseableHttpResponse response=null;
     Document doc = null;  
     String sdate="";
     try {
     	 httpClient = HttpClients.createDefault(); // 웹에 연결
     	 response = httpClient.execute(request);   // 결과 얻기
     	 StringBuffer sb=new StringBuffer();       // 5000줄정도 저장
         HttpEntity entity = response.getEntity(); 
         if (entity != null) {  // 결과가 있다면 결과에서 한줄씩
             String result = EntityUtils.toString(entity); 
             sb.append(result); // 한줄씩 저장
         }
         doc=Jsoup.parse(sb.toString()); // 전체 내용을 HTML 파싱
         String id="charts";  
         // <div id="charts" data-chart-date="2020-07-11"
         Element eid=doc.getElementById(id);    // 고유한 charts를 찾음
         sdate=eid.attr("data-chart-date"); // 속성 값 
     } catch (IOException e) {
 		 System.out.println("Billboard Parsing error !!! ");
	 }		
     return sdate!=null?
    			RestDay.saturday(sdate): RestDay.saturday();
 }
/* public static void main(String[] args) {
	RequestFromBillboardHot rfw=new RequestFromBillboardHot();
	String a="https://www.billboard.com/charts/hot-100/";
	String rs=rfw.getTimeDate(a);
	System.out.println("이번 주 "+rs);
	//rs=RestDay.toWantedDay(rs, 1);  //1주전
	rfw.getBillboardData(a+rs);  // 리스트에 빌보드 객체들을 저장
	rfw.printBillboard();       //  리스트에 저장한 빌보드 객체들 출력
 }*/
}