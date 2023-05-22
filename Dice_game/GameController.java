
public class GameController {
	private Dice dice;
	private ViewController view;
	
	public GameController(ViewController view) {
		this.dice = new Dice();
		this.view = view;
	}
	
	public void execute() {
		
		boolean carryOn = true;
		
		while(carryOn) {
			
			//ask player what number to bet 1 to 6
			view.displayEnterBetInstruction();
			int betNum = view.askBet();
		
			view.displayBet(betNum);
			
			//roll the dice
			DiceFace[] randomFaces = dice.throwDice();
		
			//display the dice animation
			view.showRandomSequence(randomFaces);
			
			//display result
			if(betNum==randomFaces[randomFaces.length-1].getNumber()) {
				view.displayWin();
			}else {
				view.displayLose();
			}
		
			//another game
			carryOn = view.askAnotherGame();
		}
		view.ends();
	}

}
