package A1;


public class Dealer extends Player {

    private Deck deck;
    

    public Dealer() {
        super("Dealer", "", 100,10);
        deck = new Deck();
    }
    public void DealerShuffle(){
        System.out.println("Game Starts - Dealer Shuffles deck.");
        deck.shuffleCard();
    }
    public void dealCardTo(Player player){
       player.addCard(deck.drawCard()); 
    }
    public Deck getDeck(){
        return this.deck;
    }
    public String finalResult(Player player, Dealer dealer){
        
        if(player.getTotalCardsValue() > dealer.getTotalCardsValue()){
            player.winChips(player.getTotalBetAmount());
           return player.getUsername()+" Win \n"+ "Player got "+player.getChips()+" chips";
        }else if(player.getTotalCardsValue() < dealer.getTotalCardsValue()){
           return player.getUsername()+" Lose , Dealer wins the game";
        }else{
            return "The game is tie!!!";
        }   
    }
    public String singleResult(Player player, Dealer dealer){
      
        int pSuitLvl,dSuitLvl,pCardValue,dCardValue;
        if (player.getCardOnHand().size() == 1){
            pSuitLvl = deck.getSuitIndex(player.getCardOnHand().get(0).getSuite());
            dSuitLvl = deck.getSuitIndex(dealer.getCardOnHand().get(0).getSuite());
            pCardValue = player.getCardOnHand().get(0).getRealValue();
            dCardValue = dealer.getCardOnHand().get(0).getRealValue();

        }else{ //when size >1 need to retrieve the last value
            
            pSuitLvl = deck.getSuitIndex(player.getCardOnHand().get(player.getCardOnHand().size()-1).getSuite());
            dSuitLvl = deck.getSuitIndex(dealer.getCardOnHand().get(dealer.getCardOnHand().size()-1).getSuite());
            pCardValue = player.getCardOnHand().get(player.getCardOnHand().size()-1).getRealValue();
            dCardValue = dealer.getCardOnHand().get(dealer.getCardOnHand().size()-1).getRealValue();
        }

        if(pCardValue > dCardValue){ //card values are compared with real values not values.
            return "player";
        }else if(pCardValue < dCardValue){
            return "dealer";
        }else{ // when 2 value are equal
            if(pSuitLvl > dSuitLvl){
                return "player";
            }else{
                return "dealer";
            }
        }
    }

    

    public static void main(String[] args) {
        Player p1 = new Player("MGMG","123",100,0);
        Dealer d1 = new Dealer();
        d1.DealerShuffle();
        d1.dealCardTo(p1);
        d1.dealCardTo(d1);
        p1.showCardOnHand(true);
        d1.showCardOnHand(false);
        System.out.println("The Winner is :"+ d1.singleResult(p1, d1));
        d1.dealCardTo(p1);
        d1.dealCardTo(d1);
        p1.showCardOnHand(true);
        d1.showCardOnHand(true);
        System.out.println("The Winner is :"+d1.singleResult(p1, d1));
        d1.dealCardTo(p1);
        d1.dealCardTo(d1);
        p1.showCardOnHand(true);
        d1.showCardOnHand(true);
        System.out.println("The Winner is :"+d1.singleResult(p1, d1));
        System.out.println("The final winner is:" + d1.finalResult(p1, d1));
    }
    
    
}
