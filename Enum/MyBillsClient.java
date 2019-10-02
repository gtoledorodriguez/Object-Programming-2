package client;
import client.services.classes.MyBills;
import client.services.BillsType;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class MyBillsClient{
	public String[] totalExpensesPerMonth(MyBills[] bill2){
		String[] stringArray = new String[48];
		String[] month = {"JANUARY","FEBUARY", "MARCH", "APRIL", "MAY","JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER","NOVEMBER","DECEMBER"};
		double[] expensesSum = new double[48];
		
		String str = " ";
		int expType = 3;
		double amt = 0;
		int r = 0;
		try{
			
			File myFile = new File("myexpenses.txt");
			Scanner scan = new Scanner(myFile);
			while(scan.hasNextLine()){
				str=scan.nextLine();
				String[] tok = str.split(":");
				
				str=scan.nextLine();
				String[] tok2 = str.split(",");
				
				for(int b =0; b<tok2.length; b++){
					amt += Double.parseDouble(tok2[b]);
					
					
				}
				expensesSum[r] = amt;
				r++;
			}
			
		}
		catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}


		boolean in = false;
		double[] sum = new double[48];
		int whichMonth = -1;
		int monthLength = -1;
		
		for(int i = 0; i<expensesSum.length;i++){
			//System.out.println("ExpenseSum: "+expensesSum[i]);
			
			for(int s = 0; s<4; s++){
				sum[0] += expensesSum[s];
			}
			for(int s = 4; s<8; s++){
				sum[1] += expensesSum[s];
			}for(int s = 8; s<12; s++){
				sum[2] += expensesSum[s];
			}
			for(int s = 12; s<16; s++){
				sum[3] += expensesSum[s];
			}
			for(int s = 16; s<20; s++){
				sum[4] += expensesSum[s];
			}
			for(int s = 20; s<24; s++){
				sum[5] += expensesSum[s];
			}
			for(int s = 24; s<28; s++){
				sum[6] += expensesSum[s];
			}
			for(int s = 28; s<32; s++){
				sum[7] += expensesSum[s];
			}
			for(int s = 32; s<36; s++){
				sum[8] += expensesSum[s];
			}
			for(int s = 36; s<40; s++){
				sum[9] += expensesSum[s];
			}
			for(int s = 40; s<44; s++){
				sum[10] += expensesSum[s];
			}
			for(int s = 44; s<48; s++){
				sum[11] += expensesSum[s];
			}
		}

		for(int i =0; i< month.length; i++){
			//System.out.println(i +" Month: "+ month[i]);
			System.out.println("Sum: " + sum[i]);
			stringArray[i] = "The total of all expenses for the month of" +  month[i] + "is : $" + sum[i];
		}
		
		return stringArray;
	}
	
	public static void main(String [] args){
		MyBills[] bills = new MyBills[100];
		double [] amount = new double[100];
		MyBillsClient[] client = new MyBillsClient[12];
		MyBills[] clientBill = new MyBills[12];
		
		for(int z =0; z<12;z++){
			client[z] = new MyBillsClient();
		}
		
		String str = " ";
		int month = 1;
		int expType = 3;
		int i =0;
		try{
			
			File myFile = new File("myexpenses.txt");
			Scanner scan = new Scanner(myFile);
			while(scan.hasNextLine()){
				str=scan.nextLine();
				String[] tok = str.split(":");
				
				BillsType bT= BillsType.valueOf(tok[expType]);
				bills[i] = new MyBills(bT);
				bills[i].setMonth(tok[month]);
				
				str=scan.nextLine();
				String[] tok2 = str.split(",");
				
				for(int b =0; b<tok2.length; b++){
					double amt = Double.parseDouble(tok2[b]);
					
					bills[i].setNumOfDays(tok2.length);
					
					amount[b] = amt;
				}
				bills[i].setExpensesArray(amount);
				i++;
			}
			
		}
		catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}
		System.out.println("\nOutput #1\n");
		for(int v = 0; v<i; v++){
			System.out.println(bills[v].toString());
		}
		
		System.out.println("\nOutput #2\n");
		
		//for(int q =0; q<12; q++){
			System.out.println("The total of all expenses for the month of" + client[0].totalExpensesPerMonth(bills));
		//}
	}
}