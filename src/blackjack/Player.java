package blackjack;

public class Player {
	private String name;
	private Hand hand;
	
	Player (String name, Hand hand) {
		this.name = name;
		this.hand = hand;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
	
}
