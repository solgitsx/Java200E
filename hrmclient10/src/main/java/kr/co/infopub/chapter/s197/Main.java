package kr.co.infopub.chapter.s197;
	
import java.util.Date;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import kr.co.infopub.chapter.s197.model.EmployeeService;
import kr.co.infopub.chapter.s197.util.PTS;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane root;
	String systemver="HR Information System ver.1.0";
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle(systemver);
		this.primaryStage=primaryStage;
        //---------------소스 분리 시킴
		showHR();
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){

        // Window X 이용하기-------------------------------
		@Override
		public void handle(WindowEvent event) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle(systemver);
	        alert.setHeaderText("인사관리 시스템("+PTS.toDate3(new Date())+")을 끝내시겠습니까?");
	    	alert.setContentText("정말 끝내시겠습니까?");
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    		Platform.exit();
	    		//System.exit(0);
	    	} else if(result.get() == ButtonType.CANCEL) { 
	    		event.consume(); 
	    	}
		}});  //---------------------------
	}
	
	public void showHR() {
		try {
			EmployeeService service=EmployeeService.getInstance(); //DB 준비
			 
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/MainHrFX.fxml"));
	        root = (BorderPane) loader.load();
	        MainHrFXController empcon=loader.getController();
	        //------여기에 소스 추가
	        DepartmentController departView=new DepartmentController(service);
	        ManagerFxController emptvView=new ManagerFxController(service);
            EmployeeSearchFxController empsearchView=new EmployeeSearchFxController(service);      
            EmployUpdateFxController empupdateView=new EmployUpdateFxController(service); 
            PieChartController piecharview=new PieChartController(service); 
            
            //------------------
            empcon.setView1(departView);
            empcon.setView2(emptvView);
            empcon.setView(empsearchView);
            empcon.setView3(empupdateView);
            empcon.setView4(piecharview);
            
	        //------여기에 소스 추가
			Scene scene = new Scene(root,1250,880);
			scene.getStylesheets().add(Main.class.getResource("view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			primaryStage.setOnCloseRequest(e -> {
	        	System.out.println("Close primaryStage !!!");
	        });
		} catch(Exception e) {
			System.out.println(" start에서 Error : "+e);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
