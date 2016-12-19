package cardGame;

public class CardPlayer {
	private Hand hand;
	private String name;
	private int wallet;
	
	public CardPlayer(String name) {
		this.name = name;
		hand = new Hand();
		wallet = 200;
	}
	
	public String name() {
		return name;
	}
	
	public void aceToOne() {
		hand.aceToOne();
	}
	
	public boolean hasAce() {
		return (hand.hasAce()) ? true : false;
	}
	
	// Wallet methods
	public int getWallet() {
		return wallet;
	}
	
	public void updateWallet(int walletChange) {
		wallet += walletChange;
	}
	
	// Hand methods
	public Hand getHand() {
		return hand;
	}
	
	public void addToHand(Card card) {
		hand.addCard(card);
	}
	
	public void showHand() {
		hand.showHand();
	}

	public Card showCard(int pos) {
		return hand.showCard(pos);
	}
	
	public Card showCard() {
		return hand.showCard();
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public int upCardValue() {
		return hand.getCardValue(0);
	}
	
	public void resetHand() {
		hand.resetHand();
	}
}
