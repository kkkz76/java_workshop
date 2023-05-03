public class Looptest {

    public static boolean loop = true;


    public static void A1(){
        System.out.println("A1");
    }
    public static void A2(){
        loop = false;
        System.out.println("A2");
        
    }
    public static void A3(){
        System.out.println("A3");
    }
    public static void A4(){
        System.out.println("A4");
    }
    public static void A5(){
        System.out.println("A5");
    }


    public static  void loop(){
        while(loop){
            A1();
            A2(); //loop is false
            if(loop == false){
                loop = true;
                continue;
            }
            A3();
            A4();
            A5();
            
    
        }
    }



    public static void main(String[] args) {
        loop();
    }
}
