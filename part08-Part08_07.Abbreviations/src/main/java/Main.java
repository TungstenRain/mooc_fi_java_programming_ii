
public class Main {

    public static void main(String[] args) {
        // Instantiate Abbreviations
        Abbreviations abbreviation = new Abbreviations();
        
        // Add to the Abbreviations
        abbreviation.addAbbreviation("e.g.", "for example");
        abbreviation.addAbbreviation("etc.", "and so on");
        abbreviation.addAbbreviation("i.e.", "more precisely");
        
        // Initialize variable
        String text = "e.g. i.e. etc. lol";
        
        // Find the explanation and print it
        for (String string : text.split(" ")){
            if(abbreviation.hasAbbreviation(string)) {
                string = abbreviation.findExplanationFor(string);
            }
            
            System.out.print(string);
            System.out.print(" ");
        }
        System.out.println();
    }
}
