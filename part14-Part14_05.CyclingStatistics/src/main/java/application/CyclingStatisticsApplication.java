package application;

import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CyclingStatisticsApplication extends Application {
    
    public static void main(String[] args) {
        Application.launch(CyclingStatisticsApplication.class);
    }

    @Override
    public void start(Stage primaryStage) {
        // Instantiate the CyclingStatistics by accessing the data in the file
        CyclingStatistics statistics = new CyclingStatistics("helsinki-cycling-statistics.csv");
        
        // Instantiate the GridPane and initialize its settings
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.add(new Label("Choose the examined location"), 0, 0);
        
        // Instantiate an ObservableList and add the locations from the CyclingStatistics to it
        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll(statistics.locations());
        
        // Instantiate a ListView from the ObservableList, then add it to the GridPane
        ListView<String> list = new ListView<>(data);
        gridPane.add(list, 0, 1);
        
        // Instantiate a CategoryAxis and a NumberAxis for the x- and y- axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year / Month");
        yAxis.setLabel("Cyclists");
        
        // Instantiate a BarChart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setLegendVisible(false);
                
        // Add event listeners
        list.setOnMouseClicked((MouseEvent event) -> {
            // Get the selected item's name
            String chosen = list.getSelectionModel().getSelectedItem();
            // Store the chosen location's information
            Map<String, Integer> values = statistics.monthlyCyclists(chosen);
            // Clear existing data
            barChart.getData().clear();
            // Instantiate XYChart.Series
            XYChart.Series chartData = new XYChart.Series();
            
            // For each date add a new data point
            values.keySet().stream()
                    .forEach(time -> {
                        chartData.getData().add(new XYChart.Data(time, values.get(time)));
            });
            
            // Update the chart
            barChart.getData().add(chartData);
        });
        
        // Add the BarChart to the GridPane
        gridPane.add(barChart, 1, 0, 1, 2);
        
        // Instantiate a Scene, set the Scene, and show
        Scene view = new Scene(gridPane);
        primaryStage.setScene(view);
        primaryStage.show();
    }
}
