package service.game;
import service.CardGame;
import service.Card;
import java.util.Vector;

public class Bridge extends CardGame{
	private int cardsPerPerson;
	
	public Bridge(){
		super();
		this.cardsPerPerson = 13;
	}
	
	public int getCardsPerPerson(){
		return this.cardsPerPerson;
	}
	
	public String displayDescription(){
		String str ="This is the game Bridge.\nEach person gets 13 Cards.";
		return str;
	}
	
	public Vector deal(){
		Vector <Card> cardsDealt = new Vector<Card>();
		for(int i = 0; i < this.cardsPerPerson;i++){
			if(super.deck.size()<this.cardsPerPerson){
				System.out.println("Not enough cards left for each person.");
				cardsDealt = null;
			}
			else{
				cardsDealt.add(super.deck.remove(0));
			}
		}
		return cardsDealt;
	}
}