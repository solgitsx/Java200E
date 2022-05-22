package kr.co.infopub.chapter.s104;
public class CardMain {
	public static void main(String[] args) {
		Card c1=new Card("H4");               // 생성자 (String 아규먼트)
		Card c2=new Card("H4");               // 생성자 (String 아규먼트)
		Card c3=new Card(c1);                 // 복사 생성자- 값동일
        System.out.println(c1.hashCode());    // 값은 동일 다른 해쉬
        System.out.println(c2.hashCode());    // 값은 동일 다른 해쉬
        System.out.println(c1.getCardVal());  // 값은 동일
        System.out.println(c2.getCardVal());  // 값은 동일
        System.out.println(c1.equals(c2));    // hashCode 비교- 중요-false
        System.out.println(c1.equals(c3));    // hashCode 비교- 중요 -false
        for(int i=0; i<CardUtil.SUIT.length ; i++){         // SUIT 2
        	for (int j = 0; j <CardUtil.VALU.length; j++) { // VALU 10
        		// 값은 같을 수 있지만 해쉬 코드는 고유(같을 수 없다)하다.
        		Card c=new Card();             // 임의로 카드 생성- 기본 생성자()
				System.out.printf("%s\t",c);   // c.toString()
			}
        	System.out.println( );// 10개 출력 후 한 칸 아래
        }
	}
}
