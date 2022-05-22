package kr.co.infopub.chapter.s170;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONObject;
import java.io.BufferedReader;
public class FixerConvert {  //https://fixer.io에 가입 access_key를 얻자
	public static String conversion(String date,String base) {
		BufferedReader br=null;
		String newUrls1="http://data.fixer.io/api/%s?access_key=97042483f2b64c6bfe1dbfbf4a2bd1b3&symbols=KRW,JPY,CNY,USD,EUR";
		String newUrls=String.format(newUrls1, date,base);
		URL url=null;
		StringBuffer sb=new StringBuffer();
		try {
			url=new URL(newUrls); // http://data.fixer.io/api
			System.out.println(newUrls);
			br=new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
			String msg="";
			// http://data.fixer.io/api를 읽어 들인다.
			while((msg=br.readLine())!=null){
				sb.append(msg);
			}
		} catch (Exception e) {
			
		}
		return sb.toString();
	}
	public static FixerRate  convert2(String  data,String base) throws Exception{
		JSONObject jObject = new JSONObject(data);
		JSONObject rates=jObject.getJSONObject("rates");

		FixerRate fixerrate=new FixerRate();
		fixerrate.date=jObject.getString("date");
		fixerrate.base=base;
		if(base.equals("USD")){
			fixerrate.usd=rates.getDouble("USD")/rates.getDouble("USD");
			fixerrate.krw=rates.getDouble("KRW")/rates.getDouble("USD");
			fixerrate.jpy=rates.getDouble("JPY")/rates.getDouble("USD");
			fixerrate.eur=rates.getDouble("EUR")/rates.getDouble("USD");
			fixerrate.cny=rates.getDouble("CNY")/rates.getDouble("USD");
		}else if(base.equals("KRW")){
			fixerrate.usd=rates.getDouble("USD")/rates.getDouble("KRW");
			fixerrate.krw=rates.getDouble("KRW")/rates.getDouble("KRW");
			fixerrate.jpy=rates.getDouble("JPY")/rates.getDouble("KRW");
			fixerrate.eur=rates.getDouble("EUR")/rates.getDouble("KRW");
			fixerrate.cny=rates.getDouble("CNY")/rates.getDouble("KRW");
		}else if(base.equals("JPY")){
			fixerrate.usd=rates.getDouble("USD")/rates.getDouble("JPY");
			fixerrate.krw=rates.getDouble("KRW")/rates.getDouble("JPY");
			fixerrate.jpy=rates.getDouble("JPY")/rates.getDouble("JPY");
			fixerrate.eur=rates.getDouble("EUR")/rates.getDouble("JPY");
			fixerrate.cny=rates.getDouble("CNY")/rates.getDouble("JPY");
		}  else if(base.equals("EUR")){
			fixerrate.usd=rates.getDouble("USD")/rates.getDouble("EUR");
			fixerrate.krw=rates.getDouble("KRW")/rates.getDouble("EUR");
			fixerrate.jpy=rates.getDouble("JPY")/rates.getDouble("EUR");
			fixerrate.eur=rates.getDouble("EUR")/rates.getDouble("EUR");
			fixerrate.cny=rates.getDouble("CNY")/rates.getDouble("EUR");
		} else if(base.equals("CNY")){
			fixerrate.usd=rates.getDouble("USD")/rates.getDouble("CNY");
			fixerrate.krw=rates.getDouble("KRW")/rates.getDouble("CNY");
			fixerrate.jpy=rates.getDouble("JPY")/rates.getDouble("CNY");
			fixerrate.eur=rates.getDouble("EUR")/rates.getDouble("CNY");
			fixerrate.cny=rates.getDouble("CNY")/rates.getDouble("CNY");
		}	
		return fixerrate;
	}
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		//String date="2018-04-11";  // String date="latest";
		String date=sdf.format(cal.getTime());
		String base="USD";       
		String fixerrate=conversion(date,base);
		try {
			FixerRate frate=convert2(fixerrate, base);
			System.out.println(frate);
			System.out.println(frate.krw);
			// JPY
			fixerrate=conversion(date,"JPY");
			frate=convert2(fixerrate, "JPY");
			System.out.println(frate);
			System.out.println(frate.krw);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
	  
