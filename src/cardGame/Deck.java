package cardGame;

import java.util.*;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = new LinkedList<>();

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
	}
	
	public void printDeck() {
		for (Card card : deck) {
			System.out.println(card);
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public int cardsRemaining() {
		return deck.size();
	}
}
