package GUIExample;
import java.awt.*;
import javax.swing.*;
import Model.*;

public class ShufflePanel extends JPanel {

    private ImageIcon img1;
    private JLabel img;
    private JLabel txt;
    public ShufflePanel(){
        setPreferredSize(new Dimension(1920, 1080));
        setBackground(Color.white);
        setLayout(null);
        
        img1 = new ImageIcon("images/shuffle.gif");

        img = new JLabel(img1);
        img.setBounds(500, 100, img1.getIconWidth(), img1.getIconHeight());
		add(img);

        txt = new JLabel("Dealer is shuffling the cards ......");
        txt.setBounds(700, 600, 200 ,20 );
		add(txt);



	
    }
}
