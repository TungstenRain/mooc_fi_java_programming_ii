
public class Program {

    public static void main(String[] args) {
        MagicSquareFactory msFactory = new MagicSquareFactory();
        MagicSquare testSquare = msFactory.createMagicSquare(7);
        System.out.println(testSquare);
    }
}
