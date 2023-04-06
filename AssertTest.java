public class AssertTest {

   
    
    public static void main(String[] args) {
        String[] weekend = {"Friday", "Saturday", "Sunday"};
        assert weekend.length == 2:"Exceeded 2 weekend";
      
        System.out.println("There are "+ weekend.length+" weekend days in a week");

        char scale = 'a';
            if(scale == 'a'){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }

      
}
}