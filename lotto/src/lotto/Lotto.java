package lotto;

import java.util.HashSet;
import java.util.Iterator;

public class Lotto {
	private HashSet<Integer> numbers;

	private void extraction(){
		int cnt = 0;
		int number;

		while (cnt < 6) {
			number = (int) (Math.random() * 45) + 1;
			if (numbers.contains(number))
				;
			else {
				numbers.add(number);
				cnt++;
			}
		}		
	}
	
	private void print(){
		Iterator<Integer> i = numbers.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
	
	public void runrun() {
		extraction();
		print();
	}
	
	public Lotto() {
		numbers = new HashSet<Integer>();
	}

	public static void main(String[] args) {
		new Lotto().runrun();
	}

}
