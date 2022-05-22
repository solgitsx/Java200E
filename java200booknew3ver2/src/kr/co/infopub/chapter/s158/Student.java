package kr.co.infopub.chapter.s158;
import java.io.Serializable;
public class Student implements Cloneable, Serializable{
	private static final long serialVersionUID=12234214234L;
	private String name;
	private int age;
	private String addr;
	
	public Student(String name, int age,String addr) {
		this.name=name;
		this.age=age;
		this.addr=addr;
	}//Student
	public String getAddr() {return addr;}
	public int getAge() {return age;}
	public String getName() {return name;}
	public void setAddr(String string) {addr = string;}
	public void setAge(int i) {age = i;}
	public void setName(String string) {name = string;}
	public String toString(){
		return name+"   "+age+"    "+addr;
	}//toString
	public Object clone(){ // 멤버가 기본타입과 String으로만 구성
		try{
			return super.clone();
		}catch(CloneNotSupportedException e){
			return this;
		}
	}//clone
	public boolean equals(Object obj){ // 멤버비교 같은객체
		boolean isE=false;
		Student temp=(Student)obj;
		if(temp.getName().equals(name) && temp.getAge()==age
			&& temp.getAddr().equals(addr)){
			isE=true;
		}
		return isE;
	}//equals
	public int hashCode(){
		int temp=0;
		temp=name.hashCode()+addr.hashCode()+age+37;
		return temp;
	}//hashCode
}
