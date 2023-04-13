package A1;

import java.util.*;

public class Player extends User {
    private int chips;
    protected ArrayList<Card> cardOnHand;

    public Player(String username, String password, int chips){
        super(username, password);
        this.chips = chips;
        this.cardOnHand = new ArrayList<Card>();
    }

    public void winChips(int amount){
        chips+=amount;
    }

    public void loseChips(int amount){
        chips-=amount;
    }

    public void addCard(Card card){
        cardOnHand.add(card);
    }
    public ArrayList<Card> getCardOnHand(){
        return this.cardOnHand;
    }
    public void showCardOnHand(){
        System.out.println(getUsername());
        for(Card c : this.cardOnHand){
            System.out.println(c);
        }
        System.out.println();
    }

    public int getTotalCardsValue(){
        int total=0;
        for(Card c : this.cardOnHand){
           total += c.getValue();
        }
        return total;
    }

    public void showTotalCardsValue(){
       System.out.println("Total Value: "+ getTotalCardsValue());
    }


    public static void main(String[] args) {
        Player p1 = new Player("Mario", "123", 100);
        Deck d1 = new Deck();
        d1.shuffleCard();
        Card c1 = d1.drawCard();
        Card c2 = d1.drawCard();
        Card c3 = d1.drawCard();
        p1.addCard(c1);
        p1.addCard(c2);
        p1.addCard(c3);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        p1.getCardOnHand();
        p1.showCardOnHand();
        p1.getTotalCardsValue();
        p1.showTotalCardsValue();


    }


}