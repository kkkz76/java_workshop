public class Adder {
    private int intValue1;
    private int intValue2;
    private double doubleValue1;
    private double doubleValue2;

    public void set(int n1, int n2){
        this.intValue1 = n1;
        this.intValue2 = n2;

    }

    public void set(double d1, double d2){
        this.doubleValue1 = d1;
        this.doubleValue2 = d2;
    }

    public int getIntSum(){
        return this.intValue1 +  this.intValue2; 
    }

    public double getDoubleSum(){
        return this.doubleValue1 + this.doubleValue2;
    }
    public double totalSum(){
        return this.getIntSum() + this.getDoubleSum();
    }
    public static void main(String[] args) {
        
        Adder adder = new Adder();
        adder.set(1,2);
        adder.set(2.2,2.5);
        System.out.println(adder.getIntSum());
        System.out.println(adder.getDoubleSum());
        System.out.println(adder.totalSum());
    }
}

