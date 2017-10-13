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
			System.out.println(cal.get(Calendar.HOUR_OF_DAY)+"시"+cal.get(Calendar.MINUTE)+"분"+cal.get(Calendar.SECOND)+"초");
			break;
		case "-Hello":
			if(cal.get(Calendar.HOUR_OF_DAY)>18)
				System.out.println("굿이부닝");
			else if(cal.get(Calendar.HOUR_OF_DAY)>12)
				System.out.println("굿애푸터눈");
			else
				System.out.println("굿모닝");
			break;
		case "-h":
			System.out.println("파일명 -s 숫자 ==> 1~숫자 합");
			System.out.println("파일명 -p 숫자 ==> 1~숫자 곱");
			System.out.println("파일명 -d 숫자 ==> 현재시간");
			System.out.println("파일명 -Hello 숫자 ==> 시간대별 인사");
			break;
		}
	}
}
