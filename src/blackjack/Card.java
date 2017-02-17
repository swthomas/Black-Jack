package blackjack;

public class Card implements Comparable<Card>{
    private Rank rank;
    private Suit suit;

    public Card(Rank r, Suit s) {
        rank = r;
        suit = s;
    }

    @Override
    public String toString() {
        return (rank + " of " + suit).toLowerCase();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result
                + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (rank != other.rank)
            return false;
        if (suit != other.suit)
            return false;
        return true;
    }

	@Override
	public int compareTo(Card o) {
		
		if ( this.rank.compareTo(o.rank) == 0) {
			return this.suit.compareTo(o.suit);
		}
		else {
			return this.rank.compareTo(o.rank);
		}
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
}