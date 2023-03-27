public class Phone{
    private String Brand;
    private String Model;


    public String getBrand() {
        return Brand;
    }
    public String getModel() {
        return Model;
    }
    public void setBrand(String Brand) {
        this.Brand = Brand;
    }
    public void setModel(String Model) {
        this.Model = Model;
    
    }
    public void display() {
        System.out.println("Brand:"+ this.Brand);
        System.out.println("Model:"+ this.Model);

    }
    public static void main(String[] args){
        Phone phone1 = new Phone();
        phone1.setBrand("Samsung");
        phone1.setModel("S22");

        Phone phone2 = new Phone();
        phone2.setBrand("Apple");
        phone2.setModel("Iphone 14");

        phone1.display();
        phone2.display();
    }
}