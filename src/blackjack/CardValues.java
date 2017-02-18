package blackjack;

import java.util.HashMap;
import java.util.Map;

public class CardValues {
	final static Map <Rank, Integer> map = new HashMap<>();
	
	static {
		map.put(Rank.ACE, 11);
		map.put(Rank.KING, 10);
		map.put(Rank.QUEEN, 10);
		map.put(Rank.JACK, 10);
		map.put(Rank.TEN, 10);
		map.put(Rank.NINE, 9);
		map.put(Rank.EIGHT, 8);
		map.put(Rank.SEVEN, 7);
		map.put(Rank.SIX, 6);
		map.put(Rank.FIVE, 5);
		map.put(Rank.FOUR, 4);
		map.put(Rank.THREE, 3);
		map.put(Rank.TWO, 2);
	}
	
	public static int getValue(Rank r) {
		int value = map.get(r);
		return value;
	}
	
}
