
public class AssertTest {

   
    public static void test(){
        Boolean x = true;
        while(x){
            System.out.println("hello1");
            System.out.println("hello2");
            System.out.println("hello3");
            System.out.println("hello4");
            x= true;
            if(x == false){
             break;
            }
            System.out.println("hello5");
            System.out.println("hello6");
        }
        System.out.println("HEllooooooo");
    }
    
    public static void main(String[] args) {
        String[] weekend = {"Friday", "Saturday", "Sunday"};
        assert weekend.length == 2:"Exceeded 2 weekend";
      
        System.out.println("There are "+ weekend.length+" weekend days in a week");

        String scale ="Apple";
        String apple = "Apple";

            if(scale == apple){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        
            test();
        

      
}
}