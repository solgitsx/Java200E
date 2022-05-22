package kr.co.infopub.chapter.s160;
import java.util.List;
public class ProductReaderMain {
 public static void main(String[] args) {
	ProductReader kr=new ProductReader();
	ProductList plist=new ProductList();
	if(kr.isExist("kisul\\abc3031.txt")){
		kr.readTexts("kisul\\abc3031.txt");
		int num=kr.listSize();
		System.out.println("데이타 개수: "+num);
		System.out.println("AllDatas===>");
		List<Product> producst=plist.getAllProducts(kr.getAllLines());
		int tot=0;
		for (Product p: producst) {
			System.out.println((++tot)+"\t"+p);
		}
		System.out.println("Grad in A or C===>");
		//String pGrade;    // 제조등급 문자 1 마지막 문자
		String [] acc={"A","C"};
		List<Product> gradepros=plist.getAllProdInGrade(acc,producst);
		int tot2=0;
		for (Product p: gradepros) {
			System.out.println((++tot2)+"\t"+p);
		}
		System.out.println("Sort ===>");
		gradepros.sort(new ProductComp());
		tot2=0;
		for (Product p: gradepros) {
			System.out.print((++tot2)+"\t"+p);
			// 감소 감소 증가
			System.out.println("\tpMoney="+p.getPMoney()+
				"\tpPoint="+p.getPPoint()+"\tprodNum="+p.getProdNum());
		}
		// 5번의    정보를 춢력
		Product result=gradepros.get(4);
	    String msgs=String.format("%s\t%s\t%s", 
	    	result.getPMoney(),result.getPPoint(),result.getProdNum()) ;
	    //System.out.println(msgs);
		ResultWrite rw=new ResultWrite();
		System.out.println(rw.isExist("kisul\\Ans1.txt"));
		rw.setTexts("kisul\\Ans1.txt",msgs);
		String krs=kr.readText("kisul\\Ans1.txt");
		System.out.println(krs);
	}
 }
}
