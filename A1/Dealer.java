package A1;


public class Dealer extends Player {

    private Deck deck;

    public Dealer() {
        super("Dealer", "", 100);
        deck = new Deck();
    }
    public void DealerShuffle(){
        System.out.println("Dealer shuffling cards......");
        deck.shuffleCard();
    }
    public void dealCardTo(Player player){
       player.addCard(deck.drawCard()); 
    }

    public String finalResult(Player player, Dealer dealer){
        
        if(player.getTotalCardsValue() > dealer.getTotalCardsValue()){
           return "player";
        }else if(player.getTotalCardsValue() < dealer.getTotalCardsValue()){
           return "dealer";
        }else{
            return "tie";
        }   
    }

    public String singleResult(Player player, Dealer dealer){
        
        int pSuitLvl,dSuitLvl,pCardValue,dCardValue;
        if (player.getCardOnHand().size() == 1){
            pSuitLvl = deck.getSuitIndex(player.getCardOnHand().get(0).getSuite());
            dSuitLvl = deck.getSuitIndex(dealer.getCardOnHand().get(0).getSuite());
            pCardValue = player.getCardOnHand().get(0).getValue();
            dCardValue = dealer.getCardOnHand().get(0).getValue();

        }else{ //when size >1 need to retrieve the last value
            pSuitLvl = deck.getSuitIndex(player.getCardOnHand().get(player.getCardOnHand().size()-1).getSuite());
            dSuitLvl = deck.getSuitIndex(dealer.getCardOnHand().get(player.getCardOnHand().size()-1).getSuite());
            pCardValue = player.getCardOnHand().get(player.getCardOnHand().size()-1).getValue();
            dCardValue = dealer.getCardOnHand().get(player.getCardOnHand().size()-1).getValue();
        }

        if(pCardValue > dCardValue){
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
        Player p1 = new Player("MGMG","123",100);
        Dealer d1 = new Dealer();
        d1.DealerShuffle();
        d1.dealCardTo(p1);
        d1.dealCardTo(d1);
        p1.showCardOnHand();
        d1.showCardOnHand();
        System.out.println("The Winner is :"+ d1.singleResult(p1, d1));
        d1.dealCardTo(p1);
        d1.dealCardTo(d1);
        p1.showCardOnHand();
        d1.showCardOnHand();
        System.out.println("The Winner is :"+d1.singleResult(p1, d1));
        d1.dealCardTo(p1);
        d1.dealCardTo(d1);
        p1.showCardOnHand();
        d1.showCardOnHand();
        System.out.println("The Winner is :"+d1.singleResult(p1, d1));
        System.out.println("The final winner is:" + d1.finalResult(p1, d1));
    }
    
    
}
