package pairsGame;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	private ArrayList<Card> list = new ArrayList<Card>();

	public ArrayList<Card> getList() {
		return list;
	}

	public void getCard(Card card) {
		list.add(card);
	}

	public void showCards() {
		Iterator<Card> i = list.iterator();
		Card card;

		for (int j = 0; i.hasNext(); j++) {
			card = i.next();
			if ((j < 3) || (j == 6))
				System.out.print("[XX XX]");
			else
				System.out.print("[" + card.getSuit() + " " + converter(card.getNumber()) + "]");
		}
		System.out.println();
	}

	public void openCards() {
		for (Card i : list)
			System.out.print("[" + i.getSuit() + " " + converter(i.getNumber()) + "]");
		System.out.println();
	}

	private String converter(String src) {
		switch (src) {
		case "1":
			return "A";

		case "11":
			return "J";

		case "12":
			return "Q";

		case "13":
			return "K";
		}
		return src;
	}
}
