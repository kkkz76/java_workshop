package A1;

public class GameModule {
    private Player player;
    private Dealer dealer;
    boolean mainGame = true;
    
    public GameModule(){
        dealer = new Dealer();
        player = new Player("IcePeak","password",100,0);
    }
    public void showTitle(){
        System.out.println("HighSum Game");
        System.out.println("==============================================");
    }
    public void showLine(){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - ");
    }
    public void  showChipFirstRound(){
        System.out.println(player.getUsername()+" , You have "+player.getChips()+" Chips");
    }
    public void showleftChips(){
        System.out.println(player.getUsername()+ " , You are left with "+ player.getChips()+" chips");
    }
    public void setGameRoundBanner(int round){
        System.out.println("Dealer Dealing Cards - Round "+ round );
    }
    public void TotalBetbanner(){
        System.out.println("Bet on table : "+ player.getTotalBetAmount());
    }
    public boolean nextGame(){
        boolean result = Keyboard.readBoolean("Next Game ? [Y/N]");
        if(result == true){
            resetData();
        }else{
            System.out.println("Game Ended");
            System.exit(0);
        }
        return mainGame = result;
    }

    public void gamePlay(){
        for(int i=1;i<5;i++){

            setGameRoundBanner(i);
            showLine();
            if(i==1){
                dealer.dealCardTo(player);
                dealer.dealCardTo(dealer);
            }
            dealer.dealCardTo(player);
            dealer.dealCardTo(dealer);
            dealer.showCardOnHand(false);
            player.showCardOnHand(true);
            player.showTotalCardsValue();
            player.bet(dealer.singleResult(player, dealer),player,dealer);
            showleftChips();
            TotalBetbanner();
            showLine();
        }
        System.out.println("Game End - Dealer reveal hidden cards");
        dealer.showCardOnHand(true);
        dealer.showTotalCardsValue();
        player.showCardOnHand(true);
        player.showTotalCardsValue();
        System.out.println(dealer.finalResult(player, dealer));
        resetData();
        
    }
    public void resetData(){
            // System.out.println(dealer.getDeck().getCards().size()) ; 
            player.setChips(100);
            dealer.setChips(100);
            dealer.getDeck().appendCard(player.cardOnHand);  
            dealer.getDeck().appendCard(dealer.cardOnHand);
            player.cardOnHand.clear();
            dealer.cardOnHand.clear();
            player.setTotalBetAmount(0);
            player.setBetAmount(0);
            dealer.setBetAmount(10);
            // dealer.getDeck().showDeck();
            // System.out.println(dealer.getDeck().getCards().size()) ;  
            
    }
    public void run(){
        // game start here
        // boolean gameStart = true;

        // while(gameStart){
        showTitle();   
        // String username = Keyboard.readString("Enter login name> ");
        // String password = Keyboard.readString("Enter passowrd> ");

        // if(player.checkUsername(username)== true && player.checkPassword(password)){


            



  
        // }else{
        //     System.out.println("Invalid input");
        // }
        // }


        
        while(mainGame){
            showTitle();
            showChipFirstRound();
            showLine();
            dealer.DealerShuffle();
            showLine();
            gamePlay();
            nextGame();
        }
        System.out.println( "Hello you break while");


    }

    public static void main(String[] args) {
        GameModule app = new GameModule();
        app.run();
        
    }
}
