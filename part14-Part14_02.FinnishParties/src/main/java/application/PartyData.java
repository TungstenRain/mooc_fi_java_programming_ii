package application;

/**
 * PartyData Class for Part14_02
 * @author frank
 */

import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;


public class PartyData {
    // Methods
    public static Map<String, Map<Integer, Double>> readFile(String fileName) {
        // Instantiate Map and ArrayList
        Map<String, Map<Integer, Double>> partyData = new HashMap<>();
        ArrayList<Integer> years = new ArrayList<>();
        
        try (Scanner reader = new Scanner(Paths.get(fileName))) {
            // Get the header row information
            String row = reader.nextLine();
            String[] parts = row.split("\t");
            for (int i = 1; i < parts.length; i++) {
                years.add(Integer.valueOf(parts[i]));
            }
            
            while (reader.hasNext()) {
                row = reader.nextLine();
                parts = row.split("\t");
                String party = parts[0];
                
                // Instantiate Map for each party
                Map<Integer, Double> data = new HashMap<>();
                
                for (int i = 1; i < parts.length; i++) {
                    if (!parts[i].equals("-")) {
                        int year = years.get(i-1);
                        double rating = Double.valueOf(parts[i]);
                        
                        data.put(year, rating);
                    }
                }
                partyData.put(party, data);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return partyData;
    }
}
