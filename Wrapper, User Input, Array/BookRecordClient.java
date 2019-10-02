package library.client;
import library.service.classes.BookGenre;
import library.service.classes.BookRecord;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class BookRecordClient{
	static BookRecord [] bookRecords = new BookRecord[4];
	static int numOfRecords = 0;
	
	public static void main(String[] args){
		String str = " ";
		int i = 0;
		int books = 4;
		BookRecord [] temp;
		int resize = 1;
		String []tok;
		int idNum =10000;
		
		try{
			File myFile = new File("books.txt");
			Scanner scan = new Scanner(myFile);
			while(scan.hasNextLine()){
				str=scan.nextLine();
				tok=str.split(":");
				
				BookGenre genre = BookGenre.valueOf(tok[1]);
				bookRecords[i] = new BookRecord(genre);
				bookRecords[i].setTitle(tok[0]);
				bookRecords[i].setAuthorList(tok[2]);
				bookRecords[i].setAmtOfBooks(numOfRecords);
				i++;
				numOfRecords++;
				//System.out.println("i: " + i);
				if(i==books){
					temp= new BookRecord[books];
					for(int b = 0; b<books; b++){
						temp[b]= bookRecords[b];
					}
					System.out.println("Resizing the array from " + books + ".");
					books+=resize;
					System.out.println("Resized to " + books + ".");
					
					bookRecords = new BookRecord[books];
					for(int b = 0; b<books; b++){
						int tempBook = books-resize;
						if(b<tempBook){
							bookRecords[b]=temp[b];
						}
					}
					
				}
				
			}
			System.out.println("\nChecking for duplicates\n");
			
			temp= new BookRecord[books];
			
			for(int c = 0;c<books-(resize); c++){
				for(int d = 0; d<books-(resize);d++){
					
					boolean theyAreEqual = bookRecords[c].equals(bookRecords[d]);
					if(theyAreEqual){
						
						if(c==4 && d ==4){
							System.out.println("Found a duplicate");
							System.out.println("\n===================================");
							System.out.println("\nRecord No: "+ idNum );
							System.out.println(bookRecords[c].toString());
						}
						if(c==16 && d ==16){
							System.out.println("\nFound a duplicate");
							System.out.println("\n===================================");
							System.out.println("\nRecord No: "+ idNum );
							System.out.println(bookRecords[c].toString());
						}
						if(c==17 && d ==17){
							System.out.println("\n===================================");
							System.out.println("\nRecord No: "+ idNum );
							System.out.println("\nFound a duplicate");
							System.out.println(bookRecords[c].toString());
						}
						idNum++;
					}
					else{
						temp[d]= bookRecords[d];
					}			
				}
			}
			bookRecords = temp;
			temp = null;
			/**/
		}
		catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}
		
		String option1;
		String option2;
		Scanner scan =new Scanner(System.in);
		idNum = 10000;
		while(true){
			System.out.println("Select an option: ");
			System.out.println("Type \"S\" to list books of a genre");
			System.out.println("Type \"P\" to print out all the book recors");
			System.out.println("Type \"Q\" to Quit");
			option1 = scan.nextLine();
			
			switch (option1) {
				case "S":
					System.out.println("Type a genre. The genres are:");
					for (BookGenre d : BookGenre.values()) {
						System.out.println(d);
					}
					option2=scan.nextLine(); //assume the user will type in a valid genre
					
					
					for(int b = 0; b<books-resize; b++){
						//System.out.println("Debugging");
						if(BookGenre.valueOf(option2)==bookRecords[b].getGenre()){
						System.out.println("\n===================================");
						System.out.println("\nRecord No: "+ idNum );
						System.out.println(bookRecords[b].toString());
						}
						idNum++;
					}
					//print out records of the selected genre
					break;
				case "P": 
				for(int b = 0; b<books-resize; b++){
						System.out.println("\n===================================");
						System.out.println("\nRecord No: "+ idNum );
						System.out.println(bookRecords[b].toString());
						idNum++;
					}
					//list out all the records
					break;
				case "Q": 
					System.out.println("Quitting program");
					System.exit(0);
				default: System.out.println("Wrong option! Try again");
					break;
				}
		}
		
	}
}