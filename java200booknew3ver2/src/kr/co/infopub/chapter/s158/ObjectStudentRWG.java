package kr.co.infopub.chapter.s158;
import java.io.*;
import java.util.Vector;
public class ObjectStudentRWG<T> {
 public int write(String fname, Vector<T> v) throws IOException{
	int objectNumber=0;
	try {
		FileOutputStream fos=new FileOutputStream(fname);
		ObjectOutputStream oos=new ObjectOutputStream(fos);//throws
		objectNumber=v.size();
		oos.writeInt(objectNumber);
		System.out.println(objectNumber+"개의 Data가 입력됨");
		for(int i=0;i<objectNumber;i++){
			oos.writeInt(i);
			oos.writeObject(v.get(i));
			oos.flush();
			System.out.println(i+"번째의  Data가 입력됨");
		}
		oos.close();   fos.close();
	} catch (FileNotFoundException e) {
		System.out.println("잘못된 파일이름을 입력했습니다.");
	} catch(Exception ee){
		throw new IOException("타입이 이상합니다."+ee);
	}
	return objectNumber;
 }
 public void read(String fname) throws IOException{
	try {
		FileInputStream fis = new FileInputStream(fname);
		ObjectInputStream ois=new ObjectInputStream(fis);//throws
		int objectNumber=ois.readInt();
		System.out.println(objectNumber+"개의 Data를 읽음");
		for(int i=0;i<objectNumber;i++){
			try {
				System.out.print(ois.readInt()+"번째 :");
				System.out.println(ois.readObject());
			} catch (ClassNotFoundException e1) {
				System.out.println("잘못된 타입입니다..");
			}
		}
		ois.close();  fis.close();
	} catch (FileNotFoundException e) {
		System.out.println("잘못된 파일이름을 입력했습니다.");
	}
 }
}