public class Lab1 {

	// function 1
	public static double largest(double[] numbers) {
		double largest = 0;// do not change

		// you code here
		for(double x: numbers){
			if(x >= largest){
				largest = x;
			}
		}
		// end

		return largest;// do not change
	}

	// function 2 - assume n>m
	public static int[] intArray(int m, int n) {
		int[] intArray = new int[n - m + 1];// do not change

		// you code here
		int i;
		int j=0;
		for(i=m;i<=n;i++){
			intArray[j] = i;
			j++;
		}
		// end

		return intArray; // do not change
	}

	// function 3
	public static boolean isTriangle(int side1, int side2, int side3) {
		boolean isTriangle = false;// do not change

		// you code here
		int x = side1 + side2;
		int y = side2 + side3;
		int z = side3 + side1;
		if( x > side3 && y > side1 && z > side2){
			isTriangle = true;
		}
		// end

		return isTriangle;// do not change
	}

	// function 4
	public static boolean isPrime(int n) {
		boolean isPrime = false; // do not change

		// you code here
			int count = 0;
			for (int j = 2; j <= n / 2; j++) {
			 if (n % j == 0) {
			  count++;
			  break;
			 }
			}
		 
			if (count == 0) {
			 isPrime = true;
			}
		 
		   // end

		return isPrime; // do not change
	}

	// function 5
	public static int[] vowelCount(String s) {
		int[] vowelCount = new int[5]; // do not change

		// you code here
		String x = s.toLowerCase();
		String [] words = x.split("");
		int a,e,i,o,u;
        a=e=i=o=u=0;
		
		for(String letter: words){
			if(letter.equals("a")){a+=1;}
			if(letter.equals("e")){e+=1;}
			if(letter.equals("i")){i+=1;}
			if(letter.equals("o")){o+=1;}
			if(letter.equals("u")){u+=1;}
		}
        vowelCount[0] = a;
		vowelCount[1] = e;
		vowelCount[2] = i;
		vowelCount[3] = o;
		vowelCount[4] = u;
		// end

		return vowelCount; // do not change
	}

}
