package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> h = new ArrayList<>();
	private int total;
	
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
	
	public void total () {
		int value = 0;
		for (int i = 0; i < h.size(); i ++) {
			value = value + h.get(i).getValue();
		}
		total = value;
	}
	
	public void setValue (int i) {
		total = i;
	}

	public List<Card> getCards() {
		return h;
	}
	
	public Card getCard(int i) {
		return h.get(i);
	}

	public List<Card> getH() {
		return h;
	}

	public void setHand(List<Card> h) {
		this.h = h;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal() {
		return total;
	}
	
	
	
}
