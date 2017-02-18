package blackjack;

import java.util.Scanner;

public class Game {
	Scanner kb = new Scanner(System.in);
	Hand dH = new Hand();
	Hand pH = new Hand();
	Player p = new Player("You", pH);
	Dealer d = new Dealer("Dealer", dH);
	Deck deck = new Deck();

	public void startGame() {
		deck.createDeck();
		firstDeal();

	}

	public void firstDeal() {
		for (int i = 0; i < 2; i++) {
			p.getHand().addCard(deck.dealCard());
			d.getHand().addCard(deck.dealCard());
		}
		showCards();
		checkCardsFirst();
	}

	public void showCards() {
		System.out.println("Your Cards:");
		System.out.println("************");
		p.getHand().showCards();
		System.out.println("************");
		System.out.println("Total: " + p.getHand().getTotal());
		System.out.println("************");
		System.out.println("");

		System.out.println("Dealer Cards: ");
		System.out.println("************");
		d.getHand().showOneCard(1);
		System.out.println();

	}

	public void checkCardsFirst() {
		if (p.getHand().getTotal() == 21 & d.getHand().getTotal() == 21) {
			System.out.println("Push!");
			System.exit(0);
		} else if (d.getHand().getTotal() == 21) {
			System.out.println("Dealer has 21");
			System.exit(0);
		} else if (p.getHand().getTotal() == 21) {
			System.out.println("*** Winner Winner Chicken Dinner ***");
			System.out.println("       *** You have 21 ***");
			System.exit(0);
		} else {
			nextDeal();
		}
	}

	public void checkCardsMid() {
		if (d.getHand().getTotal() > 21) {
			System.out.println("|| *** You Win *** ||");
			System.out.println();
			System.out.println("Dealer had: " + d.getHand().getTotal());
			System.out.println("You had: " + p.getHand().getTotal());
		}
		else if (p.getHand().getTotal() < d.getHand().getTotal()) {
			System.out.println("|| ~~~ You Lose ~~~ ||");
			System.out.println();
			System.out.println("Dealer had: " + d.getHand().getTotal());
			System.out.println("You had: " + p.getHand().getTotal());
		} else if (p.getHand().getTotal() > d.getHand().getTotal()) {
			System.out.println("|| *** You Win *** ||");
			System.out.println();
			System.out.println("Dealer had: " + d.getHand().getTotal());
			System.out.println("You had: " + p.getHand().getTotal());
		} else {
			System.out.println("|| --- Push --- ||");
			System.out.println();
			System.out.println("Dealer had: " + d.getHand().getTotal());
			System.out.println("You had: " + p.getHand().getTotal());
		}
	}

	public void nextDeal() {
		String hit;
		System.out.print("Hit or Stay (h/s): ");
		hit = kb.next();
		System.out.println();

		while (hit.equals("h")) {
			checkAce();
			p.getHand().addCard(deck.dealCard());
			
			if (p.getHand().getTotal() > 21) {
				System.out.println("BUST!!!! BUST!!!! BUST!!!! BUST!!!! BUST!!!!");
				System.out.println();
				showCards();
				System.out.println();
				System.out.println("BUST!!!! BUST!!!! BUST!!!! BUST!!!! BUST!!!!");
				System.exit(0);
			}

			while (!hit.equals("h") && !hit.equals("s")) {
				System.out.println("Does not Compute!!!");
				System.out.println("ONLY (h) or (s): ");
				hit = kb.next();
				System.out.println("");
			}

			showCards();

			System.out.print("Hit or Stay (h/s): ");
			hit = kb.next();
			System.out.println();
		}

		DealerHit();

	}
	
	public void checkAce() {
		String highLow;
		if (p.getHand().getCards().contains(Rank.ACE)) {
			System.out.println("You have: " + p.getHand().getTotal() + " or " + (p.getHand().getTotal() - 10));
			System.out.println("High or Low (h/l): ");
			highLow = kb.next();

			while (!highLow.equals("h") && !highLow.equals("l")) {
				System.out.println("WRONG!!! (h/l): ");
				highLow = kb.next();
			}
			if (highLow.equals("l")) {
				p.getHand().setValue(p.getHand().getTotal() - 10);
			}
		}
	}

	public void DealerHit() {
		while (d.hitStay()) {
			d.getHand().addCard(deck.dealCard());
		}
		checkCardsMid();
	}

}
