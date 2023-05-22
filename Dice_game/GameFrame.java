import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame  extends JFrame{

	private GamePanel gamePanel;
	
	public GameFrame() {
		setPreferredSize(new Dimension(500,500));
		this.gamePanel = new GamePanel();
		add(this.gamePanel);
		pack();
		setVisible(true);
	}
	
	public GamePanel getGamePanel() {
		return this.gamePanel;
	}
	
	public void showDiceFace(DiceFace diceFace) {
		this.gamePanel.setDiceFace(diceFace);
		repaint();
	}
	
	public void repaint() {
		this.gamePanel.repaint();
	}
}
