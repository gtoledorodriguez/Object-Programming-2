package service.order;
import service.OrderSystem;
import service.OrderType;

public class Orders extends OrderSystem{
	OrderType order;
	int period;
	String endDate;
	
	public Orders(){
		this.order = null;
		this.period = 0;
		this.endDate = "99/99/9999";
	}
	public Orders(OrderType order){
		this.order = order;
	}
	public Orders(OrderType order, int period, String endDate){
		this.order = order;
		this.period = period;
		this.endDate = endDate;
	}
	public Orders(OrderType order, String customerID, String productID, String orderDate, int orderAmt){
		super();
		this.order = order;
		super.setCustomerID(customerID);
		super.setProductID(productID);
		super.setOrderDate(orderDate);
		super.setOrderAmt(orderAmt);
	}
	public Orders(OrderType order, int period, String endDate, String customerID, String productID, String orderDate, int orderAmt){
		super();
		this.order = order;
		this.period = period;
		this.endDate = endDate;
		super.setCustomerID(customerID);
		super.setProductID(productID);
		super.setOrderDate(orderDate);
		super.setOrderAmt(orderAmt);
	}
	
	public OrderType getOrderType(){
		return this.order;
	}
	public int getPeriod(){
		return this.period;
	}
	public String getEndDate(){
		return this.endDate;
	}
	public String getCustomerID(){
		return super.getCustomerID();
	}
	public int getOrderID(){
		return super.getOrderID();
	}
	
	public void setPeriod(int period){
		this.period = period;
	}
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	
	public String toString(){
		String Break = "===================================\n";
		
		String orderTypeStr;
		if(this.getOrderType().equals(OrderType.R)){
			orderTypeStr= Break + "Order Type: " + this.getOrderType() +"\n";
			orderTypeStr= orderTypeStr + super.toString();
			orderTypeStr= orderTypeStr + "Period: " + this.getPeriod() +"\n";
			orderTypeStr= orderTypeStr + "End Date: " + this.getEndDate() +"\n";
			orderTypeStr= orderTypeStr + Break;
		}
		else{
			orderTypeStr= Break + "Order Type: " + this.getOrderType() +"\n";
			orderTypeStr=orderTypeStr + super.toString();
			orderTypeStr= orderTypeStr + Break;
		}
		return orderTypeStr;
	}
}