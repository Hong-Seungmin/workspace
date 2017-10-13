
import java.util.Random;

public class Bird {
	protected String sound;
	protected String nation;

	{
		Random rd = new Random();
		
		switch (rd.nextInt(4)) {
		case 0:
			nation = "한국";
			break;
		case 1:
			nation = "미국";
			break;
		case 2:
			nation = "중국";
			break;
		case 3:
			nation = "일본";
			break;
		}
	}
	public Bird(String sound) {
		Random rd = new Random();

		for (int i = 0; i < rd.nextInt(5) + 1; i++)
			sound += sound;
		
		this.sound = sound;
	}

	public void sing() {
		System.out.println(nation + ":" + sound);
	}
}
