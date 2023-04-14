package A1;

public class Card {
   
        private String suite;
        private String name;
        private int value;
        private int realValue;
    
        public Card(String suite, String name, int value, int realValue) {
            this.suite = suite;
            this.name = name;
            this.value = value;
            this.realValue = realValue;
        }
    
        public String getSuite() {
            return suite;
        }
    
        public String getName() {
            return name;
        }
    
        public int getValue() {
            return value;
        }
        public int getRealValue() {
            return realValue;
        }
        
        public String toString(){
            return "<"+suite+" "+name+">  ";
        }
           
        
    
        public static void main(String[] args) {
            Card card1 = new Card("Jack","Ace",1,1);
            System.out.println(card1);
        
        
    }   
    
}
