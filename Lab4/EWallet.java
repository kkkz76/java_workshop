
public class EWallet {

	private String id;
	private double balance;

	//complete this
	public EWallet(String id, double balance) {
		this.id = id;
		this.balance = balance;

	}
	public double getBalance() {
		return balance;
	}

	//complete this
	public void deductAmount(double amount) throws InsufficientBalanceException {
		if(amount > balance){
			throw new InsufficientBalanceException(this.balance);
		}else{
			this.balance -= amount;
		}
		
		
	}
}
