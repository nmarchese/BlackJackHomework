package cardGame;

public class Card implements Comparable<Card> {
	private Rank rank;
	private Suit suit;
	private int value;
	private String suitU;
	private boolean isAce;

	public Card(Rank r, Suit s) {
		rank = r;
		suit = s;
		value = r.getBlackjackValue();
		suitU = s.getSuitC();
		if (value == 11) {
			isAce = true;
		} else {
			isAce = false;
		}
	}
	
	public void aceToOne() {
		if (value == 11);
		value = 1;
	}
	
	public boolean isAce() {
		return isAce;
	}

	public Card(int value, char suitC) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Card o) {
		int rCompare = this.rank.compareTo(o.rank);
		int sCompare = this.suit.compareTo(o.suit);

		return (rCompare == 0) ? sCompare : rCompare;
	}

	@Override
	public String toString() {
		return (rank + " of " + suit + suitU).toLowerCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
}
