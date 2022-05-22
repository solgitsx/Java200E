package kr.co.infopub.chapter.s119;
public abstract class MagicSquare implements IMagicSquare{
	protected int [][] magic;     // 자식이 public처럼 사용
	protected int n;              // 자식이 public처럼 사용
	
	public int[][] getMagic() {
		return magic;
	}
	// 반듯이 int를 입력받아야하는 생성자
	public MagicSquare(int n) {
		magic=new int[n][n];
		this.n=n;
	}
    // 기본 생성자 제거
	//public MagicSquare() {}
	// 아래는 abstract가 되는 예 3가지
	//                             // 인터페이스 구현안함
	//public void make( ){ }       // 상속 강요
	//public abstract void make(); // 구현 안했다.
	
	public void print(){
		System.out.println();
		System.out.println(n+" is magic : "+isMagic());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(magic[i][j]+"\t");
			}
			System.out.println();
		}
	}
	//마방진이 잘 되었는가를 판단
	private  boolean isMagic( ){  // 자식이 public처럼 사용
		boolean isM=true;
		int[ ]m=new int[2*n+2];
		for (int i = 0; i < n; i++) {
			m[i]=sumRow(i);
			m[i+n]=sumCol(i);
		}
		m[2*n]=sumReverseDia();
		m[2*n+1]=sumDia();
		for (int i = 1; i < m.length; i++) {
			if(m[0]==0 || m[0]!=m[i]){
				isM=false;
				break;
			}
		}
		return isM;
	}
	//row 행의 열들의 합
	private int sumRow(int row){
		int tot=0;
		for (int i = 0; i < n; i++) {
			tot+=magic[row][i];
		}
		return tot;
	}
	
	//col 열의(열고정)  행들의 합
	private int sumCol(int col){
		int tot=0;
		for (int i = 0; i < n; i++) {
			tot+=magic[i][col];
		}
		return tot;
	}
	
	private int sumDia(){
		int tot=0;
		for (int i = 0; i < n ; i++) {
			tot+=magic[i][n-1-i];
		}
		return tot;
	}
	
	private int sumReverseDia(){
		int tot=0;
		for (int i = 0; i < n ; i++) {
			tot+=magic[i][i];
		}
		return tot;
	}
}
