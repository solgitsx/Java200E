package kr.co.infopub.chapter.s109;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class CardCase {
 // aggregation : CardCase는 Card로 구성된다.
 private List<Card> cards=new ArrayList<Card>();
 public CardCase() {
	cards.clear(); // 내용 지우기
 }
 // List 반환
 public List<Card> getCards() { 
	return cards;
 }
 // List에 저장된 Card의 개수
 public int count(){ 
	return cards.size(); // 저장된 Card 개수
 }
 // List의 index번째 Card
 public Card getCard(int index){
	return cards.get(index);  // index번째 Card
 }
 // 서로 다른 카드 20장 만들기
 public void make(){
	cards.clear(); // 내용 지우기
	int suit=CardUtil.SUIT.length; // 0~3
	int valu=CardUtil.VALU.length; // 0~12
	int count=0;
	//서로 다른 20개의 카드를 만든다.
	while(count!=valu*suit){    // 20장이 될때까지
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
 public void print(){
	int valu=CardUtil.VALU.length;
	for (int i = 0; i < cards.size(); i++) {
		Card c=cards.get(i);
		System.out.printf("%s ",c.toString());
		if((i+1)%valu==0){
			System.out.println();
		}
	}
 }
 // CardComp 클래스가 없다.
 public void sort(){
	Comparator<Card> cmp=new Comparator<Card>() {
		@Override
		public int compare (Card c1, Card c2) {
			return c1.getCardVal().compareTo(c2.getCardVal());
		}
	};
	cards.sort(cmp); 
 }
 // CardRomp 클래스가 없다.
 public void rsort(){
	// 익명 -anonymous 
	cards.sort(new Comparator<Card>() {
		@Override
		public int compare (Card c1, Card c2) {
			return - c1.getCardVal().compareTo(c2.getCardVal());
		}
	});
}
 // sort를 lambda로 구현
 public void rambdasort(){
    Comparator<Card> cmp=(c1, c2)->{return c1.getCardVal().compareTo(c2.getCardVal());};
	cards.sort(cmp);
	//cards.sort((c1, c2) ->{return c1.getCardVal().compareTo(c2.getCardVal());});
 }
 public void lambdasort2(){
	Comparator<Card> cmp=Comparator.comparing(Card::getCardVal);
	cards.sort(cmp); 
	//cards.sort(Comparator.comparing(Card::getCardVal)); 
 }
 public void lambdasort3(){
	Comparator<Card> cmp=Card::compareCard;
	cards.sort(cmp);  // static 
	//cards.sort(Card::compareCard);  // static 
 }
 // rsort를 lambda로 구현
 public void lambdarsort(){
	cards.sort(
	(c1, c2) ->{return - c1.getCardVal().compareTo(c2.getCardVal());});
 }
 public void lambdarsort2(){
	Comparator<Card> mycard =(c1, c2)->{return c1.getCardVal().compareTo(c2.getCardVal());};
	cards.sort( mycard.reversed() );
 }
 public void lambdarsort3(){
	cards.sort(Card::compareRCard);  //static 
 }
}


/*
Comparator<Card> cmp=new Comparator<Card>() {
	@Override
	public int compare (Card c1, Card c2) {
		return c1.getCardVal().compareTo(c2.getCardVal());
	}
};
cards.sort(cmp); 
*/