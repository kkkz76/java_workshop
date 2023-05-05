package A2;

import java.util.*;

public class Player extends User{
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
    public void addChips(int amount){
        this.chips+=amount;
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

    // Show card on hand
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

    // Get all cards value
    public int getTotalCardsValue(){
        int total=0;
        for(Card c : this.cardOnHand){
           total += c.getValue();
        }
        return total;
    }

    // Print all cards value
    public void showTotalCardsValue(){
       System.out.println("Value: "+ getTotalCardsValue());
    }

    //Get total bet amount
    public int getTotalBetAmount(){
        return this.totalAmount;
    }
    //Set total bet amount
    public void setTotalBetAmount(int totalAmount){
        this.totalAmount = totalAmount;
    }
    //Get each bet amount
    public int getBetAmount(){
        return this.betAmount;
    }
    //Set each bet amount
    public void setBetAmount(int betAmount){
        this.betAmount = betAmount;
    }


    // Main bet function
    public boolean bet(String person ,Player player, Dealer dealer){
      
        if(person.equals("dealer")){
           System.out.println();
           System.out.println("\nDealer Calls 10 Chips");
           dealer.loseChips(dealer.getBetAmount());
           boolean y = Keyboard.readBoolean("\nDo you want to Follow [Y/N]");
            if(y == true){  //if dealer
                dealer.setBetAmount(10);
                player.setBetAmount(dealer.getBetAmount());
                player.loseChips(dealer.getBetAmount());
                if(checkMainBalance(player)== false){ //if player has not enough money
                    return false;
                }else{ //if player has enough money
                    totalAmount += player.getBetAmount()+dealer.getBetAmount();
                    return true;
                }    
            }else{
                System.out.println("\nYou Lose");
                return false;
            }
        }else{
            if(checkMainBalance(player)== false){ //if player has not enough money
                return false;
            }else{ //if player has enough money
                boolean CallQuit = Keyboard.readCallQuit("\nDo you want to [C]all or [Q]uit? :");

            if(CallQuit == true){  // if player calls
                int z = Keyboard.readInt("\nPlayer Call, state bet :");
                int x = checkBetBalance(z, player); //check bet balance
                player.setBetAmount(x);
                player.loseChips(x);
                dealer.setBetAmount(player.getBetAmount()); //dealer follow the bet
                dealer.loseChips(player.getBetAmount());
                System.out.println("\nDealer follows the bet");
                totalAmount += player.getBetAmount()+dealer.getBetAmount();
                return true;

            }else{ // if player quit
                System.out.println("\nYou Quit the current game");
                return false;
            }
            }
        }
    }

    //Check player main balance
    public boolean checkMainBalance(Player player) {
            if(player.getChips() <= 0 ){
                System.out.println("\nYour main balance is not enough");
                System.out.println("\nYou lose the game!");
                return false;
            }else{
                return true;
            }
    }

    //Check player bet amount
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
                    System.out.println("\nYour bet is invalid, note:sys does not alllow all in amount");
                    balance = Keyboard.readInt("\nPlayer Call, state bet :");
            }
        }
        return balance;
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