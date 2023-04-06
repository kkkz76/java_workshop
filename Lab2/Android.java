
public class Android {

	//declare your variables here
	private static int tag =0;
	private String name = "Bob";
	

	public Android() {
		
		//fill in your codes
		changeTag();
		

	}
	
	public String getName() {
		//fill in your codes
		String x=String.valueOf(tag);  
		return name+x;
		
	}
	
	public static void changeTag() {
		//fill in your codes
		 int count;
        
        for (int i = 1; i>0; i++) {
         count = 0;
         for (int j = 2; j <= i / 2; j++) {
          if (i % j == 0) {
           count++;
           break;
          }
         }
      
         if (count == 0) {
         
          if(i>tag){
            tag =i;
            break;
          }
         
         }
      
        }

		
		

  }
}
	
	

