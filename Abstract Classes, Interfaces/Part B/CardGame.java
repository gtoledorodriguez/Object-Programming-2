package service;
import java.util.Vector;
import service.Card;
import java.util.Random;

public abstract class CardGame{
	public Vector<Card> deck = new Vector<Card>(52);
	public int numOfCDealt;
	Random random = new Random();
	
	public CardGame(){
		for(int i=1;i<5;++i){
			for(int j=1;j<14;++j){
				deck.add(new Card(i,j));
			}			
		}
	}
	
	public void shuffle(){
		int shuffleNum = 315;
		for(int i = 0; i<shuffleNum; i++){
			int shuff = random.nextInt(52);
			this.deck.add(this.deck.remove(shuff));
		}
	}
	
	public abstract String displayDescription(); 
	// displays a brief description of the game in each of the child classes
	
	public abstract Vector deal(); 
	//  deals the appropriate number of Card objects to one player of a game
}