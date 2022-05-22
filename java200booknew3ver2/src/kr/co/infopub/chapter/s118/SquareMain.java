package kr.co.infopub.chapter.s118;
import java.util.Scanner;
public class SquareMain {
 public static void main(String[] args) {
	System.out.println("3이상의 정수 마방진을 입력하세요.");
	Scanner scann=new Scanner(System.in);
	int n=scann.nextInt();
	MagicSquare magic=null;
	if(n>2 && n%2==1){        // 홀수 
		magic=new OddMagicSquare(n);  // 다형성 - 부모 타입으로 자식을 생성할 수 있다.
	}else if(n>2 && n%4==0){
		magic=new FourMagicSquare(n); // 다형성 - 부모 타입으로 자식을 생성할 수 있다.
	}else if(n>2 && n%4==2){
		magic=new SixMagicSquare(n);  // 다형성 - 부모 타입으로 자식을 생성할 수 있다.
	}else{
		System.out.println("만들수 없는 마방진입니다.");
		return ;
	}
	MagicPrint.print(magic);     // 다형성- 부모 타입으로 자식을 받을 수 있다.
 }
}
