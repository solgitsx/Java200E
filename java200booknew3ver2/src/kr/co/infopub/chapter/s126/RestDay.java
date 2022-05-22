package kr.co.infopub.chapter.s126;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
// s075 RestDay 추가
public class RestDay {
 // 토, 일요일 인가?
 public static boolean isRest(Calendar tod){
	boolean isRest=false;
	if(tod.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || // 토요일
	    tod.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY ){  //또는 일요일
		isRest=true;
	}
	return isRest;
 }
 // Calendar를 문자열로
 public static String toYMD(Calendar dd){
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	return sdf.format(dd.getTime());
 }	
 public static void main(String[] args) {
	Calendar cal=Calendar.getInstance();
	int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	for (int i= 1; i <=lastDay; i++) {
		cal.set(Calendar.DAY_OF_MONTH, i);  // 1일부터 마지막날까지 
		if(isRest(cal)){                    // 휴일(토,일)확인
			System.out.println(toYMD(cal)+" is Rest Day.");
		}             
	}
 }
 public static Calendar todate(String ss){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dd=new Date();
		try {
			dd=sdf.parse(ss);
		} catch (ParseException e) {
		}
		Calendar cal=Calendar.getInstance();
		cal.setTime(dd);
		return cal;
	 }

	 public static String toYMD2(Calendar dd){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(dd.getTime());
	 }
	 public static String goGo(String ss,int day){
		Calendar cal=todate(ss);
		//-7일을 더하면 일주전
		cal.add(Calendar.DAY_OF_YEAR, day);
		//칼렌더를 문자열로 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	 }
	// 휴일 구하기 113, 13일의 금요일 115, 파일 118, 빌보드 79
	public static boolean isRest(String day){
		//토, 일만 쉬도록 
		boolean isRest=false;
		Calendar tod= todate(day);
		if(tod.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || 
				tod.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY ){ //토요일 또는 일요일
			isRest=true;
		}
		return isRest;
	}
	public static String toWantedDay(String ss,int round){
		Calendar cal=todate(ss);
		//-7일을 더하면 일주전
		cal.add(Calendar.DAY_OF_YEAR, -(round*7));
		//칼렌더를 문자열로 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}

	public static String toDay(String rs){  // 8월 16, 2017
		SimpleDateFormat sdfDesired = new SimpleDateFormat("MMMMM dd, yyyy");
		Calendar ts=todate(rs);
		String sss=sdfDesired.format(ts.getTime());
		return sss;
	}
	public static Date toDate(int year, int month, int day){
		return toCalendar(year,month,day).getTime();
	}
	public static Calendar toCalendar(int year, int month, int day){
		Calendar cal=Calendar.getInstance();
		cal.set(year, month-1, day);
		return cal;
	}
	public static String toStrDate(Date dd){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(dd);
	}
}
