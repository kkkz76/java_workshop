package A2;

public class GameModule {
    private Player player;
    private Dealer dealer;
    private Admin admin;
    boolean mainGame = true;
    
    public GameModule(){
        admin = new Admin("Admin","password");
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
        System.out.println("\n"+player.getUsername()+" , You have "+player.getChips()+" Chips");
    }
    public void showleftChips(){
        System.out.println("\n"+player.getUsername()+ " , You are left with "+ player.getChips()+" chips");
    }
    public void setGameRoundBanner(int round){
        System.out.println("\nDealer Dealing Cards - Round "+ round );
    }
    public void TotalBetbanner(){
        System.out.println("\nBet on table : "+ player.getTotalBetAmount());
    }
    public boolean nextGame(){
        boolean result = Keyboard.readBoolean("\nNext Game ? [Y/N]");
        if(result == true){
            resetData();
        }else{
            System.out.println("\nGame Ended");
            System.exit(0);
        }
        return mainGame = result;
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
    public void gamePlay(){
        boolean check = true;
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
            System.out.println();
            player.showCardOnHand(true);
            player.showTotalCardsValue();
            check = player.bet(dealer.singleResult(player, dealer),player,dealer);
            if(check == false){
                break;
            }
            showleftChips();
            TotalBetbanner();
            showLine();
        }
        if(check == false){
            return;
        }
        System.out.println("\nGame End - Dealer reveal hidden cards");
        dealer.showCardOnHand(true);
        dealer.showTotalCardsValue();
        System.out.println();
        player.showCardOnHand(true);
        player.showTotalCardsValue();
        System.out.println();
        System.out.println(dealer.finalResult(player, dealer));
        resetData();
        
    }

    public void game(){
        while(mainGame){
            showTitle();
            showChipFirstRound();
            showLine();
            dealer.DealerShuffle();
            showLine();
            gamePlay();
            nextGame();
        }
    }
    
    
    public void run(){
        // game start here
        boolean gameStart = true;
        String user = "admin";
        while(gameStart){
        showTitle();   
        String username = Keyboard.readString("Enter login name> ");
        String password = Keyboard.readString("Enter passowrd> ");

            if(admin.checkUsername(username)== true && admin.checkPassword(password) == true){
                user = "admin";
                System.out.println("Admin Login Success");
                gameStart = false;
                break;
            }else if(player.checkUsername(username)== true && player.checkPassword(password)){
                user = "player";
                System.out.println("Player Login Success");
                gameStart = false;
                break;
            }else{
                System.out.println("\nInvalid Login Data");
            }
        }
            if(user.equals("admin")){
                admin.menu();
            }else{
                game();
            }
 }

    public static void main(String[] args) {
        GameModule app = new GameModule();
        app.run();
        
    }
}
