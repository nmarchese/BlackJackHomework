package cardGame;

import java.util.*;

public class Hand {
	private List<Card> hand;
	
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
	
	public void resetHand() {
		hand = new LinkedList<>();
	}
	
	public Card showCard(int pos) {
		return hand.get(pos - 1);
	}
	public Card showCard() {
		return hand.get(hand.size()-1);
	}
	
	public int getCardValue(int pos) {
		return hand.get(pos).getValue();
	}
	
}
