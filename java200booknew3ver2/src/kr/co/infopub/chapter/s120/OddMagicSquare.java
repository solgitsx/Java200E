package kr.co.infopub.chapter.s120;

public class OddMagicSquare extends MagicSquare{

	public OddMagicSquare(int n) {
		super(n);    // 중요 -> 부모로 넘긴다.
	}
	public OddMagicSquare( ) {
		this(3);
	}
	@Override
	public void make( ){
		int x=0;
		int y=n/2;
		magic[x][y]=1;
		//System.out.printf("(%d,%d)\t",x,y);
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
			//System.out.printf("(%d,%d)\t",x,y);
			magic[x][y]=i;
		}//for
	}
}//class 
