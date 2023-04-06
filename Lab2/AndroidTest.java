
public class AndroidTest {

	public static void main(String[] args) {

		try {
			Android a1 = new Android();
			assert a1.getName().equals("Bob1");
			System.out.println(a1.getName());

			Android a2 = new Android();
			assert a2.getName().equals("Bob2");
			System.out.println(a2.getName());

			Android a3 = new Android();
			assert a3.getName().equals("Bob3");
			System.out.println(a3.getName());

			Android a4 = new Android();
			assert a4.getName().equals("Bob5");
			System.out.println(a4.getName());

			Android a5 = new Android();
			assert a5.getName().equals("Bob7");
			System.out.println(a5.getName());

			
			System.out.println("Android test passed");
		} catch (AssertionError ae) {
			System.out.println("Android test failed");
		}

	}

}
