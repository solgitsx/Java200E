package kr.co.infopub.chapter.s112;
public class CardPrint {
 CardCase cc = new CardCase();
 CardLaw rule = new CardLaw();

 private int TotalPlayer;
 private int TotalDealer;

 public CardPrint() {}

 public void make(){
	cc.make();
 }
 public void shuffle(){
	cc.shuffle();//카드 섞기
 }
 public void print() {

	System.out.println("<플레이어 카드>");
	System.out.println("---------------------");
	
	System.out.print("1번째 카드 : ");
	System.out.println(cc.getCards().get(0));
	System.out.print("1번째 카드 수 : ");
	System.out.println(num(0));
	
	System.out.print("2번째 카드 : ");
	System.out.println(cc.getCards().get(1));
	System.out.print("2번째 카드 수 : ");
	System.out.println(num(1));
	
	System.out.print("플레이어의 2장의 카드합 : ");
	System.out.println(sumP());
	TotalPlayer = sumP();
	
	System.out.println("---------------------");
	
	if (rule.natural(sumP(), sumD())) {
		System.out.println("예외처리로 바로 겨룹니다!");
		TotalPlayer = sumP();
	}else if (rule.stand(sumP(), sumD())) {
		standPrintPl();
	}else if (rule.thirdCardPlayer(sumP())) {
		System.out.println("3 번째 카드를 받습니다!");
		System.out.println("3 번째 카드 : " + cc.getCards().get(4));
		System.out.println("3 번째 카드 수 : " + num(4));
		System.out.println("---------------------");
		System.out.println("플레이어의 총 카드 합 : " + total(sumP(), num(4)));
		TotalPlayer = total(sumP(), num(4));
	}
	System.out.println("---------------------");
	System.out.println();
	
	System.out.println("<딜러 카드>");
	System.out.println("---------------------");
	
	System.out.print("1번째 카드 : ");
	System.out.println(cc.getCards().get(2));
	System.out.print("1번째 카드 수 : ");
	System.out.println(num(2));
	
	System.out.print("2번째 카드 : ");
	System.out.println(cc.getCards().get(3));
	System.out.print("2번째 카드 수 : ");
	System.out.println(num(3));
		
	System.out.print("딜러의 2장의 카드합 : ");
	System.out.println(sumD());
	TotalDealer = sumD();
	
	System.out.println("---------------------");
			
	if (rule.natural(sumP(), sumD())) {
		System.out.println("예외처리로 바로 겨룹니다!");
		TotalDealer = sumD();
	}
	else if (rule.stand(sumP(), sumD())) {
		standPrintDl();
	}
	else if (rule.thirdCardDealer(sumD(), num(4))) {
		System.out.println("3 번째 카드를 받습니다!");
		System.out.println("3 번째 카드 : " + cc.getCards().get(5));
		System.out.println("3 번째 카드 수 : " + num(5));
		System.out.println("---------------------");
		System.out.println("딜러의 총 카드 합 : " + total(sumD(), num(5)));
		TotalDealer = total(sumD(), num(5));
	}
	System.out.println("---------------------");
	System.out.println();
 }
 public void standPrintPl() {
	System.out.println("스탠드 입니다.");
	if (sumP() > 5 && sumP() < 8) {
		if (sumD() < 6 ) {
			System.out.println("딜러는 3번째 카드를 받습니다.");
		}else {
			System.out.println("바로 겨룹니다!");
			TotalPlayer = sumP();
		}
	}
	else if (sumD() == 7 ) {
		if (sumP() < 6) {
			System.out.println("3 번째 카드를 받습니다!");
			System.out.println("3 번째 카드 : " + cc.getCards().get(4));
			System.out.println("3 번째 카드 수 : " + num(4));
			System.out.println("---------------------");
			System.out.println("플레이어의 총 카드 합 : " + total(sumP(), num(4)));
			TotalPlayer = total(sumP(), num(4));
		}else {
			System.out.println("바로 겨룹니다.");
			TotalPlayer = sumP();				
		}
	}
 }
 public void standPrintDl() {
	System.out.println("스탠드 입니다.");
	if (sumP() > 5 && sumP() < 8) {
		if (sumD() < 6 ) {
			System.out.println("3 번째 카드를 받습니다!");
			System.out.println("3 번째 카드 : " + cc.getCards().get(5));
			System.out.println("3 번째 카드 수 : " + num(5));
			System.out.println("---------------------");
			System.out.println("딜러의 총 카드 합 : " + total(sumD(), num(5)));
			TotalDealer = total(sumD(), num(5));
		}	
		else {
			System.out.println("바로 겨룹니다!");
			TotalDealer = sumD();
		}
	}
	else if (sumD() == 7 ) {
		if (sumP() < 6) {
			System.out.println("플레이어는 3번째 카드를 받습니다.");
		}
		else {
			System.out.println("바로 겨룹니다.");
			TotalDealer = sumD();
		}
	}
 }

 public int num(int n) {
	int num;
	Card str = cc.getCards().get(n);
	char ch = str.getCardVal().charAt(1);//H3				
	switch (ch) {
		case 'A' : num = 1;break;
		case 'T' : 
		case 'J' : 
		case 'Q' : 
		case 'K' : num = 0; break;	//fall through
		default : num=ch-'0';break;//'9'-'0'
	}
	return num;
 }
 public int sumP() {
	int sumP = 0;
	for (int i = 0; i < 2; i++) {
		sumP += num(i);
		if (sumP > 9) {
			sumP -= 10;//1의 자리수
		}			
	}
	return sumP;
 }
 public int sumD() {
	int sumD = 0;
	for (int i = 2; i < 4; i++) {
		sumD += num(i);
	}
	return sumD%10;
 }
 public int total(int x, int y){
	return (x+y)%10;
 }
 public int returnPlayer() {
	return TotalPlayer;
 }
 public int returnDealer() {
	return TotalDealer;
 }
}
