package kr.co.infopub.chapter.s108;

import kr.co.infopub.chapter.s107.CardUtil;

public class Card {
 private String cardVal; //H8
 public String getCardVal() {
	return cardVal;
 }
 public Card() {
	int deck=(int)(Math.random()*CardUtil.SUIT.length); // 0~3
	int suit=(int)(Math.random()*CardUtil.VALU.length); // 0~12
	//임의의 카드 값을 갖는다. H6
	cardVal=CardUtil.SUIT[deck]+CardUtil.VALU[suit];
 }
 // 테스트용
 public Card(String s) {
	this.cardVal=s;  // 문자열은 값 복사
 }
 // 복사 생성자
 public Card(Card c) {
	this(c.getCardVal());  // 문자열은 값 복사
	// this.cardVal=c.getCardVal(); //동일
 }
 @Override
 public String toString() {
	return "[" + cardVal + "]";
 }
 // Eclipse-Source-Generate hashCode() and equals()를 이용하여 자동으로 만들자
 @Override
 public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cardVal == null) ? 0 : cardVal.hashCode());
	return result;
 }
 // 소스를 정리하면  카드값과 카드값을 일대일로 비교한다.
 @Override
 public boolean equals(Object obj) {
	Card cb=(Card)obj; 
	if(cardVal.equals(cb.getCardVal())){
		return true;
	}else{
		return false;
	}
 } 
 // 추가된 static 비교 기준 메서드
 public static int compareCard(Card c1, Card c2){
	return c1.getCardVal().compareTo(c2.getCardVal());
 }
 public static int compareRCard(Card c1, Card c2){
	return -c1.getCardVal().compareTo(c2.getCardVal());
 }
}