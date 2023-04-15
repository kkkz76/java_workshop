package A1;

import java.util.*;
public class Deck {
    
    private ArrayList<Card>cards;
    private String[] suits = {"Diamonds","Clubs","Hearts","Spades"};
   
    public  Deck(){

        cards = new ArrayList<Card>();
        for(int i = 0; i < suits.length ;i++){
        String suit = suits[i];
        String name;
        int value;
        int realValue;
            for (int j = 1; j <=13 ; j++){
                switch (j){
                    case 1:
                        name = "Ace";
                        value = 1;
                        realValue =1;
                        break;
                    case 11:
                        name = "Jack";
                        value = 10;
                        realValue = 11;
                        break;       
                    case 12:
                        name = "Queen";
                        value = 10;
                        realValue = 12;
                        break;
                    case 13:
                        name = "King";
                        value = 10;
                        realValue = 13;
                        break;                  
                    default:
                        name = String.valueOf(j);
                        value = j;
                        realValue = j;
                    
                }
                Card card = new Card(suit,name,value,realValue);
                cards.add(card);
             }
        }
    }

    public void shuffleCard(){
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int indexA = random.nextInt(cards.size());
            int indexB = random.nextInt(cards.size());
            Card cardA = cards.get(indexA);
            Card cardB = cards.get(indexB);
            cards.set(indexA, cardB);
            cards.set(indexB, cardA);
        }
    }
    public void showDeck(){
        for(Card c : cards){
            System.out.println(c);
        }
    }
    public Card drawCard(){
        return cards.remove(0);
    }
    public void appendCard(ArrayList<Card> cards) {
        for (Card c : cards) {
            this.cards.add(c);
        }
    }
    public int getSuitIndex(String suit){
        return Arrays.asList(suits).indexOf(suit);
    }
    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public static void main(String[] args) {
        Deck d1 = new Deck();
        d1.showDeck();
        d1.shuffleCard();
        d1.showDeck(); 
        Card c1 = d1.drawCard();
        System.out.println();
        System.out.println("Draw Card"+c1);
        System.out.println("Suit Level: " + d1.getSuitIndex(c1.getSuite()));
        System.out.println("real Level: " + c1.getRealValue());
        System.out.println();
        Card c2 = d1.drawCard();  
        System.out.println("Draw Card"+c2);
        System.out.println("Suit Level: " + d1.getSuitIndex(c2.getSuite()));
        System.out.println("real Level: " + c2.getRealValue());
        System.out.println();
       
        ArrayList<Card> draw = new ArrayList<Card>();
        draw.add(c1);
        draw.add(c2);
        d1.appendCard(draw);
        d1.showDeck();


    }
 
}
