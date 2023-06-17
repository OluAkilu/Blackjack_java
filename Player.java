import java.util.*;

public class Player {
    
    private String name;
    private Card[] hand = new Card[Blackjack.MAX_CARDS_PER_PLAYER];
    private int numCards = 0;

    public Player (String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public int getNumCards() {
        return numCards;
    }

    public String toString() {
        return name;
    }

    public void addCard(Card c) {
        if (c == null || numCards > hand.length)
            throw new IllegalArgumentException();
        else {
            hand[numCards] = c;
            numCards++;
        }
    }

    public Card getCard(int index) {
        if (hand[index] == null)
            throw new IllegalArgumentException();
        else
            return hand[index];
    }

    public int getHandValue() {
        int total = 0;
        int aces = 0;

        for (int i = 0; i < numCards; i++){
            if (hand[i].getValue() == 1 && aces == 0 && total <= 10) {
                total += 11;
                aces++;
            }
            else {
                total += hand[i].getValue();
            }
        }

        return total;
    }

    public void printHand() {
        for (int i = 0; i < numCards; i++) {
            System.out.print(hand[i].toString() + "  ");
        }

        System.out.print("(value = " + getHandValue() + ") ");
    }

    public boolean hasBlackjack() {
        return (getHandValue() == 21);
    }

    public boolean wantsHit(Scanner scan, Player opponent) {
        System.out.print("Want another hit, " + name + "? ");
        String response = scan.nextLine();

        if (response.toUpperCase().equals("Y"))
            return true;
        else
            return false;
    }

    public void discardCards() {
        for (int i = 0; i < hand.length; i++) {
            hand[i] = null;
        }
        numCards = 0;
    }
}