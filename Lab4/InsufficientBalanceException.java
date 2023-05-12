public class InsufficientBalanceException extends Exception {
	private double insufficientAmount;
	//complete this class

	public double getInsufficientAmount() {
		//complete this
		return insufficientAmount;
	}
	public InsufficientBalanceException(double insufficientAmount) {
        this.insufficientAmount = insufficientAmount;
    }
}