package kr.co.infopub.chapter.s120;
public class FactoryMagic implements AutoCloseable{
 private static FactoryMagic ins;
 private FactoryMagic(){}

 public static FactoryMagic getInstence(){
	if(ins==null){
		ins=new FactoryMagic();
	}
	return ins;
 }
 public IMagicSquare getMagicSquare(int n) throws MagicException{
	IMagicSquare im=null;
	if(n<=2){//2보다 작거나 같은 수가 들어오면 throw를 발생시켜서 Exception을 발생시킨다 
		throw new MagicException("2보다 작은 수의 마장진은 ");
	}
	if(n%2!=0){
		im=new OddMagicSquare(n);
	}else if(n%4==0){
		im=new FourMagicSquare(n);
	}else{
		im=new SixMagicSquare(n);
	}		
	return im;
 }
 // try() 구문을 위한 close()
 @Override
 public void close() throws Exception {
	System.out.println("FactoryMagic End !!");
 }
}
