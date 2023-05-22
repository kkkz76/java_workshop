
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewController {

	private GameFrame gameFrame;
	
	public ViewController() {
		gameFrame = new GameFrame();
	}
	
	public int askBet() {
		String numStr = JOptionPane.showInputDialog("Enter bet (1-6):");
		int bet = Integer.parseInt(numStr);
		return bet;
	}
	
	public void showRandomSequence(DiceFace[] randomFaces) {
		displayThrowingDice();
		for(int i=0;i<randomFaces.length;i++) {
			System.out.println(randomFaces[i].getNumber());
			gameFrame.getGamePanel().setDiceFace(randomFaces[i]);
			displayCurrentDiceNumber(randomFaces[i].getNumber());
			pause();
		}
		
	}

    //pause for 500msec
    private void pause() {
    	 try{
             Thread.sleep(500);
          }catch(Exception e){}
    }
    
    public void displayCurrentDiceNumber(int num) {
    	gameFrame.getGamePanel().setDiceNumber(num);
    }
    
	public void displayEnterBetInstruction() {
		gameFrame.getGamePanel().setInstruction("Enter bet (1-6):");
	}
	
	public void displayThrowingDice() {
		gameFrame.getGamePanel().setInstruction("Throwing dice");
	}
	
	public void displayBet(int betNumber) {
		gameFrame.getGamePanel().setBetNumber(betNumber);
	}
	
	public void displayWin() {
		gameFrame.getGamePanel().setInstruction("You win! Next game?");
	}
	
	public void displayLose() {
		gameFrame.getGamePanel().setInstruction("You Lose! Next game?");
	}

	public boolean askAnotherGame() {
		boolean anotherGame = true;
		int again = JOptionPane.showConfirmDialog(null,"Another game?");
		if(again==JOptionPane.NO_OPTION) {
			anotherGame=false;
		}
		return anotherGame;
	}
	
	public void ends() {
		gameFrame.dispose();
	}
}
