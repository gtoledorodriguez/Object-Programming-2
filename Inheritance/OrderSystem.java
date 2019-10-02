package service;
public class OrderSystem{
	
	private static int counter = 1000;
	public int orderID;
	public String customerID;
	public String productID;
	public String orderDate;
	public int orderAmt;
	
	public OrderSystem(){
		this.orderID = this.counter;
		this.customerID = "";
		this.productID = "A1";
		this.orderDate = "99/99/9999";
		this.orderAmt = 0;
		this.counter++;
	}
	public OrderSystem(String customerID, String productID, String orderDate, int orderAmt){
		this.orderID = this.counter;
		this.customerID = customerID;
		this.productID = productID;
		this.orderDate = orderDate;
		this.orderAmt = orderAmt;
		this.counter++;
	}
	
	public int getOrderID(){
		return this.orderID;
	}
	public String getCustomerID(){
		return this.customerID;
	}
	public String getProductID(){
		return this.productID;
	}
	public String getOrderDate(){
		return this.orderDate;
	}
	public int getOrderAmt(){
		return this.orderAmt;
	}
	
	public void setCustomerID(String customerID){
		this.customerID = customerID;
	}
	public void setProductID(String productID){
		this.productID = productID;
	}
	public void setOrderDate(String orderDate){
		this.orderDate = orderDate;
	}
	public void setOrderAmt(int orderAmt){
		this.orderAmt = orderAmt;
	}
	
	public String toString(){
		String systemStr;
		systemStr= "Order ID: " + this.orderID +"\n";
		systemStr=systemStr + "Customer ID: " + this.customerID +"\n";
		systemStr=systemStr + "Product ID: " + this.productID +"\n";
		systemStr=systemStr + "Date of Order: " + this.orderDate +"\n";
		systemStr=systemStr + "Amount Ordered: " + this.orderAmt +"\n";
		return systemStr;
	}
}