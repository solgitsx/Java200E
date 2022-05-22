package kr.co.infopub.chapter.s108;
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
		cc.lambdasort();
		cc.print();
		System.out.println("--------------------------");
		cc.lambdarsort();
		cc.print();
	}
}
