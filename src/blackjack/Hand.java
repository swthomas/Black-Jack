package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> h = new ArrayList<>();
	int value;
	
	public void showCards () {
		for (int i = 0; i < h.size(); i++) {
			System.out.println(h.get(i));
		}
	}
	
	public void showOneCard (int i) {
			System.out.println(h.get(i));
	}
	
	public void addCard (Card c) {
		h.add(c);
	}
	
	public int getTotal () {
		int value = 0;
		for (int i = 0; i < h.size(); i ++) {
			value = value + h.get(i).getValue();
		}
		return value;
	}
	
	public void setValue (int i) {
		value = i;
	}

	public List<Card> getCards() {
		return h;
	}
}
