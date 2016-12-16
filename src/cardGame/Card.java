package cardGame;

public class Card implements Comparable<Card> {
	private Rank rank;
	private Suit suit;

	public Card(Rank r, Suit s) {
		rank = r;
		suit = s;
	}

	@Override
	public int compareTo(Card o) {
		int rCompare = this.rank.compareTo(o.rank);
		int sCompare = this.suit.compareTo(o.suit);
		
		if (rCompare == 0) {
			return sCompare;
		} else {
			return rCompare;
		}
	}

	@Override
	public String toString() {
		return (rank + " of " + suit).toLowerCase();
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
