
public class DiceGame {

	private ViewController vc;
	private GameController gc;
	
	public void run() {
		vc = new ViewController();
		gc = new GameController(vc);
		
		gc.execute();
		System.exit(0);		
	}
	
	public static void main(String[] args) {
		new DiceGame().run();	
	}
}
