/**
 * Hand Class for Part10_17
 * @author frank
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {
    // Variables
    private ArrayList<Card> cards;
    
    // Constructors
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    // Methods
    /**
     * Add a Card to the Hand
     * @param card Card: the Card to add
     */
    public void add(Card card) {
        this.cards.add(card);
    }
    
    /**
     * Print all the Cards in the Hand
     */
    public void print() {
        this.cards.stream()
                .forEach(card -> System.out.println(card));
    }
    
    /**
     * Get the sum of the Cards in the Hand
     * @return int: the sum of the Cards
     */
    public int sum() {
        return this.cards.stream()
                .map(card -> card.getValue())
                .reduce(0, (subtotal, nextCard) -> subtotal + nextCard);
    }
    
    /**
     * Sort the Cards in the Hand
     */
    public void sort() {
        Collections.sort(cards, (c1, c2) -> c1.compareTo(c2));
    }
    
    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }

    @Override
    /**
     * Compare this Hand to another Hand
     * @param Hand: the Hand to compare to
     * @return int: 1 if this Hand is greater than; 0 if they are equal; -1 if this Hand is less than
     */
    public int compareTo(Hand compared) {
        if (this.sum() > compared.sum()) {
            return 1;
        }
        if (this.sum() == compared.sum()) {
            return 0;
        }
        return -1;
    }
}
