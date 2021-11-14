package application;


import logic.SavingsCalculator;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Comparator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
    // Variables
    private SavingsCalculator calculatorLogic;
    
    // Constructors
    public SavingsCalculatorApplication() {
        this.calculatorLogic = new SavingsCalculator();
    }
    
    public static void main(String[] args) {
        Application.launch(SavingsCalculatorApplication.class);
    }
    
    // Methods
    /**
     * Round the double to a two-digit format
     * @param valueToRound double: the number to round
     * @return String: the number in a String format
     */
    private String roundDouble(Double valueToRound) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(valueToRound.doubleValue());
    }
    
    /**
     * Generate the monthly savings data
     * @param monthlySavings Double: the monthly savings
     */
    private void generateMonthlySavingsData(Double monthlySavings) {
        calculatorLogic.setMonthlySavings(monthlySavings);
        calculatorLogic.calculateYearlyAmountNoRates();
    }
    
    /**
     * Generate the annual interest rate data
     * @param monthlySavings Double: the monthly savings
     * @param anualInterestRate Double: the annual interest rate
     */
    private void generateAnnualInterestRateData(Double monthlySavings, Double anualInterestRate) {
        if (calculatorLogic.getMonthlySavings() != monthlySavings) {
            calculatorLogic.setMonthlySavings(monthlySavings);
            calculatorLogic.calculateYearlyAmountNoRates();
        }
        calculatorLogic.setYearlyInterestRate(anualInterestRate);
        calculatorLogic.calculateYearlyAmountWithRates();
    }
    
    /**
     * Transform the data into a graphic for the monthly savings data to be displayed to the user
     * @return XYChart.Series: the graphic to display
     */
    private XYChart.Series transformDataIntoGraphicForMonthlySavingsData() {
        XYChart.Series dataMonthlySavings = new XYChart.Series();
        dataMonthlySavings.setName("Monthly Savings");
        calculatorLogic.getNextYearsAmountNoRates().entrySet().forEach(entry -> dataMonthlySavings.getData().add(new XYChart.Data(entry.getKey(), entry.getValue())));
        return dataMonthlySavings;
    }
    
    /**
     * Transform the data into a graphic for the annual interest rate data to be displayed to the user
     * @return XYChart.Series: the graphic to display
     */
    private XYChart.Series transformDataIntoGraphicForAnnualInterestRateData() {
        calculatorLogic.calculateYearlyAmountWithRates();
        XYChart.Series dataYearlyInterestRate = new XYChart.Series();
        dataYearlyInterestRate.setName("Savings with interest rate");
        calculatorLogic.getNextYearsAmountWithRates().entrySet().forEach(entry -> dataYearlyInterestRate.getData().add(new XYChart.Data(entry.getKey(), entry.getValue())));
        return dataYearlyInterestRate;
    }
    
    /**
     * Create the LineChart graphic
     * @return LineChart<Number, Number>: the graphic
     */
    private LineChart<Number, Number> createGraphic() {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 10000, 2500);
        xAxis.setLabel("Years");
        yAxis.setLabel("Savings");
        LineChart<Number, Number> graphic = new LineChart<>(xAxis, yAxis);
        graphic.setTitle("Savings counter");
        generateMonthlySavingsData(25.0);
        generateAnnualInterestRateData(25.0, 0.0);
        graphic.getData().add(transformDataIntoGraphicForMonthlySavingsData());
        graphic.getData().add(transformDataIntoGraphicForAnnualInterestRateData());

        return graphic;
    }
    
    /**
     * Update the LineChart graphic
     * @param graphic LineChart<Number, Number>: the graphic to update
     * @param monthlySavings XYChart.Series: the monthly savings
     * @param annualInterestRate XYChart.Series: the annual interest rate
     * @return LineChart<Number, Number>: the LineChart graphic
     */
    private LineChart<Number, Number> updateGraphic(LineChart<Number, Number> graphic, XYChart.Series monthlySavings, XYChart.Series annualInterestRate) {
        Double maxValueForTheYAxis = calculatorLogic.getNextYearsAmountWithRates().values().stream().max(Comparator.comparing(Double::doubleValue)).orElse(0.0);
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, maxValueForTheYAxis, maxValueForTheYAxis / 10);
        xAxis.setLabel("Years");
        yAxis.setLabel("Savings");

        graphic = new LineChart<>(xAxis, yAxis);
        graphic.setTitle("Savings counter");

        graphic.getData().clear();
        graphic.getData().add(monthlySavings);
        graphic.getData().add(annualInterestRate);
        return graphic;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate the LineChart, BorderPane, and VBox
        LineChart<Number, Number> lineChart = createGraphic();
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(lineChart);
        VBox vBoxSliders = new VBox();
        
        // Instantiate the BorderPane for the monthly savings, and the slider
        BorderPane borderPaneMonthlySavings = new BorderPane();
        borderPaneMonthlySavings.setPadding(new Insets(20, 20, 20, 20));
        Label labelMonthlySavingAmountDisplay = new Label("25.0");
        Slider monthlySavingSlider = new Slider(25, 250, 25);
        monthlySavingSlider.setShowTickLabels(true);
        monthlySavingSlider.setShowTickMarks(true);
        borderPaneMonthlySavings.setLeft(new Label("Monthly savings"));
        borderPaneMonthlySavings.setCenter(monthlySavingSlider);
        borderPaneMonthlySavings.setRight(labelMonthlySavingAmountDisplay);
        
        // Add event listeners to the Slider
        monthlySavingSlider.valueProperty().addListener((changed, oldValue, newValue) -> labelMonthlySavingAmountDisplay.setText(roundDouble(newValue.doubleValue())));
        monthlySavingSlider.setOnMouseReleased(dragOver -> {
            generateMonthlySavingsData(monthlySavingSlider.getValue());
            mainLayout.setCenter(updateGraphic(lineChart, transformDataIntoGraphicForMonthlySavingsData(), transformDataIntoGraphicForAnnualInterestRateData()));
        });
        
        // Instantiate the BorderPane for the annual interest rate, and the slider
        BorderPane borderPaneAnnualInterestRate = new BorderPane();
        borderPaneAnnualInterestRate.setPadding(new Insets(20, 20, 20, 20));
        Label labelAnnualInterestRateAmountDisplay = new Label("0.0");
        Slider anualInterestRateSlider = new Slider(0, 10, 0);
        anualInterestRateSlider.setShowTickMarks(true);
        anualInterestRateSlider.setShowTickLabels(true);
        borderPaneAnnualInterestRate.setLeft(new Label("Yearly interest rate"));
        borderPaneAnnualInterestRate.setCenter(anualInterestRateSlider);
        borderPaneAnnualInterestRate.setRight(labelAnnualInterestRateAmountDisplay);
        
        // Add event listeners to the Slider
        anualInterestRateSlider.valueProperty().addListener((changed, oldValue, newValue) -> labelAnnualInterestRateAmountDisplay.setText(roundDouble(newValue.doubleValue())));
        anualInterestRateSlider.setOnMouseReleased(dragOver -> {
            generateAnnualInterestRateData(monthlySavingSlider.getValue(), anualInterestRateSlider.getValue());
            mainLayout.setCenter(updateGraphic(lineChart, transformDataIntoGraphicForMonthlySavingsData(), transformDataIntoGraphicForAnnualInterestRateData()));
        });
        
        // Add objects to the VBox
        vBoxSliders.getChildren().addAll(borderPaneMonthlySavings, borderPaneAnnualInterestRate);
        
        // Add the VBox to the main layout
        mainLayout.setTop(vBoxSliders);
        
        // Instantiate the Scene, set the Scene, and show
        Scene view = new Scene(mainLayout, 800, 600);
        primaryStage.setTitle("Savings calculator application");
        primaryStage.setScene(view);
        primaryStage.show();
    }
}
