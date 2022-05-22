package kr.co.infopub.chapter.s175;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
public class FixerConvert {
	public static String conversion(String date,String base) {
		BufferedReader br=null;
		String newUrls1="http://data.fixer.io/api/%s?access_key=97042483f2b64c6bfe1dbfbf4a2bd1b3&symbols=KRW,JPY,CNY,USD,EUR";
		String newUrls=String.format(newUrls1, date,base);
		URL url=null;
		StringBuffer sb=new StringBuffer();
		try {
			url=new URL(newUrls); // http://api.fixer.io
			System.out.println(newUrls);
			br=new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
			String msg="";
			// http://api.fixer.io/2017-06-09?base=USD를 읽어 들인다.
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
		fixerrate.base=base;//jObject.getString("base");
		if(base.equals("USD")){
			double fixbase=rates.getDouble("USD");
			fixerrate.usd=rates.getDouble("USD")/fixbase;
			fixerrate.krw=rates.getDouble("KRW")/fixbase;
			fixerrate.jpy=rates.getDouble("JPY")/fixbase;
			fixerrate.eur=rates.getDouble("EUR")/fixbase;
			fixerrate.cny=rates.getDouble("CNY")/fixbase;
		}else if(base.equals("KRW")){
			double fixbase=rates.getDouble("KRW");
			fixerrate.usd=rates.getDouble("USD")/fixbase;
			fixerrate.krw=rates.getDouble("KRW")/fixbase;
			fixerrate.jpy=rates.getDouble("JPY")/fixbase;
			fixerrate.eur=rates.getDouble("EUR")/fixbase;
			fixerrate.cny=rates.getDouble("CNY")/fixbase;
		}else if(base.equals("JPY")){
			double fixbase=rates.getDouble("JPY");
			fixerrate.usd=rates.getDouble("USD")/fixbase;
			fixerrate.krw=rates.getDouble("KRW")/fixbase;
			fixerrate.jpy=rates.getDouble("JPY")/fixbase;
			fixerrate.eur=rates.getDouble("EUR")/fixbase;
			fixerrate.cny=rates.getDouble("CNY")/fixbase;
		}  else if(base.equals("EUR")){
			double fixbase=rates.getDouble("EUR");
			fixerrate.usd=rates.getDouble("USD")/fixbase;
			fixerrate.krw=rates.getDouble("KRW")/fixbase;
			fixerrate.jpy=rates.getDouble("JPY")/fixbase;
			fixerrate.eur=rates.getDouble("EUR")/fixbase;
			fixerrate.cny=rates.getDouble("CNY")/fixbase;
		} else if(base.equals("CNY")){
			double fixbase=rates.getDouble("CNY");
			fixerrate.usd=rates.getDouble("USD")/fixbase;
			fixerrate.krw=rates.getDouble("KRW")/fixbase;
			fixerrate.jpy=rates.getDouble("JPY")/fixbase;
			fixerrate.eur=rates.getDouble("EUR")/fixbase;
			fixerrate.cny=rates.getDouble("CNY")/fixbase;
		}	
		return fixerrate;
	}
	public static FixerRate  convert(String  date,String base){
		String conversions=conversion(date, base);
		FixerRate fixerRate=null;
		try {
			fixerRate= convert2(conversions, base);
		} catch (Exception e) {
			System.out.println(e);
		}
		return fixerRate;
	}
	public static JSONObject toJson(FixerRate fixerrate){
		JSONObject obj = new JSONObject();
        obj.put("USD", fixerrate.usd);
        obj.put("KRW", fixerrate.krw);
        obj.put("JPY", fixerrate.jpy);
        obj.put("CNY", fixerrate.cny);
        obj.put("EUR", fixerrate.eur);
        return obj;
	}
	// JSON으로 만든 후 파일로 저장한다.
	public static void main(String[] args) {
		String date=RestDay.todates();  // 오늘
		String base="USD";              // 1달러당 환율       
		JSONObject obj = new JSONObject();
        obj.put("base", base);
        obj.put("date",date);
       
		JSONArray fixerrate2s=new JSONArray();
		int j=0; int start=60; // 365  1년 
		for (int i = -start; i < 1; i++) {
	    	String todays=RestDay.toWantedDay(date,i);
	    	if(! RestDay.isRest(todays)){
	    		FixerRate fixerrate2=FixerConvert.convert(todays,base);
	    		fixerrate2s.put(j++, toJson(fixerrate2));
	    	}
	    }
		obj.put("rates",fixerrate2s);
		try (FileWriter file = new FileWriter(date+""+base+".json")) {
            file.write(obj.toString());
            file.flush();
        } catch (IOException e) {
           System.out.println(e);
        }
	}
}
	  
