import java.security.PublicKey;

public class EWallet {
    
    private String serialNumber;
    private double balance;
    private double maxAmount;

    public void display(){
        System.out.println("Serial Number: " + this.serialNumber);
        System.out.println("Balance: " + this.balance);
        System.out.println("Max Amount: " + this.maxAmount);
    }

    public double getBalance(){
        return this.balance;
    }
    public boolean isEmpty(){
        boolean isEmpty = true;
        if(balance>0){
            isEmpty = false;
        }
        return isEmpty;
    }
    
    public EWallet(String serialNumber, double balance, double maxAmount){
        this.serialNumber = serialNumber;
        this.balance = balance;
        this.maxAmount = maxAmount;
    }

    public EWallet(String serialNumber,double maxAmount){
        this.serialNumber = serialNumber;
        this.maxAmount = maxAmount;
        this.balance = 0;
    }
    private boolean canTopup(double amount){
        boolean canTopup = false;
        if(amount+this.balance <= this.maxAmount){
            canTopup = true;
        }
        return canTopup;
    }

    public void topup(double amount){

        if(amount <= 0){
            System.out.println("Fail top up  ");
        }

        else if(canTopup(amount)){
            this.balance+=amount;
            System.out.println("Success top up $"+amount);

        }else{
            System.out.println("Fail top up - exceed max amount");
        }
    }

    public void deduct(double amount){
        if(amount <=0){
            System.out.println("Fail deduct - amount must be greater than 0");

        }else if(this.balance >= amount){
            this.balance-= amount;
            System.out.println("Sucess deduct S"+amount);
            System.out.println("New Balance S");
        }

    
}
