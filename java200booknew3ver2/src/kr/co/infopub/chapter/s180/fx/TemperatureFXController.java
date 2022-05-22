package kr.co.infopub.chapter.s180.fx;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class TemperatureFXController {
 @FXML
 private Slider cdegree;
 @FXML
 private Slider fdegree;
 @FXML
 private Label lbdegree;
 @FXML
 void initialize() {
	cdegree.valueProperty().addListener(new ChangeListener<Number>() {
         public void changed(ObservableValue<? extends Number> ov,
             Number old_val, Number new_val) {
                 System.out.println("C->F:"+new_val.doubleValue());
                 double cval=new_val.doubleValue();
                 double fval=TemperatureConv.toFahrenheit(cval);
                 String sf=String.format("섭씨 %.2f도 =\n\n화씨 %.2f도.",
                		 cval,fval);		
                 next(cval);
                 fdegree.setValue(fval);		 
                 lbdegree.setText(sf);
         }
     });
	fdegree.valueProperty().addListener(new ChangeListener<Number>() {
	    public void changed(ObservableValue<? extends Number> ov,
	        Number old_val, Number new_val) {
	            System.out.println("F->C:"+new_val.doubleValue());
	            double fval=new_val.doubleValue();
	            double cval=TemperatureConv.toCelsius(fval);
                String sf=String.format("화씨 %.2f도 =\n\n섭씨 %.2f도 .",
                		fval,cval);		
                back(fval);
                cdegree.setValue(cval);		 
                lbdegree.setText(sf);
           }
    });
 }
 // 수학자표와 그래프 좌표 차이
 static double height=412;
 void next(double cval){
	Image image = new Image(getClass().getResourceAsStream("gogo.png"));
	lbdegree.setGraphic(new ImageView(image));
	lbdegree.setTranslateY(-height*cval/100);
 }
 void back(double fval){
	Image image = new Image(getClass().getResourceAsStream("gogo.png"));
	lbdegree.setGraphic(new ImageView(image));
	lbdegree.setTranslateY(-height*(fval-32)/180);
 }
}
