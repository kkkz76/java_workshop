import java.util.ArrayList;
import java.util.Arrays;


public class BinarySearchSequence {
	
	public static ArrayList<Integer> binarySearchIndexSequence(int num, int[] numArray) {
	
		ArrayList<Integer> sequence = new ArrayList<Integer>();//do not change
	//complete your code here
		Arrays.sort(numArray);
		int low = 0;
		int high = numArray.length -1;
		int mid = 0;
		int midValue = 0;

		while (low <= high) {

			mid = (low + high) / 2;

			midValue = numArray[mid];

			sequence.add(mid);

			if(num == midValue){
				break;
			}else if(num < midValue) {
				high = mid - 1;
			}else if(num > midValue) {
				low = mid + 1;
			}
		}

		if(num != midValue){
			sequence.add(-1);
		}
		return sequence;//do not change
	}	
}
