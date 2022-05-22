package kr.co.infopub.chapter.s090;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class WikipediaMain2 {
 public static void main(String[] args) {
	ArrayList<String> htmls=new ArrayList<String>();
	String newUrls="https://ko.wikipedia.org/wiki/ISO_3166-1";
	URL url=null;
	try {
    	url=new URL(newUrls);  //주소 찾기
    	// 주소지에 빨대 꽂기
 		BufferedReader reader = new BufferedReader(  
 				              new InputStreamReader(url.openStream(),"utf-8"),8);
 		String line = null;
 		while ((line = reader.readLine()) != null){  // 한줄씩 읽어서 
 			if(!line.trim().equals("")){             // 공백이 아니면 출력한다.
 				htmls.add(line.trim());              // ArrayList 한줄씩 저장
 			}
 		}
 	} catch (Exception e) {
 		System.out.println("Wiki Flag Parsing error !!! ");
    } 
	// ArrayList에 저장된 문자열을 출력
	for (String str : htmls) {
		System.out.println(str);
	}
 }
}