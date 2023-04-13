package A1;

public class GameModule {
    private Player player;
    private Dealer dealer;
    
    

    public GameModule(){
        dealer = new Dealer();
        player = new Player("IcePeak","password",100);
    }

    

    public void run(){
        // game start here
        boolean gameStart = true;

        while(gameStart){

        System.out.println("HighSum Game");
        System.out.println("================================================================");
        
        String username = Keyboard.readString("Enter login name> ");
        String password = Keyboard.readString("Enter passowrd> ");

        
        if(player.checkPassword(password) == true){


            System.out.println("The Game started successfully");



        }else{
            System.out.println("Invalid password");
        }
        }


        // dealer.DealerShuffle();
        // dealer.dealCardTo(dealer);
        // dealer.dealCardTo(player);
        // player.showCardOnHand();
        // player.showTotalCardsValue();
        // dealer.showCardOnHand();
        // player.showTotalCardsValue();
    }

    public static void main(String[] args) {
        GameModule app = new GameModule();
        app.run();
        
    }
}
