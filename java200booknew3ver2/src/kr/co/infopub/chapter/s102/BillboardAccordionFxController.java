package kr.co.infopub.chapter.s102;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;  
import javafx.scene.control.Button;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
public class BillboardAccordionFxController {
 @FXML
 private Accordion baccordina;
 @FXML
 private TreeView<String> youtrv;
 @FXML
 private WebView webview;
 ObservableList<BillbaordProperty> obsbills;
 @FXML
 private Button btnAf;
 @FXML
 private Button btnBf;
 @FXML
 private Label lbbill;
 TreeItem<String> root = new TreeItem<String>("Singer ");
 int count=0;
 @FXML
 void onClickBtnBf(ActionEvent event) {
	count++;
	baccordina.getPanes().clear(); //페인에 붙은 것들 제거 후
	getAllBillboard();  //다시 불러서
	showAllBillboard(); //붙임
 }
 @FXML
 void onClickBtnAf(ActionEvent event) {
	count=0;
	baccordina.getPanes().clear();//페인에 붙은 것들 제거 후
	getAllBillboard();  //다시 불러서
	showAllBillboard(); //붙임
 }
 @FXML
 void initialize() {
	getAllBillboard();
	showAllBillboard();
	youtrv.getSelectionModel().selectedItemProperty().addListener(
		(observable, oldValue, newValue) -> {
			if(newValue!=null){
				final WebEngine webEngine = webview.getEngine();
				//https://www.youtube.com/watch?v=%s 수정
				String ttt=String.format("https://www.youtube.com/results?search_query=%s",
						           ((TreeItem<String>)newValue).getValue());
				webEngine.load(ttt);
			}
		});
	youtrv.setRoot(root);
 }
 public void loadTreeItems(String key){
	root.getChildren().clear();
	TreeItem<String> abs = new TreeItem<String>(key);
	root.getChildren().add(abs);
	root.setExpanded(true);
 }
 public void getAllBillboard(){
	RequestFromBillboardHot rfw=new RequestFromBillboardHot();
	//RequestFromBillboard200 rfw=new RequestFromBillboard200();
	//String a="https://www.billboard.com/charts/billboard-200/";
	String a="https://www.billboard.com/charts/hot-100/";
	String rs=rfw.getTimeDate(a);
	rs=RestDay.toWantedDay(rs, count); //count 주 이전
	rfw.getBillboardData(a+rs);
	ArrayList<Billbaord> bills=rfw.getBillboards();
    obsbills= BillboardConvert.toObservBill(bills);
    lbbill.setText("Billboard Chat HOT 100 "+rs);
 }
 public String toP(String msg){
    String ss=msg;
    ss=ss.replaceAll(" ", "+");
    return ss.trim();
 }
 public void showAllBillboard(){
	if(obsbills!=null){
		for(BillbaordProperty bp: obsbills){
			TitledPane mytitle = new TitledPane();
			mytitle.setText(bp.getSong());
    		mytitle.setOnMouseClicked(event -> {
    			if(mytitle.getText()!=null || mytitle.getText().indexOf(".")!=-1 ){
    				System.out.println(mytitle.getText()+"2----------------->>>");//ok
        			loadTreeItems(toP(mytitle.getText()));
    			}
            });
    		baccordina.getPanes().add(mytitle);
		}
	}
 }
}
