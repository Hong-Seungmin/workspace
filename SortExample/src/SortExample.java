import java.util.Arrays;

public class SortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE = 10;
		int[] numbers = new int[SIZE];
		int[] numberss = new int[args.length];

		/*
		for (int i = 0; i < SIZE; i++) {
			int r = (int) (Math.random() * 100);
			numbers[i] = r;
		}
*/
		for (int i = 0; i < args.length; i++) {
			int r = Integer.valueOf(args[i]);
			numberss[i] = r;
		}
		
		System.out.print("������ ����Ʈ: ");
		for (int r : numberss)
			System.out.print(r + " ");

		Arrays.sort(numberss);

		System.out.print("\n���ĵ� ����Ʈ: ");
		for (int r : numberss)
			System.out.print(r + " ");
	}

}
