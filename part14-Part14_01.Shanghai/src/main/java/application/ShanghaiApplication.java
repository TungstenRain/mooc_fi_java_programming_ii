package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        Application.launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate the NumberAxis objects for the x- and y- axes
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        
        // Set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        // Instantiate the LineChart and set title
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        
        // Instantiate the XYChart (data set) to be added to the LineChart
        XYChart.Series rankingData = new XYChart.Series();
        rankingData.setName("University of Helsinki");
        
        // Add single points into the data set
        rankingData.getData().add(new XYChart.Data(2007, 73));
        rankingData.getData().add(new XYChart.Data(2008, 68));
        rankingData.getData().add(new XYChart.Data(2009, 72));
        rankingData.getData().add(new XYChart.Data(2010, 72));
        rankingData.getData().add(new XYChart.Data(2011, 74));
        rankingData.getData().add(new XYChart.Data(2012, 73));
        rankingData.getData().add(new XYChart.Data(2013, 76));
        rankingData.getData().add(new XYChart.Data(2014, 73));
        rankingData.getData().add(new XYChart.Data(2015, 67));
        rankingData.getData().add(new XYChart.Data(2016, 56));
        rankingData.getData().add(new XYChart.Data(2017, 56));
        
        // Add data set to the LineChart
        lineChart.getData().add(rankingData);
        
        // Instantiate the Scene, set the Scene, and show
        Scene view = new Scene(lineChart, 640, 400);
        primaryStage.setScene(view);
        primaryStage.show();
    }

}
