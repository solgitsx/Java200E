package kr.co.infopub.chapter.s158;
import java.io.IOException;
import java.util.Vector;
public class ObjectStudentWriteMain {
	public static void main(String[] args) {
		ObjectStudentRWG<Student> osw=new ObjectStudentRWG< > ();
		Vector<Student> v=new Vector<>();
		v.add(new Student("홍길동",17,"한양"));
		v.add(new Student("홍길순",15,"순천"));
		v.add(new Student("몽룡",20,"화천"));
		v.add(new Student("춘향",18,"삼척"));
		try {
			osw.write("kisul\\stu.obj",v);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
