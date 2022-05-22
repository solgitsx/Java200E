package kr.co.infopub.chapter.s061;
public class BitShifting {
	public static final int BITMASK=1;	
	public  String makeBit(int value){
		//char배열을 String으로 만들기 위해 
		char[] val=new char[32];
		for(int i=31;i>=0;i--){
			if((value & BITMASK) ==1){
				val[i]='1';    //  1&1 일 때만 1 그 외 0
			}else{
				val[i]='0';	   //  1&1 일 때만 1 그 외 0
			}
			value >>>=1;  //value=value>>>1; 부호 무시 오른쪽 이동
		}
		return new String(val);//char배열을 String으로
	}
	public static void main(String[] args) {
		int ival=2345;
		int eval=-2345;
		BitShifting bitsh=new  BitShifting();
		String vals=bitsh.makeBit(ival);
		System.out.println(vals);
		vals=bitsh.makeBit(eval);
		System.out.println(vals);
		char[] vs=vals.toCharArray();
		System.out.println(vs[0]);
	}
}
