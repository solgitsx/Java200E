package kr.co.infopub.chapter.s048;
// 축약 연산자 
public class Contraction {
	public static int sumEach(int n){
		int tot=0;
		while(n!=0){
			tot+=n%10; // 3 -> 2-> 1
			n/=10;     // 123-> 12-> 1->0
		}
		return tot;
	}
	public static void main(String[] args) {
		int number=1234567;
		int value=sumEach(number);
		System.out.printf("%d에 대한 각자리의 수 합: %d",number,value);
	}
}
