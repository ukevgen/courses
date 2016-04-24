package useJavaFx;

import javafx.application.Application;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

import java.util.Random;


/**
 * Created by Администратор on 24.04.2016.
 */
public class MainFrame extends Application {

    private BarChart bc;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    @Override
    public void start(Stage stage) throws Exception {


       // bc.getData().add(series1);
        diagramSeting();
        stage.show();
    }


    private void diagramSeting() {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis(0, 50, 10);
        bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setPrefSize(400, 200);
        bc.setLegendVisible(false);
        bc.setAnimated(false);
        bc.setBarGap(0);
        bc.setCategoryGap(1);
        bc.setVerticalGridLinesVisible(false);
        bc.setHorizontalGridLinesVisible(false);
        xAxis.setLabel("Частота");
        yAxis.setLabel("Мощность");
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, null, "dB"));
    }

    private Number[] creatArr() {
        Random random = new Random();
        Number arr[] = new Number[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }


}
