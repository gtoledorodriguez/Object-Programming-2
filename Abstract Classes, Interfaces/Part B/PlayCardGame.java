package client;
import service.CardGame;
import service.Card;
import service.game.Poker;
import service.game.Bridge;
import java.util.Vector;

public class PlayCardGame{
	public void cardsInHand(Vector <Card> deck){
		System.out.println("Player's Cards: ");
		for(int i=0;i<deck.size();++i){
			System.out.println("\nCard " + i + " : ");
			System.out.println(deck.get(i).toString());
		}
	}
	
	public static void main(String[] args){
		PlayCardGame player = new PlayCardGame();
		
		Poker pGame = new Poker();
		Vector<Card> pHand= pGame.deal();
		System.out.println("Poker Game.");
		System.out.println(pGame.displayDescription());
		player.cardsInHand(pHand);
		
		Bridge bGame = new Bridge();
		Vector<Card> bHand= bGame.deal();
		System.out.println("Bridge Game.");
		System.out.println(bGame.displayDescription());
		player.cardsInHand(bHand);
	}
}