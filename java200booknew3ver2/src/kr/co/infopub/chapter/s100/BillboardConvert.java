package kr.co.infopub.chapter.s100;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class BillboardConvert {
 public static BillbaordProperty toBill(Billbaord b){
	BillbaordProperty bp=new BillbaordProperty();
	bp.setRank(b.getRank());
	bp.setSong(b.getSong());
	bp.setArtist(b.getArtist());
	bp.setImagesrc(b.getImagesrc());
	bp.setLastweek(b.getLastweek());
	return bp;
 }
 public static ArrayList<BillbaordProperty>toBill(ArrayList<Billbaord> blist){
	ArrayList<BillbaordProperty> bplists=new ArrayList<>();
	for(Billbaord b:blist){
		bplists.add(toBill(b));
	}
	return bplists;
 } 
 public static ObservableList<BillbaordProperty> 
          toBillboard(ArrayList<BillbaordProperty> alists){
	ObservableList<BillbaordProperty> bList =
			FXCollections.observableArrayList(alists);
	return bList;
 }
 public static ObservableList<BillbaordProperty>
          toObservBill(ArrayList<Billbaord> alists){
	return toBillboard(toBill(alists));
 }	
 public static void main(String[] args) {
	RequestFromBillboardHot rfw=new RequestFromBillboardHot();
	//ImageFXListRequest  request=new ImageFXListRequest();
	String a="https://www.billboard.com/charts/hot-100/";
	String rs=rfw.getTimeDate(a);
	//rs=RestDay.toWantedDay(rs, 1); //count 1 : 1주흐
	rfw.getBillboardData(a+rs);
	//rfw.printBillboard();
	
	//빌보드의 이미지를 가져올 수 없도록 개편됨 2018-09-05
	ArrayList<Billbaord> bills=rfw.getBillboards();
	// 아쉽게도 이미지를 빌보드에서 이미지를 가져올수 없어서 이미지 관련을 주석처리했다.
	//request.getAllImages(bills);  //image
	ObservableList<BillbaordProperty> obsbills= 
			           BillboardConvert.toObservBill(bills);
	for(BillbaordProperty bp: obsbills){
		System.out.println(bp);
	}
 }
}
