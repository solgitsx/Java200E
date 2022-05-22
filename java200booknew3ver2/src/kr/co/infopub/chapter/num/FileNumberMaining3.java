package kr.co.infopub.chapter.num;
import java.io.File;
public class FileNumberMaining3 {
	public static void main(String[] args) {
		int a=102;
		String s="s"+a+"/"+"BillboardAccordianFxController";
		File ff=new File("C:/Users/choco/eclipse_java200/java200booknew3ver2/src/kr/co/infopub/chapter/"+s);
		FileCommentsNumber fc=new FileCommentsNumber(ff.getAbsolutePath());
		fc.fileRWInAnyType();//확장자가 있건 없건,  java, txt이라도 된다.
		
	}
}
