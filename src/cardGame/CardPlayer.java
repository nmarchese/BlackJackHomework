package cardGame;

public class CardPlayer {
	private Hand hand;
	private String name;
	
	public CardPlayer(String name) {
		this.name = name;
		hand = new Hand();
	}
	
	public String name() {
		return name;
	}
	
	public Hand getHand() {
		return hand;
	}
}
