package kr.co.infopub.chapter.s109;
public class CardCaseMain {
	public static void main(String[] args) {
		CardCase cc=new CardCase();
		cc.make();
		cc.print();
		System.out.println("--------------------------");
		cc.shuffle();   // 카드 섞기
		cc.print();
		System.out.println("--------------------------");
		cc.shuffle();   // 카드 섞기
		cc.print();
		System.out.println("--------------------------");
		cc.sort();
		cc.print();
		System.out.println("--------------------------");
		cc.rsort();
		cc.print();
		System.out.println("--------------------------");
		cc.lambdasort3();
		cc.print();
		System.out.println("--------------------------");
		cc.lambdarsort3();
		cc.print();
	}
}
