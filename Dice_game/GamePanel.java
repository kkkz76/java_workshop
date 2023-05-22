import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class GamePanel extends JPanel {

	private JLabel diceNumber;
	private JLabel activity;
	private JLabel betNumber;
	private DiceFace diceFace;

	public GamePanel() {
		super();
		setLayout(null);		
		setBackground(new Color(255,253,204));
		setPreferredSize(new Dimension(500, 500));
		
		activity = new JLabel("");
		activity.setBounds(100,10,200,50);
		add(activity);
		
		betNumber = new JLabel("Bet number:");
		betNumber.setBounds(100,50,100,50);
		add(betNumber);
		
		diceNumber = new JLabel("Dice number: ");
		diceNumber.setBounds(100,100,100,50);
		add(diceNumber);
	}
	
	
	public void setDiceFace(DiceFace diceFace) {
		this.diceFace = diceFace;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(this.diceFace!=null) {
			this.diceFace.paintIcon(this, g, 100, 150);
		}
	}
	
	public void setInstruction(String instruction) {
		activity.setText(instruction);
		repaint();
	}
	
	public void setDiceNumber(int num) {
		diceNumber.setText("Dice number:"+num);
		repaint();
	}
	
	public void setBetNumber(int amount) {
		betNumber.setText("Bet number:"+amount);
		repaint();
	}
	
}
