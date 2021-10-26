

public class MainProgram {

    public static void main(String[] args) {
        Checker checker = new Checker();
        
        System.out.println("This is to check if the following is true or false");
        String day = "mon";
        System.out.println(checker.isDayOfWeek(day));
        
        String notADay = "blah";
        System.out.println(checker.isDayOfWeek(notADay));
        
        String allVowels = "aeiouaeiouaiuoe";
        System.out.println(checker.allVowels(allVowels));
        
        String notAllVowels = "saturday";
        System.out.println(checker.allVowels(notAllVowels));
        
        System.out.println(checker.timeOfDay("12:13:14"));
        System.out.println(checker.timeOfDay("33:33:33"));
        System.out.println(checker.timeOfDay("23:33:33"));
        System.out.println(checker.timeOfDay("24:33:33"));
    }
}
