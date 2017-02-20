package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	Scanner kb = new Scanner(System.in);
	Hand dH = new Hand();
	Hand pH = new Hand();
	Player p = new Player("You", pH);
	Dealer d = new Dealer("Dealer", dH);
	Deck deck = new Deck();
	boolean winLose = false;
	double bet;
	double wallet = 1000;
	String hit = "h";

	public void startGame() {
		System.out.println("      Welcome to the Jungle!");
		System.out.println("You start with 1000 in your wallet.");
		deck.createDeck();
		firstDeal();
	}

	public void firstDeal() {
		System.out.print("\t    Bet: ");
		bet = kb.nextInt();
		System.out.println();

		for (int i = 0; i < 2; i++) {
			p.getHand().addCard(deck.dealCard());
			p.getHand().total();
			d.getHand().addCard(deck.dealCard());
			d.getHand().total();
		}

		showCards();
		checkCardsFirst();
	}

	public void doubleDown() {
		System.out.println("|| Double Down || Hit || Stay ||");
		System.out.print("         -- d | h | s --            ");
		hit = kb.next();

		while (!hit.equals("d") && !hit.equals("h") && !hit.equals("s")) {
			System.out.println("Does not Compute!!!");
			System.out.print("ONLY || d | h | s || ONLY ");
			hit = kb.next();
		}

		if (hit.equals("d")) {
			bet = (bet * 2);
			p.getHand().addCard(deck.dealCard());
			p.getHand().total();
			System.out.println();
			DealerHit();
		} else {
			nextDeal();
		}
	}

	public void checkCardsFirst() {
		if (p.getHand().getTotal() == 21 && d.getHand().getTotal() == 21) {
			System.out.println("Push!");
			playAgain();
		} else if (d.getHand().getTotal() == 21) {
			System.out.println("Dealer has 21");
			wallet = (wallet - bet);
			playAgain();
		} else if (p.getHand().getTotal() == 21) {
			System.out.println("*** Winner Winner - Chicken Dinner ***");
			System.out.println("         *** You have 21 ***");
			wallet = (wallet + (bet * 1.5));
			playAgain();
		} else {
			doubleDown();
		}
	}

	public boolean checkForAce() {
		List<Card> checkForAce = new ArrayList<>();
		checkForAce.addAll(p.getHand().getCards());
		boolean ace = false;

		for (int i = 0; i < checkForAce.size(); i++) {
			if (checkForAce.get(i).getRank().equals(Rank.ACE)) {
				ace = true;
			}
		}
		return ace;
	}

	public void showCards() {
		p.getHand().total();

		if (checkForAce()) {
			printAce();
		} else {
			System.out.println("Your Cards:");
			System.out.println("************");
			p.getHand().showCards();
			System.out.println("************");
			System.out.println("Total: " + p.getHand().getTotal());
			System.out.println("");

			System.out.println("Dealer Cards: ");
			System.out.println("************");
			System.out.println(d.getHand().getCard(1));
			System.out.println("************");
			System.out.println("Total: " + d.getHand().getCard(1).getValue());
			System.out.println();
		}

	}

	public void printAce() {
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

	public void nextDeal() {

		while (hit.equals("h")) {

			p.getHand().addCard(deck.dealCard());

			if (checkForAce() == true && p.getHand().getTotal() > 21) {
				int total = p.getHand().getTotal() - 10;
				p.getHand().setTotal(total);
			}

			p.getHand().total();

			if (p.getHand().getTotal() > 21) {
				System.out.println();
				System.out.println("BUST!!!! BUST!!!! BUST!!!! BUST!!!! BUST!!!!");
				System.out.println();
				showFinalCards();
				System.out.println();
				System.out.println("BUST!!!! BUST!!!! BUST!!!! BUST!!!! BUST!!!!");
				wallet = (wallet - bet);
				playAgain();
			}

			showCards();

			System.out.print("Hit or Stay (h/s): ");
			hit = kb.next();
			System.out.println();

			while (!hit.equals("h") && !hit.equals("s")) {
				System.out.println("Does not Compute!!!");
				System.out.print("ONLY (h) or (s): ");
				hit = kb.next();
				System.out.println("");
			}
		}
		DealerHit();
	}

	public void DealerHit() {
		d.getHand().total();

		while (d.hitStay()) {
			d.getHand().addCard(deck.dealCard());
			d.getHand().total();
		}
		checkCardsFinal();
	}

	public void checkCardsFinal() {
		if (d.getHand().getTotal() > 21) {
			showFinalCards();
			System.out.println("|| *** You Win *** ||");
			System.out.println();
			System.out.println("Dealer had: " + d.getHand().getTotal());
			System.out.println("You had: " + p.getHand().getTotal());
			wallet = (wallet + bet);
			playAgain();
		} else if (p.getHand().getTotal() < d.getHand().getTotal()) {
			showFinalCards();
			System.out.println("|| ~~~ You Lose ~~~ ||");
			System.out.println();
			System.out.println("Dealer had: " + d.getHand().getTotal());
			System.out.println("You had: " + p.getHand().getTotal());
			wallet = (wallet - bet);
			playAgain();
		} else if (p.getHand().getTotal() > d.getHand().getTotal()) {
			showFinalCards();
			System.out.println("|| *** You Win *** ||");
			System.out.println();
			System.out.println("Dealer had: " + d.getHand().getTotal());
			System.out.println("You had: " + p.getHand().getTotal());
			wallet = (wallet + bet);
			playAgain();
		} else if (p.getHand().getTotal() > 21) {
			System.out.println();
			System.out.println("BUST!!!! BUST!!!! BUST!!!! BUST!!!! BUST!!!!");
			System.out.println();
			showFinalCards();
			System.out.println();
			System.out.println("BUST!!!! BUST!!!! BUST!!!! BUST!!!! BUST!!!!");
			wallet = (wallet - bet);
			playAgain();
		} else {
			showFinalCards();
			System.out.println("|| --- Push --- ||");
			System.out.println();
			System.out.println("You had: " + p.getHand().getTotal());
			System.out.println("Dealer had: " + d.getHand().getTotal());
			playAgain();
		}
	}

	public void showFinalCards() {
		System.out.println("Your Cards:");
		System.out.println("************");
		p.getHand().showCards();
		System.out.println("************");
		System.out.println("Total: " + p.getHand().getTotal());
		System.out.println("");

		System.out.println("Dealer Cards: ");
		System.out.println("************");
		d.getHand().showCards();
		System.out.println("************");
		System.out.println("Total: " + d.getHand().getTotal());
		System.out.println();
	}

	public void playAgain() {
		System.out.println();
		System.out.println("Wallet: " + wallet);
		System.out.print("Would you like to play again? ");
		System.out.print("(y or n)  ");
		String again = kb.next();

		while (!again.equals("y") && !again.equals("n")) {
			System.out.println("Does not Compute!!!");
			System.out.print("ONLY (y) or (n): ");
			again = kb.next();
			System.out.println("");
		}

		if (again.equals("y")) {
			resetPHand();
			resetDHand();
			firstDeal();
			checkCardsFirst();
			showCards();
		} else {
			System.err.println("Goodbye Sucka!!!");
			System.exit(0);
		}
	}

	public void resetPHand() {
		List<Card> reset = new ArrayList<>();
		p.getHand().setHand(reset);
	}

	public void resetDHand() {
		p.getHand().setHand(new ArrayList<>());
		p.getHand().total();
		d.getHand().setHand(new ArrayList<>());
		d.getHand().total();
	}
}
