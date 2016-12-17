package cardGame;

public enum Suit {
    HEARTS("\u2661"), SPADES("\u2664"), CLUBS("\u2667"), DIAMONDS("\u2662");
    private String suitC;
    
    private Suit(String suitC) {
    	this.suitC = suitC;
    }
    
    public String getSuitC() {
    	return suitC;
    }
}

