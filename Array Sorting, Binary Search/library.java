package library.client.classes;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import library.service.classes.BookGenre;
import library.service.classes.BookRecord;
import java.util.Vector;

class library{
	/*Task 1: Declare the vector of objects*/
	static Vector<BookRecord> v;
	
	library(){
		/* Task 2: Initiliaze vector*/
		v = new Vector();
	
		/* Task 3: Print out its capacity and its size*/
		System.out.println("The capacity is " + v.capacity() + ".\nThe size is " + v.size() + ".");
	
	}
	
	public void searchByGenre(BookGenre genre){//search the vector for records of specific genre
		/* Task 5: implement searchByGenre() to search for records of a particular genre in the vector*/
		
		for(int i = 0; i<v.size() ; i++){
			if(v.elementAt(i).getGenre().equals(genre)){
				System.out.println(v.elementAt(i).toString());
			}
		}
	}
	
	public void print(){//list the records
		/* Task 6: Implement the print() to list out the records*/
		for(int i = 0; i<v.size() ; i++){
			System.out.println(v.elementAt(i).toString());
		}
	}
	
		
	public static void main(String []args){//instantiate the library
	//arg[0]: text file
		
		library myLib = new library();
		//read the the files from text files
		String []authors;
		BookRecord aRecord;
		Scanner scan;
		String str;
		try {
			File myFile=new File("books.txt");
            scan=new Scanner(myFile);//each line has the format title:genre:author-name-1,author-name-2..authorname-m
			while(scan.hasNextLine()){
				str=scan.nextLine();				
				String []tok=str.split(":");
				authors=tok[2].split(",");
				aRecord = new BookRecord(tok[0],tok[1],authors);
				
				/*Task 4: Add the objects to the vector*/
				v.addElement(aRecord);
				//Debugging below
				//System.out.println("The capacity is " + v.capacity() + ".\nThe size is " + v.size() + ".");
	
			}
			scan.close();
        }catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}
		
		//User interactive part
		String option1, option2;
		scan = new Scanner(System.in);
		option1="";
		while(!option1.equals("Q")){
			System.out.println("Select an option:");
			System.out.println("Type \"S\" to list books of a genre");
			System.out.println("Type \"P\" to print out all the book recors");		
			System.out.println("Type \"Q\" to Quit");
			option1=scan.nextLine();
			
			switch (option1) {
				case "S":	System.out.println("Type a genre. The genres are:");
							for (BookGenre d : BookGenre.values()) {
									System.out.println(d);
							}
							option2=scan.nextLine(); //assume the user will type in a valid genre
							myLib.searchByGenre(BookGenre.valueOf(option2));//implement this method
							break;									
				
				case "P":   myLib.print();//print the array; implement this method	 
							break;
				
				case "Q":   System.out.println("Quitting interactive part");
							break;
							
				default:	System.out.println("Wrong option! Try again");
							break;
			
			}
		}
			/*Task 7- Create 2 dimensional array using the records from the vector
			The array has rows for GENRE_HISTORY, GENRE_SCIENCE, GENRE_ENGINEERING, GENRE_LITERATURE*/

			BookRecord [][] libAr; //declaration of the 2D array
			libAr = new BookRecord[4][];
			BookGenre gH = BookGenre.valueOf("GENRE_HISTORY");
			BookGenre gS = BookGenre.valueOf("GENRE_SCIENCE");
			BookGenre gE = BookGenre.valueOf("GENRE_ENGINEERING");
			BookGenre gL = BookGenre.valueOf("GENRE_LITERATURE");
			
	
			for (BookGenre d : BookGenre.values()) {//for each genre count the number of records belonging to it and then intantiate its row
			/*add code here*/
				int num = 0;
				for(int h = 0; h<v.size(); h++){
					if(gH == v.elementAt(h).getGenre()){
						libAr[0][num] = v.elementAt(h);
						num++;
					}
				}
				num = 0;
				for(int s = 0; s<v.size(); s++){
					if(gS == v.elementAt(s).getGenre()){
						libAr[1][num] = v.elementAt(s);
						num++;
					}
				}
				num = 0;
				for(int e = 0; e<v.size(); e++){
					if(gE == v.elementAt(e).getGenre()){
						libAr[2][num] = v.elementAt(e);
						num++;
					}
				}
				num = 0;
				for(int l = 0; l<v.size(); l++){
					if(gL == v.elementAt(l).getGenre()){
						libAr[3][num] = v.elementAt(l);
						num++;
					}
				}
				
			}
		
			System.out.println("Printing out the array. Type enter to proceed");
			option1=scan.nextLine();
			
			/*Task 8: Print out the array*/
			
			for(int i = 0;i<0; i++){
				for(int j = 0; j<0; j++){
					System.out.println(libAr[i][j]);
				}
			}
			
			
			System.out.println("Removing the duplicates. Type enter to proceed");
			option1=scan.nextLine();
			
			/* Task 9: Identify and remove the duplicate records IN THE VECTOR (NOT THE ARRAY) and print out the removed records */
			int[] counter = new int[3];
			int count = 0;
			for(int i = 0; i<v.size(); i++){
				for(int j = i+1; j< v.size(); j++){
					if(v.elementAt(i).equals(v.elementAt(j))){
						v.elementAt(j).toString();
						counter[count] = j;
						count++;
					}
				}
			}
			
			for(int c = 0; c<counter.length; c++){
				v.remove(c);
			}
			
						
			System.out.println("Note the record nos. of the duplicated records");
			
			System.out.println("Printing out the array. Type enter to proceed");
			option1=scan.nextLine();
			
			/* Task 10: print out the array again; are the duplicated printed out again? */
			myLib.print();
		}
}