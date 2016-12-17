package cardGame;

import java.util.*;

public class Hand {
	private List<Card> hand;
	private boolean hasAce;
	
	public Hand() {
		hand = new LinkedList<>();
		hasAce = false;
	}
	
	public void addCard(Card card) {
		hand.add(card);
		if (card.isAce()) {
			hasAce = true;
		}
	}
	
	public boolean hasAce() {
		if (hasAce) {
			hasAce = false;
			return true;
		} else {
			return false;
		}
	}
	
	public void aceToOne() {
		for (Card card : hand) {
			if (card.getValue() == 11) {
				card.aceToOne();
			}
		}
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
