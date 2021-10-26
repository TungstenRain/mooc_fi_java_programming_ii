

public class Card implements Comparable<Card> {
    // Variables
    private int value;
    private Suit suit;
    
    // Constructor
    /**
     * Construct the Card
     * @param value int: the value of the card
     * @param suit Suit: the Suit of the card
     */
    public Card(int value, Suit suit) {
        if (value < 2 || value > 14) {
            throw new IllegalArgumentException("Card value must be in range 2...14.");
        }

        this.value = value;
        this.suit = suit;
    }
    
    // Methods
    /**
     * Get the value of the card
     * @return int: the value
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Get the Suit of the card
     * @return Suit: the suit
     */
    public Suit getSuit() {
        return suit;
    }
    
    @Override
    /**
     * Return a String in the following format:
     * [suit] [card value]
     */
    public String toString() {
        String cardValue = "" + value;
        if(value == 11) {
            cardValue = "J";
        } else if (value == 12) {
            cardValue = "Q";
        } else if (value == 13) {
            cardValue = "K";
        } else if (value == 14) {
            cardValue = "A";
        }
        
        return suit + " " + cardValue;
    }

    @Override
    public int compareTo(Card compared) {
        if (this.value > compared.getValue()) {
            return 1;
        } else if (this.value < compared.getValue()) {
            return -1;
        } else {
            if (this.suit.ordinal() > compared.getSuit().ordinal()) {
                return 1;
            } else if (this.suit.ordinal() < compared.getSuit().ordinal()) {
                return -1;
            }
            return 0;
        }
    }
}
