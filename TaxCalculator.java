public class TaxCalculator {
    
    private static double basicRate = 4;
    private static double luxuryRate = 10;

    public static double computeCostBasic(double price){
        double costBasic = price *(1+basicRate/100);
        return roundToNearestTwoDecPlaces(costBasic);

    }

    public static double computeCostLuxury(double price){
        double costLuxury = price *(1+luxuryRate/100);
        return roundToNearestTwoDecPlaces(costLuxury);
    }
    public static void changeBasicRate(double basicRate){
        TaxCalculator.basicRate = basicRate;
    }
    public static void changeLuxuryRate(double luxuryRate){
        TaxCalculator.luxuryRate = luxuryRate;
    }

    private static double roundToNearestTwoDecPlaces (double value){
        return Math.round(value*100/100);
    
    }
    public static void main(String[] args) {
        double price =12.3;
        double basicPrice = TaxCalculator.computeCostBasic(price);
        System.out.println(basicPrice);

        double luxuryPrice = TaxCalculator.computeCostLuxury(price);
        System.out.println(luxuryPrice);

        TaxCalculator.changeBasicRate(8);
        TaxCalculator.changeLuxuryRate(15);
        basicPrice = TaxCalculator.computeCostBasic(price);
        System.out.println(basicPrice);
        luxuryPrice = TaxCalculator.computeCostLuxury(price);
        System.out.println(luxuryPrice);
    } 
        
    
}
