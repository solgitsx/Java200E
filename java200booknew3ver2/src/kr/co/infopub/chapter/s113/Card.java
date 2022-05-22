package kr.co.infopub.chapter.s113;
public class Card {
	private String cardVal;
	public Card() {
		init();
	}
	public void init() {
		int a = (int)(Math.random()*CardUtil.SUIT.length); 
		int b = (int)(Math.random()*CardUtil.VALU.length);
		cardVal = CardUtil.SUIT[a] + CardUtil.VALU[b];
	}
	public String getCardVal() {
		return cardVal;
	}
	@Override
	public String toString() {
		return  "["+cardVal+"]";
	}
	@Override
	public boolean equals(Object obj) {
		boolean isS = false;
		Card cd = (Card)obj;
		if (cardVal.equals(cd.getCardVal())) {
			isS = true;
		}
		return isS;
	}
	@Override
	public int hashCode() {
		return  cardVal.hashCode()+137;
	}
}
