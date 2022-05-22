package kr.co.infopub.chapter.num;
import java.io.File;
public class FileNumberMaining {
	public static void main(String[] args) {
		int a=99;
		for(int i=a; i< a+1 ;i++){
			String s="s0"+i;
			File ff=new File("C:/Users/choco/eclipse_java200/java200booknew3ver2/src/kr/co/infopub/chapter/"+s);
			File[] ffs=ff.listFiles();
			for (File fff: ffs) {
				FileCommentsNumber fc=new FileCommentsNumber(fff.getAbsolutePath());
				fc.fileRWInAnyType();//확장자가 있건 없건,  java, txt이라도 된다.
				//System.out.println(fff.getAbsolutePath());
			}
		}
	}
}
