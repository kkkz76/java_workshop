package A1;

public class Card {
   
        private String suite;
        private String name;
        private int value;
    
        public Card(String suite, String name, int value) {
            this.suite = suite;
            this.name = name;
            this.value = value;
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
        
        public String toString(){
            return "<"+suite+" "+name+">  ";
        }
           
        
    
        public static void main(String[] args) {
            Card card1 = new Card("Jack","Ace",1);
            System.out.println(card1);
        
        
    }   
    
}
