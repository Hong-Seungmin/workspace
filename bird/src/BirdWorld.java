
import java.util.ArrayList;
import java.util.Random;

public class BirdWorld {
	private ArrayList<Bird> bird;
	private Random rd;
	
	public BirdWorld() {
		bird = new ArrayList<Bird>();
		rd = new Random();
		
		for(int i = 0; i<rd.nextInt(10)+10;i++){
			if(rd.nextInt(2)==0)
				bird.add(new Sparrow());
			else
				bird.add(new Dove());
		}
	}

	public void playSound(){
		while(true){
			bird.get(rd.nextInt(bird.size())).sing();
			
			try {
				Thread.sleep(rd.nextInt(600)+100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
