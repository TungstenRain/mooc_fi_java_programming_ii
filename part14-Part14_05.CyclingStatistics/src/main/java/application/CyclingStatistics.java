package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CyclingStatistics {
    // Variables
    private List<String> rows;
    
    // Constructor
    /**
     * Construct the CyclingStatistics from the given file
     * @param file String: the file name
     */
    public CyclingStatistics(String file) {
        try {
            rows = Files.lines(Paths.get(file)).collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException ex) {
            throw new RuntimeException("Failed to read the file " + file + ". Error message: " + ex.getMessage());
        }
    }
    
    // Methods
    /**
     * Return a list of locations
     * @return List<String>: the list of locations
     */
    public List<String> locations() {
        List<String> locations = Arrays.stream(rows.get(0).split(";")).collect(Collectors.toList());
        return locations.subList(1, locations.size());
    }
    
    /**
     * Get a Map of the monthly cyclists
     * @param location String: the location to get the Map
     * @return Map<String, Integer>: the Map of monthly cyclists
     */
    public Map<String, Integer> monthlyCyclists(String location) {
        List<String> locations = locations();
        if (locations.indexOf(location) < 0) {
            return new HashMap<>();
        }
        
        Map<String, List<Integer>> monthlyValues = new TreeMap<>();
        
        int index = locations.indexOf(location) + 1;
        rows.stream()
                .map(string -> string.split(";"))
                .filter(array -> array.length > 10)
                .forEach(array -> {
                    String[] dateArray = array[0].split(" ");
                    if (dateArray.length < 3) {
                        return;
                    }
                    
                    String month = dateArray[3] + " / " + stringToMonthNumber(dateArray[2]);
                    
                    monthlyValues.putIfAbsent(month, new ArrayList<>());
                    
                    int count = 0;
                    if (!array[index].isEmpty()) {
                        count = Integer.parseInt(array[index]);
                    }
                    
                    monthlyValues.get(month).add(count);
                });
        
        Map<String, Integer> cyclistCounts = new TreeMap<>();
        monthlyValues.keySet().stream().forEach(value -> {
            cyclistCounts.put(value, monthlyValues.get(value).stream().mapToInt(a -> a).sum());
        });
        
        return cyclistCounts;
    }
    
    /**
     * Convert the month name to its numerical value (e.g., January -> 01, February -> 02, etc.)
     * @param month String: the month in word form
     * @return String: the month in number form
     */
    private String stringToMonthNumber(String month) {
        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        int number = months.indexOf(month) + 1;

        if (number < 10) {
            return "0" + number;
        }

        return Integer.toString(number);
    }
}
