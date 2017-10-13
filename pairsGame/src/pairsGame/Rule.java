package pairsGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Rule {
	private ArrayList<Card> list;

	private void sort() {
		Collections.sort(list, new Comparator<Card>() {
			@Override
			public int compare(Card src, Card dest) {
				return Integer.parseInt(src.getNumber()) - Integer.parseInt(dest.getNumber());
			}
		});
	}
}
