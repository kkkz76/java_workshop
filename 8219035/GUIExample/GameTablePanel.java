package GUIExample;
import java.awt.*;
import javax.swing.*;
import Model.*;

public class GameTablePanel extends JPanel {

	private Player player;
	private Dealer dealer;
	private ImageIcon cardBackImage;
	private JLabel playerName;
	private JLabel dealerName;
	private JLabel playerCardValue;
	private JLabel dealerCardValue;
	private JLabel playerChips;
	private JLabel chipOnTable;
	private JLabel whoWin;
	private JLabel imgChipsontable;
	private JLabel deck;
	private JLabel deckText;
	public static final Color Dark_Green = new Color(0,180,0);
	

	public GameTablePanel(Dealer dealer, Player player) {

		this.dealer =dealer;
		this.player = player;

		setBackground(Dark_Green);
		setPreferredSize(new Dimension(1920, 1080));

		cardBackImage = new ImageIcon("images/back.png");
		
		
		dealerName = new JLabel("Dealer : "+ this.dealer.getLoginName());
		dealerName.setBounds(400, 300, 200, 20);
		add(dealerName);

		dealerCardValue = new JLabel();
		dealerCardValue.setBounds(400, 340, 200, 20);
		add(dealerCardValue);

	    playerName = new JLabel("Player :"+ this.player.getLoginName());
		playerName.setBounds(400, 680, 200, 20);
		add(playerName);

		playerCardValue = new JLabel();
		playerCardValue.setBounds(400, 720, 200, 20);
		add(playerCardValue);
	
		playerChips = new JLabel();
		playerChips.setBounds(600, 720, 200, 20);
		add(playerChips);
	
		chipOnTable = new JLabel();
		chipOnTable.setBounds(100, 600, 200, 20);
		add(chipOnTable);

		whoWin = new JLabel();
		whoWin.setBounds(800, 20, 200, 20);
		add(whoWin);

		imgChipsontable = new JLabel(new ImageIcon("images/chipsontable.png"));
		imgChipsontable.setBounds(50, 410, new ImageIcon("images/chipsontable.png").getIconWidth(), new ImageIcon("images/chipsontable.png").getIconHeight());
		add(imgChipsontable);
		
		deck = new JLabel(cardBackImage);
		deck.setBounds(50, 70, cardBackImage.getIconWidth(), cardBackImage.getIconHeight());
		add(deck);

		deck = new JLabel(cardBackImage);
		deck.setBounds(80, 70, cardBackImage.getIconWidth(), cardBackImage.getIconHeight());
		add(deck);

		deckText = new JLabel("Deck");
		deckText.setBounds(100, 300, 100, 20);
		add(deckText);
	
	}

	public void setplayerCardValue() {
		playerCardValue.setText("Value :"+ this.player.getTotalCardsValue());
		repaint();
		
	}
	public void setHidedealerCardValue() {
		dealerCardValue.setText("Value : HIDDEN");
		repaint();
		
	}
	public void setShowdealerCardValue() {
		dealerCardValue.setText("Value : "+this.dealer.getTotalCardsValue());
		repaint();
		
	}
	public void setPlayerChips() {
		playerChips.setText("Balance Chips: :"+ this.player.getChips());
		repaint();
		
	}
	public void setBetonTable(int amount) {
		chipOnTable.setText("Bet on Table::"+ amount );	
		repaint();
	}

	public void setWhoWin(String text){
		whoWin.setText(text);
		repaint();
	
	}
	
	public void imgChange(){
		
		cardBackImage = this.dealer.getCardsOnHand().get(0);
		repaint();
	
	}

	public void imgBackChange(){
		cardBackImage = new ImageIcon("images/back.png"); 
		repaint();	
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int x =400;
		int y = 70;

		int i = 1;
		System.out.println("apple");

		for (Card c : dealer.getCardsOnHand()) {
			// display dealer cards
			if (i == 1) {
				cardBackImage.paintIcon(this, g, x, y);
				
			}else {
				c.paintIcon(this, g, x, y);	
			}
			i++;
			x += 200;
			
		}
		
	// display player cards
		x = 400;
		y = 450;

		for (Card c : player.getCardsOnHand()) {
			// display dealer cards
			c.paintIcon(this, g, x, y);
			x += 200;
		}
	
		
		
	}

	
}
