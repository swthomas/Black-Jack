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
	}
	
	void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
	
    }
}