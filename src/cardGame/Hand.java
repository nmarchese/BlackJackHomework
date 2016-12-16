package cardGame;

import java.util.*;

public class Hand {
	List<Card> hand;
	
	public Hand() {
		hand = new LinkedList<>();
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public int getHandValue() {
		int value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
	}
	
	public void showHand() {
		for (Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Total Value: " + getHandValue());
	}
}
