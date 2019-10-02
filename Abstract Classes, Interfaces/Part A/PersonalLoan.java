package service;
import service.Loan;

public class PersonalLoan extends Loan{
	private int count;
	
	public PersonalLoan(){
		super();
		count++;
		super.setLoanID(count);
	}
	public PersonalLoan(String clientName, float amtOfLoan, float interest, int term){
		super(clientName, amtOfLoan, interest+0.2f, term);
		count++;
		super.setLoanID(count);
	}
	
	public String toString(){
		String bLoanString = "";
		
		bLoanString = super.toString();
		bLoanString = bLoanString + "\nLoan Type: Personal";
		bLoanString = bLoanString + "\n===================================";
		
		return bLoanString;
	}
}