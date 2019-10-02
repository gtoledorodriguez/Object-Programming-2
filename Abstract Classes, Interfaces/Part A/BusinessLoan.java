package service;
import service.Loan;

public class BusinessLoan extends Loan{
	private int count;
	
	public BusinessLoan(){
		super();
		count++;
		super.setLoanID(count);
	}
	public BusinessLoan(String clientName, float amtOfLoan, float interest, int term){
		super(clientName, amtOfLoan, interest+0.1f, term);
		count++;
		super.setLoanID(count);
	}
	
	public String toString(){
		String bLoanString = "";
		
		bLoanString = super.toString();
		bLoanString = bLoanString + "\nLoan Type: Business";
		bLoanString = bLoanString + "\n===================================";
		
		return bLoanString;
	}
}