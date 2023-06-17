import java.util.*;

public class Dealer extends Player {
    
    private boolean reveal;

    public Dealer() {
        super("dealer");
        reveal = false;
    }

    public void revealFirstCard() {
        reveal = true;
    }

    public void printHand() {
        if (reveal) {
            super.printHand();
            System.out.println();
        }
        else {
            System.out.print("XX" + "  ");
            for (int i = 1; i < getNumCards(); i++) {
                System.out.print(getCard(i).toString() + "  ");
            }
            System.out.println();

        }
    }

    public boolean wantsHit(Scanner s, Player op) {
        boolean hit = false;

        if (op.getHandValue() > 21)
            return false;
        else if (op.getHandValue() < 17 && getHandValue() < op.getHandValue())
            hit = true;
        else if (op.getHandValue() >= 17 && !(getHandValue() < op.getHandValue()))
            hit = false;

        return hit;
    }

    public void discardCards() {
        reveal = false;
        super.discardCards();
    }
}
