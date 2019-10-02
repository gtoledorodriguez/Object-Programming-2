package service;
import service.LoanConstants;

public abstract class Loan implements LoanConstants{
	private int loanID;
	private String clientName;
	private float amtOfLoan;
	private float interest;
	private int term;
	
	public Loan(){
		this.clientName = "No Name";
		this.amtOfLoan = 0;
		this.interest = 0;
		this.term = 1;
		this.loanID++;
	}
	public Loan(String clientName, float amtOfLoan, float interest, int term){
		this.clientName = clientName;
		this.setAmtOfLoan(amtOfLoan);
		this.interest = interest;
		this.setTerm(term);
		this.loanID++;
	}
	
	public int getLoanID(){
		return this.loanID;
	}
	public String getClientName(){
		return this.clientName;
	}
	public float getAmtOfLoan(){
		return this.amtOfLoan;
	}
	public float getInterest(){
		return this.interest;
	}
	public int getTerm(){
		return this.term;
	}
	
	public void setLoanID(int loanID){
		this.loanID = loanID;
	}
	public void setClientName(String clientName){
		this.clientName = clientName;
	}
	public void setAmtOfLoan(float amtOfLoan){
		if(amtOfLoan>maxLoan){
			amtOfLoan = maxLoan;
			System.out.println("Loan amount too high. Setting loan to max loan amount.");
		}
		
		this.amtOfLoan = amtOfLoan;
	}
	public void setInterest(float interest){
		this.interest = interest;
	}
	public void setTerm(int term){
		if(term>longTerm){
			term = longTerm;
		}
		else if(term>mediumTerm){
			term = mediumTerm;
		}
		else{
			term = shortTerm;
		}
		this.term = term;
	}
	
	public float calculateLoan(){
		float totalAmt = this.getAmtOfLoan() + (this.getAmtOfLoan()*this.getInterest());
		return totalAmt;
		
	}
	
	public String toString(){
		String loanString = "";
		
		loanString = "\n===================================";
		loanString = loanString + "\nID Number: " + this.getLoanID() + "\nName: " + this.getClientName();
		loanString = loanString + "\nLoan: " + this.getAmtOfLoan() + "\nInterest: " + this.getInterest();
		loanString = loanString + "\nTerm: " + this.getTerm() + "\nTotal Amount Owed: " + this.calculateLoan();
		
		return loanString;
	}
}