package kr.co.infopub.chapter.s050;
// >> shift ? 삼항 연산자
public class BitNShiftMain {
	// 10진법 수를 2진수 스트링으로 변환
	public static String shifts(int a){
		String s="";
		for(int i=0;i<=31;i++){
			int aa=a%2;                
			s=(aa>=0)? aa+s : (-aa)+s;
			a>>=1;                     //  a/=2;
		}
		return s;
	}
	public static void main(String[] args) {
		int intNums1=123;
		int intNums2=-123;
		System.out.printf("%d  : %s%n",intNums1,shifts(intNums1));
		System.out.printf("%d : %s%n",intNums2,shifts(intNums2));
	}
}
