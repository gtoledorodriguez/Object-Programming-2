package service;

public class Card{
	int suite; //1-heart 2-club 3-diamond 4-spade
	int value; //1-Ace, 2-10; 11-jack 12-queen 13-king
	
	public Card(){
		suite = 1;
		value = 1;
	}
	Card(int suite,int value){
			this.suite=suite;
			this.value=value;
	}
	
	public int getSuite(){
		return this.suite;
	}
	public int getValue(){
		return this.value;
	}
	
	public void setSuite(int suite){
		this.suite = suite;
	}
	public void setValue(int value){
		this.value = value;
	}
	
	public String toString(){
		String cardString = ""; 
		String s = "";
		String v = "";
		
		if(this.suite==1){
			s = "Heart";
		}
		else if(this.suite==2){
			s = "Club";
		}
		else if(this.suite==3){
			s = "Diamond";
		}
		else if(this.suite==4){
			s = "Spade";
		}
		
		if(this.value==13){
			v = "King";
		}
		else if(this.value==12){
			v = "Queen";
		}
		else if(this.value==11){
			v = "Jack";
		}
		else if(this.value==1){
			v = "Ace";
		}
		else{
			v = "" + this.value;
		}
			
		cardString = "Card: " + v + " of " + s;
		return cardString;
	}
}