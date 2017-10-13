package pairsGame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	String[] suit = {"1", "2", "3","4"};
	String[] number = {"2","3","4","5","6","7","8","9","10","1","11","12"};
	
	public Deck() {
		for(int i =0;i<suit.length;i++)
			for(int j = 0;j<number.length;j++)
				deck.add(new Card(suit[i],number[j]));
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	public Card deal(){
		return deck.remove(0);
	}
}
