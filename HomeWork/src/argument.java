import java.util.Calendar;

public class argument {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tmp;
		Calendar cal = Calendar.getInstance();
		switch(args[0]){
		case "-s":
			tmp=0;
			for(int i=1; i<=Integer.parseInt(args[1]); i++)
				tmp+=i;
			System.out.println(tmp);
			break;
		case "-p":
			tmp=1;
			for(int i=1; i<=Integer.parseInt(args[1]); i++)
				tmp*=i;
			System.out.println(tmp);
			break;
		case "-d":
			System.out.println(cal.get(Calendar.HOUR_OF_DAY)+"��"+cal.get(Calendar.MINUTE)+"��"+cal.get(Calendar.SECOND)+"��");
			break;
		case "-Hello":
			if(cal.get(Calendar.HOUR_OF_DAY)>18)
				System.out.println("���̺δ�");
			else if(cal.get(Calendar.HOUR_OF_DAY)>12)
				System.out.println("�¾�Ǫ�ʹ�");
			else
				System.out.println("�¸��");
			break;
		case "-h":
			System.out.println("���ϸ� -s ���� ==> 1~���� ��");
			System.out.println("���ϸ� -p ���� ==> 1~���� ��");
			System.out.println("���ϸ� -d ���� ==> ����ð�");
			System.out.println("���ϸ� -Hello ���� ==> �ð��뺰 �λ�");
			break;
		}
	}
}
