package A1;

import java.util.*;

public class Player extends User {
    private int chips;
    protected ArrayList<Card> cardOnHand;
    private int betAmount;
    private int totalAmount;

    public Player(String username, String password, int chips ,int betAmount) {
        super(username, password);
        this.chips = chips;
        this.betAmount = betAmount;
        this.cardOnHand = new ArrayList<Card>();
    }


    public int getChips(){
        return this.chips;
    }
    public void setChips(int chips){
        this.chips = chips;
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

    public void showCardOnHand(boolean isVisible){
        System.out.println(getUsername());
        for(int i = 0 ; i< this.cardOnHand.size(); i++){
            if(isVisible == false && i == 0){
                    System.out.print("<Hidden Card>  ");
            }else
            System.out.print(this.cardOnHand.get(i));
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
       System.out.println("Value: "+ getTotalCardsValue());
    }


    public boolean bet(String person ,Player player, Dealer dealer){
      
        if(person.equals("dealer")){
           System.out.println();
           System.out.println("\nDealer Calls 10 Chips");
           dealer.loseChips(dealer.getBetAmount());
           boolean y = Keyboard.readBoolean("\nDo you want to Follow [Y/N]");
           if(y == true){
                dealer.setBetAmount(10);
                player.setBetAmount(dealer.getBetAmount());
                player.loseChips(dealer.getBetAmount());
                checkMainBalance(player);
                totalAmount += player.getBetAmount()+dealer.getBetAmount();
                return true;
            }else{
                System.out.println("\nYou Lose");
                return false;
            }
        }else{
            checkMainBalance(player);
            
            boolean CallQuit = Keyboard.readCallQuit("\nDo you want to [C]all or [Q]uit? :");

            if(CallQuit == true){
                int z = Keyboard.readInt("\nPlayer Call, state bet :");
                int x = checkBetBalance(z, player);
                player.setBetAmount(x);
                player.loseChips(x);
                dealer.setBetAmount(player.getBetAmount());
                dealer.loseChips(player.getBetAmount());
                System.out.println("\nDealer follows the bet");
                totalAmount += player.getBetAmount()+dealer.getBetAmount();
                return true;

            }else{
                System.out.println("\nYou Quit the current game");
                return false;
            }
            
            
        }

    }

    public void checkMainBalance(Player player) {
            if(player.getChips() <= 0 ){
                System.out.println("\nYour main balance is zero!");
                System.out.println("\nYou lose the game!");
                System.exit(0);
            }
    }

    public int checkBetBalance(int balance , Player player) {
        
        boolean valid = false;
        while (!valid) {
            try {
                   if(balance < player.getChips() && balance > 0) {
                        valid = true;
                    }else{
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("\nYour bet is invalid");
                    balance = Keyboard.readInt("\nPlayer Call, state bet :");
            }
        }
        return balance;
    }


    public int getTotalBetAmount(){
        return this.totalAmount;
    }
    public void setTotalBetAmount(int totalAmount){
        this.totalAmount = totalAmount;
    }

   
    public int getBetAmount(){
        return this.betAmount;
    }
    public void setBetAmount(int betAmount){
        this.betAmount = betAmount;
    }


    public static void main(String[] args) {
        Player p1 = new Player("Mario", "123", 100,0);
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
        p1.showCardOnHand(true);
        p1.showCardOnHand(false);
        p1.showCardOnHand(true);
        p1.getTotalCardsValue();
        p1.showTotalCardsValue();


    }


}