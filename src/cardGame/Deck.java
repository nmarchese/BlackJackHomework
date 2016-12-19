package cardGame;

import java.util.*;

public class Deck {
	private List<Card> deck;

	public Deck(int decksInShoe) {
		deck = new LinkedList<>();
		for (int i = 0; i < decksInShoe; i++)
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

	public int deckValueRemaining() {
		int value = 0;
		for (Card card : deck) {
			value += card.getValue();
		}
		return value;
	}
}
