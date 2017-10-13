package sample;

public class CommandLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args[0] == "*") {
			System.out.println(args[0]);
			System.out.println(args[1]);
			System.out.println(args[2]);
			System.out.println(args[3]);
			System.out.println(args[4]);
			System.out.println(args[5]);
		}
		if (args.length == 2) {

			switch (args[0]) {
			case "+":
				int sum = 0;
				for (int i = 1; i <= Integer.parseInt(args[1]); i++)
					sum += i;

				System.out.print(sum);
				break;

			case "-":
				double sum1 = 1.0;
				for (int i = 1; i <= Integer.parseInt(args[1]); i++)
					sum1 *= (double) i;

				System.out.print(sum1);
				break;
			default:
				System.out.println("부호(*,+) 숫자");

			}
		} else
			System.out.println("부호(*,+) 숫자");

	}

}
