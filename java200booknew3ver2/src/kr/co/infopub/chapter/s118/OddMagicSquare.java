package kr.co.infopub.chapter.s118;
// 상속
public class OddMagicSquare extends MagicSquare{ // 상속 

	public OddMagicSquare(int n) {   
		super(n);     // 중요 -> 부모로 넘긴다. MagicSquare(n)
	}
	public OddMagicSquare( ) {
		this(3);      // 중요-> 생성자 오버로딩. OddMagicSquare(3)
	}
	@Override
	public void make( ){   // 오버라이딩
		int x=0;
		int y=n/2;         // n protected -> 자식은 public처럼 사용
		magic[x][y]=1;     // protected -> 자식은 public처럼 사용
		for (int i = 2; i <= n*n ; i++) {
			int temX=x;
			int temY=y;
			if( x-1<0 ){
				x=n-1;
			}else{
				x--;
			}
			
			if( y-1<0 ){
				y=n-1;
			}else{
				y--;
			}
			if(magic[x][y]!=0){
				x=temX+1;
				y=temY;
			}
			magic[x][y]=i;
		}//for
	}
}//class 
