package cardGame;

public class CardPlayer {
	private Hand hand;
	private String name;
	private int wallet;
	private int bet;
	private boolean blackjack;;
	private boolean wonHand;

	public CardPlayer() {
		hand = new Hand();
		wallet = 200;
		blackjack = false;
		wonHand = false;
		bet = 0;
		name = "";
	}
	
	public CardPlayer(String name) {
		this.name = name;
		hand = new Hand();
		wallet = 200;
		blackjack = false;
		wonHand = false;
		bet = 0;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String name() {
		return name;
	}
	
	public boolean getWonHand() {
		return wonHand;
	}

	public void setWonHand(boolean wonHand) {
		this.wonHand = wonHand;
	}

	public void setBlackjack(boolean blackjack) {
		this.blackjack = blackjack;
	}
	
	public boolean getBlackjack() {
		return blackjack;
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	public int getBet() {
		return bet;
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
