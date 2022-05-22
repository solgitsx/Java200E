package kr.co.infopub.chapter.s072;
import java.util.Iterator;
import java.util.Map;
public class SystemPropertyTest {
	public static void main(String[] args) {
		long namotime=System.nanoTime();
		for(int i=0;i<100000;i++){
			System.out.print("");
		}
		long namotime2=System.nanoTime();//10^-9 nano java5 추가
		System.out.println((namotime2-namotime));//1/1000000000초			
		System.out.println(System.getenv("JAVA_HOME")); // 환경변수
		//모든 env구하기
		Map<String, String> map=System.getenv();  // 환경변수
		Iterator<String> iter= map.keySet().iterator(); // Map에서 키 얻기
		int j=0;
		while(iter.hasNext()){
			String keys=iter.next();
			System.out.println((++j+" ")+keys+" : "+map.get(keys));
		}
	}//main
}

