package kr.co.infopub.chapter.s092;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class RequestFromBillboardHot {

 String result;
 public void getAllHtml(String newUrls){   
	HttpGet request = new HttpGet(newUrls);  // HttpGet 생성
    // 자동 finally 처리용 
    try (CloseableHttpClient httpClient = HttpClients.createDefault(); 
   	    CloseableHttpResponse response = httpClient.execute(request)){
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            result = EntityUtils.toString(entity);
        }
    } catch (IOException e) {
		System.out.println("Billboard Parsing error !!! ");
	 }
 }
 public void printHtml(){
	 System.out.println(result);
 }
 public String getTimeDate(String aurl) {  //s091에서 설명
	String newUrls = "https://www.billboard.com/charts/hot-100/";
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
 public static void main(String[] args) {
	RequestFromBillboardHot rfw=new RequestFromBillboardHot();
	String a="https://www.billboard.com/charts/hot-100/";
	String rs=rfw.getTimeDate(a);
	System.out.println("이번 주 "+rs);
	//rs=RestDay.toWantedDay(rs, 1);  //1주전
	//System.out.println("일주일 주 "+rs);
	rfw.getAllHtml(a+rs);  // hot-100 html 읽어 문자열로 저장
	rfw.printHtml();       // 저장한 내용 출력
 }
}