package kr.co.infopub.chapter.s091;
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
// Jsoup.parse : jsoup_1.13.1.jar
// org.apache.http  : httpclient, httpcore, commons
// https://mvnrepository.com 에서 다운로드
public class BillboardTimeMain {
 public static void main(String[] args) {
	 String newUrls = "https://www.billboard.com/charts/hot-100/";
     HttpGet request = new HttpGet(newUrls); // HttpClient를 이용하여
     CloseableHttpClient httpClient=null;
     CloseableHttpResponse response=null;
     Document doc = null;  
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
         String sdate=eid.attr("data-chart-date"); // 속성 값 
         System.out.println("이번 빌보드 차트 날짜 : "+sdate.trim());
     } catch (IOException e) {
		System.out.println(e);
	 }
 }
}
