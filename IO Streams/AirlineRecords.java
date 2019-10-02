import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AirlineRecords{
	public static void main(String[] args){
		FileInput Strea file;
		Buffered Reader filereader;
		
		try{
			file = new FileInputStream( new File( "flights.txt" ) );
			while ( file.hasNext( ) ) // test for the end of the file
			{
				String stringRead = file.nextLine( ); // read a line
				Scanner parse = new Scanner( stringRead ); // process the line read
				
				parse.useDelimiter( "," );
				
				String flightNumber = parse.next( );
				String origin = parse.next( );
				String destination = parse.next( );
				//code to process these tokens (origin, destination, etc)
			}
		}
		catch(IOException e){
			System.out.println("Text Errors");
		}
	}
}