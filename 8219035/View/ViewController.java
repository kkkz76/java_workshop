package View;
import Model.*;
import javax.swing.*;
import GUIExample.*;
import java.awt.*;
import java.awt.event.*;
import Helper.*;

//all input and output should be done view ViewController
//so that it is easier to implement GUI later
public class ViewController {
	
	private GameTableFrame gFrame;
	private Dealer dealer;
	private Player player;
	
	
	
///////////////////////////////////GUI////////////////////////////////////////

	public ViewController(Dealer dealer, Player player) {
		this.player = player;
		this.dealer = dealer;
	}

	public boolean getValidLoginStatus(){

	

		System.out.println("AA");
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(300, 80));
	

		JLabel label1 = new JLabel("Enter Username");
		label1.setBounds(10, 10, 100, 20);

		JTextField textField1 = new JTextField(10);
		textField1.setBounds(150, 10, 150, 20);

		JLabel label2 = new JLabel("Enter Password");
		label2.setBounds(10, 40, 100, 20);

		JPasswordField textField2 = new JPasswordField(10);
		textField2.setBounds(150, 40, 150, 20);

		panel.setLayout(null);
		String[] buttons = {"Login"};
		boolean validLogin=false;
		panel.add(label1);
		panel.add(label2);
		panel.add(textField1);    
		panel.add(textField2);
		

		int result = JOptionPane.showOptionDialog(
				null,
				panel,
				"HighSum Game",
				JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null,
				buttons, // pass only the OK button
				textField1);

		if (result == JOptionPane.OK_OPTION) {
			
			String name = textField1.getText();
			String password = textField2.getText();

			if(name.equals(this.player.getLoginName()) && Utility.getHash(password).equals(this.player.gethash())){
				validLogin = true;
			   
			}else{
				validLogin = false;
			}
			
			
		}
		return validLogin;


	}


	public void constructGame(){
		gFrame = new GameTableFrame(this.dealer,this.player);
	}

	public void constructShuffle(){
		gFrame.addLoading();
	}

	// public boolean getValidLoginStatus(){
	// 	return this.loginPanel.getValidLogin();

		
	// }

	public void refresh() {
		gFrame.updateGameTable();
	}

	public void DisplayPlayerCardValue(){
		gFrame.getGamePanel().setplayerCardValue();
	}

	public void DisplayPlayerChipsLeft(){
		gFrame.getGamePanel().setPlayerChips();
	}
	public void HideDealerCardValue(){
		gFrame.getGamePanel().setHidedealerCardValue();
	}
	public void DisplayDealerCardValue(){
		gFrame.getGamePanel().setShowdealerCardValue();
	}
	public void DisplayBetOnTable(int amount){
		gFrame.getGamePanel().setBetonTable(amount);
	}
	public void pause(int time) {
		try{
			Thread.sleep(time);
			
		 }catch(Exception e){}
   }

   public void showFinalCard(){
		gFrame.getGamePanel().imgChange();
	
   }
   public void displayCardBack(){
	gFrame.getGamePanel().imgBackChange();
   }
	public void displayDealerRoundWinner(){
		gFrame.getGamePanel().setWhoWin("Dealer win this round, "+ dealer.getLoginName()+" calls !!!");
	}
	public void displayPlayerRoundWinner(){
		gFrame.getGamePanel().setWhoWin("Player win this round, "+player.getLoginName()+" calls !!!");
	}

	public void  displayError(String meg){
	
        JOptionPane.showMessageDialog(null, meg, "Error", JOptionPane.INFORMATION_MESSAGE);
	}



	public String askBet(){
		JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter your bet");
        JTextField textField = new JTextField(10);
		String[] buttons = {"OK"};
		String bet="";
		
        panel.add(label);
        panel.add(textField);
		

        int result = JOptionPane.showOptionDialog(
                null,
                panel,
                "Bet",
                JOptionPane.OK_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                buttons, // pass only the OK button
                textField);
				

		
        if (result == JOptionPane.OK_OPTION) {
			
             bet = textField.getText();
           
			
        }
		return bet;
	}
	
	public char askFollow(String option) {
		String[] buttons = { option, "Quit" };
		String message;
		if(option.equals("Follow")){
			 message = "Dealer Call, place 10 chips.";
		}else{
			 message = "Player Call, Choose an option.";
		}
     	int result = JOptionPane.showOptionDialog(null, 
                          message,
                          "Choose one option",
                          JOptionPane.YES_NO_OPTION,
                          JOptionPane.QUESTION_MESSAGE,null,buttons, buttons[0]);

      	if(result == JOptionPane.YES_OPTION){
         return 'y';
		}else{
		return 'n';
	  }
    }

	public boolean askAnotherGame(String message) {
		boolean anotherGame = true;
		System.out.println("ask another game");
		int again = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
		if(again==JOptionPane.NO_OPTION) {
			anotherGame=false;
		}
		return anotherGame;
	}

	public void ends() {
		gFrame.dispose();
	}




///////////////////////Console/////////////////////////////////////////////////////////////
	public void ShowPlayerNameAndChips(Player player) {
		
		System.out.println(player.getLoginName()+", You have "+player.getChips()+" chips");
	}

	public void ShowPlayerTotalCardValue(Player player) {
		
		System.out.println("Value:"+player.getTotalCardsValue());
	}

	public void showPlayerCardsOnHand(Player player) {
		
		
		System.out.println(player.getLoginName());

		if(player instanceof Dealer) {
			
			for(int i=0;i<player.getCardsOnHand().size();i++) {
				if(i==0) {
					System.out.print("<HIDDEN CARD> ");
				}else {
					System.out.print(player.getCardsOnHand().get(i).toString()+" ");
				}
			}
		}else {
			for(Card card:player.getCardsOnHand()) {
				System.out.print(card+" ");
			}
		}
		System.out.println();
	}

	public void ShowExitGame() {
		System.out.println("Thank you for playing HighSum game");
	}

	public void ShowBetOntable(int bet) {
	
		System.out.println("Bet on table : "+bet);
	}
	
	public void ShowPlayerWin(Player player) {
		System.out.println(player.getLoginName()+" Wins!");
	}
	
	public void ShowDealerWin() {
		System.out.println("Dealer Wins!");
	}
	
	public void ShowTie() {
		System.out.println("It is a tie!.");
	}
	
	public void ShowPlayerQuit() {
		System.out.println("You have quit the current game.");
	}
	
	public void ShowBlankLine() {
		System.out.println();
	}
	
	public void ShowDealerDealCardsAndGameRound(int round) {
		System.out.println("Dealer dealing cards - ROUND "+round);
	}
	
	public void ShowGameStart() {
		System.out.println("Game starts - Dealer shuffle deck");
	}
	
	public void ShowPlayerNameAndLeftOverChips(Player player) {
		System.out.println(player.getLoginName()+", You are left with "+player.getChips()+" chips");
	}
	
	public void ShowyGameTitle() {
		System.out.println("HighSum GAME");
	}
	
	public void ShowSingleLine() {
		for(int i=0;i<30;i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public void ShowDoubleLine() {
		for(int i=0;i<30;i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	

	public int getDealerCallBetChips() {
		System.out.println("Dealer call, state bet: 10");
		return 10;
	}


	
	
}
