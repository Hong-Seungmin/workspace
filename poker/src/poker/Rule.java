package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Rule {
	private ArrayList<Card> list;

	public String check() {
		if (checkRoyalFlush()) {
			return "RoyalFlush";
		} else if (checkStraightFlush()) {
			return "StraightFlush";
		} else if (checkFourCard()) {
			return "FourCard";
		} else if (checkFullHouse()) {
			return "FullHouse";
		} else if (checkFlush()) {
			return "Flush";
		} else if (checkStraight()) {
			return "Straight";
		} else if (checkTriple()) {
			return "Triple";
		} else if (checkTwoPair()) {
			return "TwoPair";
		} else if (checkOnePair()) {
			return "OnePair";
		} else {
			return checkTop();
		}
	}

	public Rule(ArrayList<Card> list) {
		this.list = list;
	}

	private String checkTop() {
		sort();
		return list.get(list.size() - 1).getSuit() + " " + list.get(list.size() - 1).getNumber() + " TOP";
	}

	private boolean checkOnePair() {
		if (cntNumber().equals("OnePair"))
			return true;
		else
			return false;
	}

	private boolean checkTwoPair() {
		if (cntNumber().equals("TwoPair"))
			return true;
		else
			return false;
	}

	private boolean checkTriple() {
		if (cntNumber().equals("Triple"))
			return true;
		else
			return false;
	}

	private boolean checkStraight() {
		if (checkSequence())
			return true;
		else
			return false;
	}

	private boolean checkFlush() {
		if (cntSuit() > 5)
			return true;
		else
			return false;
	}

	private boolean checkFullHouse() {
		if (cntNumber().equals("FullHouse"))
			return true;
		else
			return false;
	}

	private boolean checkFourCard() {
		if (cntNumber().equals("FourCard"))
			return true;
		else
			return false;
	}

	// 미구현
	private boolean checkStraightFlush() {
		if (checkFlush())
			if (checkStraight())
				return true;

		return false;
	}

	// 미구현
	private boolean checkRoyalFlush() {
		if (checkFlush())
			if (checkStraight())
				return true;

		return false;
	}

	// one,twopair,triple,fourcard 검사
	private String cntNumber() {
		int cnt[] = { 0, 0, 0 };
		int index = 0;
		boolean flag = false;

		sort();

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getNumber().equals(list.get(i + 1).getNumber())) {
				cnt[index]++;
				flag = true;
			} else {
				if (flag) {
					index++;
					flag = false;
				}
			}
		}

		int four = 0;
		int tri = 0;
		int one = 0;

		for (int i = 0; i < 3; i++) {
			if (cnt[i] == 3)
				four++;
			if (cnt[i] == 2)
				tri++;
			if (cnt[i] == 1)
				one++;
		}

		// 포카드
		if (four > 0)
			return "FourCard";

		// 풀하우스
		if ((one > 0 && tri > 0) || (tri > 1))
			return "FullHouse";

		// 트리플
		if (tri > 0)
			return "Triple";

		// 투페어
		if (one > 1)
			return "TwoPair";

		// 원페어
		if (one > 0)
			return "OnePair";

		return "NoPair";
	}

	// 같은 무늬
	private int cntSuit() {
		int cnt = 0;
		int max = 0;

		for (int i = 0; i < list.size(); i++) {
			if (cnt > max)
				max = cnt;
			cnt = 0;

			for (int j = i; j < list.size(); j++) {
				if (list.get(i).getSuit().equals(list.get(j).getSuit()))
					cnt++;
			}
		}

		return max;
	}

	// 연속된 숫자
	private boolean checkSequence() {
		int cnt = 0;
		boolean[] flag = { false, false, false, false }; // 연속될 경우 true

		sort();

		for (int i = 0; i < list.size() - 1; i++) {
			if ((Integer.parseInt(list.get(i).getNumber()) == Integer.parseInt(list.get(i + 1).getNumber()) - 1)) {
				flag[cnt++] = true;
			} else if (Integer.parseInt(list.get(i).getNumber()) == Integer.parseInt(list.get(i + 1).getNumber()))
				;
			else
				cnt = 0;

			if (flag[3])
				return true;
		}

		return false;
	}

	private void sort() {
		Collections.sort(list, new Comparator<Card>() {
			@Override
			public int compare(Card src, Card dest) {
				return Integer.parseInt(src.getNumber()) - Integer.parseInt(dest.getNumber());
			}
		});
	}
}
