package client;
import service.OrderType;
import service.OrderSystem;
import service.order.Orders;
import service.order.Orders;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.util.Vector;

public class Customer{
	static Vector<Orders> orders; //array of objects
	Customer(){
		orders = new Vector();
	}
	
	public void searchByCustmerID(String customerID){
		for(int i = 0; i<orders.size(); i++){
			if((orders.elementAt(i).getCustomerID()).contentEquals(customerID)){
				System.out.println(orders.elementAt(i).toString());
			}
		}
	}
	public int searchByOrderID(int orderID){
		int index = 0;
		for(int i = 0; i<orders.size(); i++){
			if((orders.elementAt(i).getOrderID())==orderID){
				System.out.println(orders.elementAt(i).toString());
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args){
		
		/*				Part A
		Orders obj1 = new Orders(OrderType.O);
		Orders obj2 = new Orders(OrderType.O, "Google", "B2", "01/01/2001", 12);
		Orders obj3 = new Orders(OrderType.R, 15, "01/31/2001");
		Orders obj4 = new Orders(OrderType.R, 10, "01/31/2001", "FaceBook", "C3", "01/01/2001", 34);
		OrderSystem obj5 = new OrderSystem("Microsoft", "E5", "01/31/2001", 10);
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());
		System.out.println(obj4.toString());
		System.out.println(obj5.toString());
		*/
		Scanner scan = new Scanner(System.in);
		
		Customer client = new Customer();
		//read the the files from text files
		
		Orders oOrder;
		Orders rOrder;
		Scanner scanner;
		String str;
		try {
			File myFile=new File("orders.txt");
            scanner=new Scanner(myFile);
			while(scanner.hasNextLine()){
				str=scanner.nextLine();			
				String []tok=str.split(",");
				OrderType type = OrderType.valueOf(tok[0]);
				int orderAmt = Integer.parseInt(tok[4]);
				if(tok[0].contentEquals("R")){
					int period = Integer.parseInt(tok[5]);
					rOrder = new Orders(type, period, tok[6], tok[1], tok[2], tok[3], orderAmt);
					client.orders.add(rOrder);
				}
				if(tok[0].contentEquals("O")){
					oOrder = new Orders(type, tok[1], tok[2], tok[3], orderAmt);
					client.orders.add(oOrder);
				}
			}
			scanner.close();
        }catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}
		
		String option1;
		while(true){
			System.out.println("Select an option:");
			System.out.println("Type \"A\" to add an order");
			System.out.println("Type \"D\" to delete an order");		
			System.out.println("Type \"L\" to list all your orders");
			System.out.println("Type \"Q\" to Quit");
			option1=scan.nextLine();
			
			switch (option1) {
				case "A":	System.out.println("Is this a repeated order?\nType YES or NO");
							String a = scan.nextLine();
							if(a.contentEquals("YES")){
								System.out.println("Customer ID: ");
								String customer = scan.nextLine();
								System.out.println("What is the product ID?");
								String pID = scan.nextLine();
								System.out.println("The amount of product? Type an integer");
								String oAmt = scan.nextLine();
								int orderAmt = Integer.parseInt(oAmt);
								System.out.println("For what period is the order? Type an integer");
								String period = scan.nextLine();
								int p = Integer.parseInt(period);
								System.out.println("When should we start sending the order? Format MM/DD/YYYY");
								String sd = scan.nextLine();
								System.out.println("When should we stop sending the order? Format MM/DD/YYYY");
								String ed = scan.nextLine();
								
								Orders newOrder = new Orders(OrderType.R, p, ed, customer, pID, sd, orderAmt);
								client.orders.add(newOrder);
								
								System.out.println("Your order is shown below. Please remember your order ID.");
								System.out.println(newOrder.toString());
							}
							else{
								System.out.println("Customer ID: ");
								String customer = scan.nextLine();
								System.out.println("What is the product ID?");
								String pID = scan.nextLine();
								System.out.println("The amount of product? Type an integer");
								String oAmt = scan.nextLine();
								int orderAmt = Integer.parseInt(oAmt);
								System.out.println("When should we send the order? Format MM/DD/YYYY");
								String od = scan.nextLine();
								
								Orders newOrder = new Orders(OrderType.O, customer, pID, od, orderAmt);
								client.orders.add(newOrder);
								
								System.out.println("Your order is shown below. Please remember your order ID.");
								System.out.println(newOrder.toString());
							}
							
							break;
							 
				case "D":   System.out.println("Are you sure you want to delete?\nType YES or NO");
							String z = scan.nextLine();
							if(z.contentEquals("YES")){
								System.out.println("What is your Order ID? Type an integer");
								String oID = scan.nextLine();
								int orderID = Integer.parseInt(oID);
								orders.remove(client.searchByOrderID(orderID));
								System.out.println("This order has been deleted.\n");
							}
							else{
								break;
							}
							break;
				
				case "Q":   System.out.println("Quitting program");
							System.exit(0);
							
				case "L":	System.out.println("What is your customer ID?");
							String customerID = scan.nextLine();
							client.searchByCustmerID(customerID);
							break;
							
				default:	System.out.println("Wrong option! Try again");
							break;
			
			}
			
		}
	}
}