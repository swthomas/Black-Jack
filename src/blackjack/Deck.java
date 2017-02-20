package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> deck = new ArrayList<>(52);

	void createDeck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		Collections.shuffle(deck);
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	
	
	
}