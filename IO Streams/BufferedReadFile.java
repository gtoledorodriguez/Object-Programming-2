import java.io.*;
import java.util.*;
 public class BufferedReadFile
 {
   public static void main( String [] args )
   {
     FileInputStream file;
     BufferedReader filereader;
	 try
     {
        //BufferedReader file = new BufferedReader(new FileReader("flights.txt"));
		file=new FileInputStream("flights.txt");
		filereader=new BufferedReader(new  InputStreamReader(file));
		String stringRead;
		while ( (stringRead=filereader.readLine()) !=null ) // read a line and test for the end of the file
		{			
			Scanner parse = new Scanner( stringRead ); // process the line read
			parse.useDelimiter(",");
            String flightNumber = parse.next();
            String origin = parse.next();
            String destination = parse.next();
			int noPassengers = parse.nextInt();
			float price = parse.nextFloat();
			//code to process these tokens (origin, destination, etc)
			System.out.println("Flight number: " + flightNumber);
			System.out.println("Origin: " + origin);
			System.out.println("Destination: " + destination);
			System.out.println("Passengers: " + noPassengers);
			System.out.println("Price: " + price);
			System.out.println("==================================");
		}
		filereader.close();
     }
	 catch (IOException e)
	 {
		 System.out.println( "Text errors" );
	 }	 
   }
}  
