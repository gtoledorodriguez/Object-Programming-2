package client;
import service.Loan;
import service.BusinessLoan;
import service.PersonalLoan;
import java.util.Scanner;
import java.lang.String;
import java.lang.Float;

public class CreateLoans{
	Loan[] Loans;
	public static void main(String[] args){
		CreateLoans client = new CreateLoans();
		
		Scanner scan = new Scanner(System.in);
		float primeIRate;
		int numLoans=5;
		client.Loans=new Loan[numLoans];
		
		System.out.println("Enter the prime interest rate: ");
		if(scan.hasNextFloat()){
			primeIRate = scan.nextFloat();
		}
		String clientName;
		float amtOfLoan;
		float interest;
		int term;
		Loan loanType = null;
		
		for(int i = 0; i<client.Loans.length; i++){
			System.out.println("Enter Loan Information.");
			
			System.out.println("Enter your last name: ");
			clientName = scan.next();
			
			System.out.println("Enter Loan Amount");
			String amt = scan.next();
			amtOfLoan = Float.parseFloat(amt);
			if(amtOfLoan>Loan.maxLoan){
				System.out.println("Loan amount too large.\nSetting loam amount to max amount.");
				amtOfLoan = Loan.maxLoan;
			}
			
			System.out.println("Enter Interest Rate");
			interest = scan.nextFloat();
			
			System.out.println("Enter Loan Term.");
			System.out.println("Type Short, Medium, or Long.");
			String sTerm= scan.next();
			if(sTerm.contentEquals("Short")){
				term=Loan.shortTerm;
			}else if(sTerm.contentEquals("Medium")){
				term=Loan.mediumTerm;
			}else if(sTerm.contentEquals("Long")){
				term=Loan.longTerm;
			}else{
				term=Loan.shortTerm;
			}
			
			System.out.println("Enter Loan Type.");
			System.out.println("Type Business or Personal.");
			String type = scan.next();
			if(type.contentEquals("Business")){
				loanType = new BusinessLoan(clientName, amtOfLoan, interest, term);
			}else if(type.contentEquals("Personal")){
				loanType = new PersonalLoan(clientName, amtOfLoan, interest, term);
			}
			else{
				System.out.println("Incorrect Loan Type. Try again.");
			}
			
			client.Loans[i] = loanType;
		}
		
		for(int i = 0; i<client.Loans.length; i++){
			System.out.println(client.Loans[i].toString());
		}
	}
}