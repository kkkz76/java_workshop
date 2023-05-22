
import java.util.*;

public class Dice {
	
	private DiceFace[] faces;
	private DiceFace[] randomFaces;
	public Dice() {
		faces = new DiceFace[6];
		for(int i=0;i<faces.length;i++) {
			faces[i] = new DiceFace(i+1);
		}
	}
	
	public DiceFace[] throwDice() {	
		Random random = new Random();
		randomFaces = new DiceFace[random.nextInt(5,8)];
		
		int counter=0;
		while(counter<randomFaces.length) {
			//ensure it does not produce two consecutive same random numbers
			int r = random.nextInt(6)+1;
			if(counter!=0) {
				if(randomFaces[counter-1].getNumber()!=r) {
					randomFaces[counter++]=faces[r-1];
				}
			}else {
				randomFaces[counter++]=faces[r-1];
			}
		}
		return randomFaces;
	}
	
	public static void main(String[] args) {
		Dice dice = new Dice();
		DiceFace[] nums = dice.throwDice();
		for(DiceFace n: nums) {
			System.out.println(n.getNumber());
		}
	}
	
	
	
}
