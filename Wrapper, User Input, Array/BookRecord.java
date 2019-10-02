package library.service.classes;
import library.service.classes.BookGenre;

public class BookRecord{
	int id= 0;
	static int id2 = 10000;
	int amtOfBooks;
	String title;
	String authorsList;
	BookGenre genre;
	
	public BookRecord(){
		genre = null;
		
		title = " ";
		amtOfBooks = 0;
		authorsList = "";
		id++;
	}
	public BookRecord(BookGenre genreType){
		genre = genreType;
		
		title = " ";
		amtOfBooks = 0;
		authorsList = "";
		id2++;
	}
	
	public BookGenre getGenre(){
		return genre;
	}
	
	public int getId(){
		return id2;
	}
	public void setAmtOfBooks(int books){
		amtOfBooks = books;
	}
	public int getAmtOfBooks(){
		return amtOfBooks;
	}
	
	public void setTitle(String bookTitle){
		title = bookTitle;
	}
	public String getTitle(){
		return title;
	}
	
	public void setAuthorList(String authors){
		authorsList = authors;
	}
	public String getAuthorList(){
		return authorsList;
	}
	
	public boolean equals(BookGenre genreObject){
		if(true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		return "\nTitle: " + title + "\nGenre: " + genre + "\nAuthors: " + authorsList + "\n===================================\n";
	}
	
}