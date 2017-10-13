package pairsGame;

import java.util.Scanner;

public class PairsGame {
	private Deck deck;
	private Player p1;
	private Player p2;
	private Player p3;
	private Player p4;
	private Player p5;
	private Player p6;

	private Rule result1;
	private Rule result2;
	private Rule result3;
	private Rule result4;
	private Rule result5;
	private Rule result6;

	private Scanner scan;

	public PairsGame() {
		deck = new Deck();
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();
		p4 = new Player();
		p5 = new Player();
		p6 = new Player();

		result1 = new Rule(p1.getList());
		result2 = new Rule(p2.getList());
		result3 = new Rule(p3.getList());
		result4 = new Rule(p4.getList());
		result5 = new Rule(p5.getList());
		result6 = new Rule(p6.getList());
	}

	public void play() {
		deck.shuffle();

		for (int i = 0; i < 7; i++) {
			clean();
			dealAll();
			showCards();

			try {
				if (i > 3)
					Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
		}
		clean();
		openCards();
	}

	private void clean() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	private void openCards() {
		p1.openCards();
		System.out.println(result1.check());
		p2.openCards();
		System.out.println(result2.check());
		p3.openCards();
		System.out.println(result3.check());
		p4.openCards();
		System.out.println(result4.check());
		p5.openCards();
		System.out.println(result5.check());
		p6.openCards();
		System.out.println(result6.check());
	}

	private void showCards() {
		p1.showCards();
		p2.showCards();
		p3.showCards();
		p4.showCards();
		p5.showCards();
		p6.showCards();
	}

	private void dealAll() {
		p1.getCard(deck.deal());
		p2.getCard(deck.deal());
		p3.getCard(deck.deal());
		p4.getCard(deck.deal());
		p5.getCard(deck.deal());
		p6.getCard(deck.deal());
	}

	public static void main(String[] args) {
		new PairsGame().play();
	}
}
