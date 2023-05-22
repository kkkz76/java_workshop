
import Model.*;
import View.*;
import Controller.*;

public class GUIExample {

	private Dealer dealer;
	private Player player;
	private ViewController view;
    private GameController gc;
	// private GameTableFrame app;
	
	 //testing of game table UI
	public GUIExample() {
       player = new Player("IcePeak","password",10000);
       dealer = new Dealer();
	   this.view = new ViewController(this.dealer,this.player);
	   
       this.gc = new GameController(this.dealer,this.player,this.view);

	 
	} 
	
	public void run() {
		gc.run();
	}
	
	public static void main(String[] args) {
		new GUIExample().run();
	}
}
