

public class Card {
    private int rank;
    private char suit;

    /* constants for the ranks of non-numeric cards */
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    
    /* other constants for the ranks */
    public static final int FIRST_RANK = 1;
    public static final int LAST_RANK = 13;
    
    /* 
     * class-constant array containing the string representations
     * of all of the card ranks. 
     * The string for the numeric rank r is given by RANK_STRINGS[r].
     */
    public static final String[] RANK_STRINGS = {
      null, "A", "2", "3", "4", "5", "6",
      "7", "8", "9", "10", "J", "Q", "K"
    };
    
    /* 
     * class-constant array containing the char representations
     * of all of the possible suits.
     */
    public static final char[] SUITS = {'C', 'D', 'H', 'S'};

    
    /* Put the rest of the class definition below. */
    public Card(int cardRank, char cardSuit) { //constructor 1
      if (cardRank < 1 || cardRank > 13) 
        throw new IllegalArgumentException();
      else {
        rank = cardRank;
      }

      if (isValidSuit(cardSuit))
        suit = cardSuit;
      else
        throw new IllegalArgumentException();
    }

    public Card (String info) {
      if (info.length() < 2 || info.length() > 3) 
        throw new IllegalArgumentException();
      
      if (rankNumFor(info.substring(0, info.length() - 1)) != -1)
        rank = rankNumFor(info.substring(0, info.length() - 1));
      else
        throw new IllegalArgumentException();
      
      if (isValidSuit(info.charAt(info.length() - 1)))
        suit = info.charAt(info.length() - 1);
      else
        throw new IllegalArgumentException();
    }

    public static int rankNumFor(String s) {
      if (s == null) {
        return -1;
      }
      else {
        for (int i = RANK_STRINGS.length - 1; i > 0; i--) {
          if (s.equals(RANK_STRINGS[i]))
              return i;
        }  
      }

    return -1;
  }

    public static boolean isValidSuit(char c) {
      for (int i = 0; i < SUITS.length; i++) {
        if (c == SUITS[i]) 
          return true;
      }

      return false;
    }

    public int getRank() {
      return rank;
    }

    public char getSuit() {
      return suit;
    }

    public boolean isAce() {
      return (rank == ACE);
    }

    public boolean isFaceCard() {
      if (rank == JACK || rank == QUEEN || rank == KING) 
        return true;
      else
        return false;
    }

    public int getValue() {
      if (isFaceCard())
        return 10;
      else
        return rank;
    }

    public String toString() {
      return RANK_STRINGS[rank] + suit;
    }

    public boolean sameSuitAs(Card other) {
      if (other == null)
        return false;
      else
        return (suit == other.getSuit());
    }

    public boolean equals(Card other) {
      if (other == null)
        return false;
      else
        return (rank == other.getRank() && suit == other.getSuit());
    }
    public static void main(String[] args) {

    }
}
