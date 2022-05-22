package kr.co.infopub.chapter.s120;
// 100% 구현 안 된 메서드를 갖는 클래스 -> 인터페이스(추상 클래스임)
public interface IMagicSquare {
	//int a=100;  // public static final 이 자동으로 붙어 상수가 된다.
	// 자동으로 public abstract 가 붙는다.
	void make();     // 반드시 구현해야 할 메서드
	void print();    // 반드시 구현해야 할 메서드
}
