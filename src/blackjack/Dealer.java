package blackjack;

public class Dealer extends Player {

	Dealer(String name, Hand hand) {
		super(name, hand);
	}

	public boolean hitStay() {
		boolean hitStay;
		if (getHand().getTotal() <= 16) {
			return true;
		}
		else return false;	
	}
}