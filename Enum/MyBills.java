package client.services.classes;
import client.services.BillsType;

public class MyBills{
	private String month;
	private BillsType expenses;
	private int numOfDays;
	private double [] expensesArray;
	private int trackingID;
	static int trackingID2;
	
	public MyBills(){
		month = "any month";
		expenses = null;
		numOfDays = 0;
		expensesArray = new double[numOfDays];
		
		trackingID ++;
	}
	
	public MyBills(BillsType expenseType){
		expenses = expenseType;
		
		month = "any month";
		numOfDays = 0;
		expensesArray = new double[numOfDays];
		
		trackingID2 ++;
	}
	
	public void setMonth(String newMonth){
		month = newMonth;
	}
	public String getMonth(){
		return month;
	}
	
	
	public void setNumOfDays(int dayNum){
		numOfDays = dayNum;
	}
	public int getNumOfDays(){
		return numOfDays;
	}
	
	public void setExpensesArray(double[] amount){
		expensesArray= amount;
	}
	
	public double [] getExpensesArray(){
		return expensesArray;
	}
	
	private String expenseString(double[] doubleArray){
		String empty =" ";
		for(int i =0; i<trackingID2-1;i++){
			empty+= doubleArray[i] + ", ";
		}
		return empty;
	}
	
	public String toString(){
		return "The month is: " + this.month + ". The type of expenses is " + expenses + ". The amounts are " + expenseString(expensesArray) + ". The number of days for data is " + numOfDays + ". The expense object ID is " + trackingID + " And the static id value is " + trackingID2 + ". \n";

	}
	
}