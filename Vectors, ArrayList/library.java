package library.client.classes;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import library.service.classes.BookGenre;
import library.service.classes.BookRecord;
import java.lang.String;

class library{
	BookRecord []books; //array of objects
	int noRecords=0; //no of records; it is not the size of the array
	
	int index =0;
	BookRecord temp;
	int subArrayLength =0;
	int compare = 0;
	
	public void resize(int resizeFactor){//library to expand the array
		//initiatilize a new array with larger size and then copy the variables to
		int initSize = this.noRecords;
		BookRecord [] newArray = new BookRecord[initSize+resizeFactor];
		//copy the object over
		for(int i=0;i<this.books.length;++i){
			newArray[i]=this.books[i];
		}
		this.books=newArray;
		System.out.println("Resized the array from " + initSize + " to " + this.books.length);
		
	}
	public void searchByGenre(BookGenre genre){
		//loop through the book records and list the genre
		for(int i=0;i<this.noRecords;++i){
			if(this.books[i].getGenre()==genre){
				System.out.println(this.books[i].toString());
			}
		}
	}
	public boolean searchForDuplicate(BookRecord aRecord){
		//loop through the library and find duplicates
		//return true if duplicate found 
		//else return false
		if(this.noRecords==0) return false;
		for(int i=0;i<this.noRecords;++i){
			if(this.books[i].equals(aRecord))
				return true;
		}
		return false;
	}
	public void print(){//list the library
		for(int i=0;i<this.noRecords;++i){
			System.out.println(this.books[i].toString());
		}	
	}
	library(){
		this.books=new BookRecord[5];//intial size is 5		
	}
	public BookRecord[] sortString(BookRecord[] books, int noRecords){
		for(int j = 0; j<=this.noRecords-1;j++){
			this.subArrayLength=this.noRecords-j;
			this.index =0;
			for(int k =1; k<subArrayLength;k++){
				this.compare = this.books[k].getTag().compareTo(this.books[this.index].getTag());
				if(compare>0){
					this.index=k;
				}
			}
			this.temp=this.books[this.index];
			this.books[this.index]=this.books[this.noRecords-j-1];
			this.books[this.noRecords-j-1]=this.temp;
		}
		
		return this.books;
	}
	public BookRecord[] sortPages(BookRecord[] books, int noRecords){
		for(int j = 0; j<=this.noRecords-1;j++){
			this.subArrayLength=this.noRecords-j;
			this.index =0;
			for(int k =1; k<subArrayLength;k++){
				if(this.books[k].getNumOfPages()>this.books[this.index].getNumOfPages()){
					this.index=k;
				}
			}
			this.temp=this.books[this.index];
			this.books[this.index]=this.books[this.noRecords-j-1];
			this.books[this.noRecords-j-1]=this.temp;
		}
		
		return this.books;
	}
	
	public void searchTag(String tag, int noRecords){
		int start =0;
		int end = this.noRecords-1;
		while(end>=start){
			int middle = (start+end)/2;
			this.compare = this.books[middle].getTag().compareTo(tag);
			//System.out.println("Compare Value: " + compare);
			if(compare==0){
				System.out.println("Found a match.");
				System.out.println(this.books[middle].toString());
				end = -1;
			}
			else if(compare>0){
				end = middle-1; //search left
				//System.out.println("Searching Left");
				//System.out.println(this.books[middle].getTag());
			}
			else{
				start = middle+1; //search right
				//System.out.println("Searching Right");
				//System.out.println(this.books[middle].getTag());
			}
		}
		System.out.println("Tag not found.\n");
	}
	
	public static void main(String []args){//instantiate the library
	//arg[0]: text file //arg[1]: resize factor
		int resizeFactor = Integer.parseInt("5");
		library myLib = new library();
		//read the the files from text files
		String []authors;
		BookRecord aRecord;
		Scanner scan;
		String str;
		int pages;
		
		try {
			File myFile=new File("books.txt");
            scan=new Scanner(myFile);//each line has the format title:genre:author-name-1,author-name-2..authorname-m
			while(scan.hasNextLine()){
				str=scan.nextLine();				
				String []tok=str.split(":");
				authors=tok[2].split(",");
				pages = Integer.parseInt(tok[4]);
				aRecord = new BookRecord(tok[0],tok[1],authors,tok[3],pages);
				
				//check for duplicate records
				if (!myLib.searchForDuplicate(aRecord)){
					//create a BookRecord object and load it on the array
					myLib.books[myLib.noRecords] = aRecord;
					myLib.noRecords++;
					//System.out.println("No of records: " + myLib.noRecords);
				}
				else{
					System.out.println("Found a duplicate");
					System.out.println(aRecord.toString());
				}
				//check if the array needs to resize
				if(myLib.books.length == myLib.noRecords){ //need to add additional space
					myLib.resize(resizeFactor);
				}
			}
			scan.close();
			myLib.sortString(myLib.books, myLib.noRecords);
        }catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}
		
		//User interactive part
		String option1, option2, option3;
		scan = new Scanner(System.in);
		while(true){
			System.out.println("Select an option:");
			System.out.println("Type \"S\" to list books of a genre");
			System.out.println("Type \"P\" to print out all the book records");	
			System.out.println("Type \"T\" to search for a record with a specific tag");
			System.out.println("Type \"Q\" to Quit");
			option1=scan.nextLine();
			
			switch (option1) {
				case "S":	System.out.println("Type a genre. The genres are:");
							for (BookGenre d : BookGenre.values()) {
									System.out.println(d);
							}
							option2=scan.nextLine(); //assume the use will type in a valid genre
							myLib.sortPages(myLib.books, myLib.noRecords);
							myLib.searchByGenre(BookGenre.valueOf(option2));
							break;
							 
				case "P":   myLib.sortString(myLib.books, myLib.noRecords);
							myLib.print();	 
							break;
				
				case "T":   System.out.println("\nInput the tag of the book you want to search for:");
							option3=scan.nextLine(); //assume the use will type in a valid genre
							myLib.sortString(myLib.books, myLib.noRecords);
							myLib.searchTag(option3,myLib.noRecords);
							break;
							
				
				case "Q":   System.out.println("Quitting program");
							System.exit(0);
							
				default:	System.out.println("Wrong option! Try again");
							break;
			
			}
			
		}
			 
	}
	
}