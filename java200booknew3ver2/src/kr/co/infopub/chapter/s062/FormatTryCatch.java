package kr.co.infopub.chapter.s062;
public class  FormatTryCatch{
	public static void main(String[] args) {	
		String sNum="123";
		String nNum="h";
		try{
			int a=Integer.parseInt(sNum);
			System.out.println(a);
		}catch(NumberFormatException ee){
			System.out.println("int인지 확인해 봐!!!!");
			System.err.println(ee.getMessage());
		}catch(Exception ee){
			System.out.println("야 잘 좀 넣어");
		}finally{
			System.out.println("난 수행되어야 만 해!!!!");
		}
	}
}
