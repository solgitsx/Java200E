package kr.co.infopub.chapter.s113;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
public class CardCase {
	// aggregation : CardCase는 Card로 구성된다.
 private List<Card> cards=new ArrayList<Card>();
 public CardCase() {
	cards.clear(); // 내용 지우기
 }
 public List<Card> getCards() {
	return cards;
 }
 public int count(){
	return cards.size(); // 저장된 Card 개수
 }
 public Card getCard(int index){
	return cards.get(index);  // index번째 Card
 }
 public void make(){
	cards.clear(); // 내용 지우기
	int deck=CardUtil.SUIT.length; // 0~3
	int suit=CardUtil.VALU.length; // 0~12
	int count=0;
	//서로 다른 20개의 카드를 만든다.
	while(count!=deck*suit){    // 20장이 될때까지
		Card c=new Card();      // 임의의 카드를 만든다
		if(!cards.contains(c)){ // contains -> equals()를 이용해 비교
			cards.add(c);       // 같은 객체가 아니라면 저장
			count++;
		}
	}
 }
 public void shuffle(){
	Collections.shuffle(cards); // 카드 섞기
 }
/* public void print(){
	int valu=CardUtil.VALU.length;
	for (int i = 0; i < cards.size(); i++) {
		Card c=cards.get(i);
		System.out.printf("%s ",c.toString());
		if((i+1)%valu==0){
			System.out.println();
		}
	}
 }*/
 public void print(){
	int suit=CardUtil.VALU.length;
	IntStream.range(0, cards.size())
	  .forEach(
		i ->{ System.out.printf("%s ",cards.get(i).toString());
			  if((i+1)%suit==0){System.out.println();} 
	        }
	    );
 }
 // CardComp 클래스가 없다.
 public void sort(){
	cards.sort((c1, c2) ->{return c1.getCardVal().compareTo(c2.getCardVal());});
 }
 // CardRomp 클래스가 없다.
 public void rsort(){
	cards.sort(
			(c1, c2) ->{return - c1.getCardVal().compareTo(c2.getCardVal());});
 }
}