package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.Map;


public class PartiesApplication extends Application {

    public static void main(String[] args) {
        Application.launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate the NumberAxis objects for the x- and y- axes
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        // Set the title for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative Support (%)");
        
        // Instantiate the LineChart and set title
        LineChart<Number, Number> lineChart = new  LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        // Intantiate the Map containing all the values from the PartyData
        Map<String, Map<Integer, Double>> values = PartyData.readFile("partiesdata.tsv");
        
        // Add each party to the chart
        values.keySet()
                .stream()
                .forEach(party -> {
                    // Instantiate a new DataSet for each party
                    XYChart.Series data = new XYChart.Series();
                    data.setName(party);
                    
                    values.get(party).entrySet()
                            .stream()
                            .forEach(pair -> {
                                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                            });
                    lineChart.getData().add(data);
                });
        
        // Instantiate Scene, set Scene, and show
        Scene view = new Scene(lineChart, 640, 400);
        primaryStage.setScene(view);
        primaryStage.show();
    }
}
