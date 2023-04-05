public class EWalletMain {
    public static void main(String[] args) {
        EWallet ew =new EWallet("A123",200,1000);
        ew.topup(-100);
        ew.display();
        ew.topup(1000);
        ew.display();
        System.out.println(ew.isEmpty());
        EWallet ew1 =new EWallet("B23",300);
        ew1.display();
        System.out.println(ew1.isEmpty());
    }
}
