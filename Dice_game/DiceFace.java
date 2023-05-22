import javax.swing.ImageIcon;

public class DiceFace extends ImageIcon {
	
	private int number;
	public DiceFace(int number) {
		super("images/"+number+".png");
		this.number=number;
	}
	
	public int getNumber() {
		return number;
	}
}
