package sparrow;

import java.util.Random;

public class Start {
	private ASparrow usaSparrow;
	private CSparrow chinaSparrow;
	private USparrow europeSparrow;
	private KSparrow koreaSparrow;
	
	private Sparrow[] sparrows;
	
	private Random random;
	
	public Start(){
		createObject();
	}
	
	private void createObject(){
		random = new Random();
		sparrows = new Sparrow[4];
		
		usaSparrow = new ASparrow();
		chinaSparrow = new CSparrow();
		europeSparrow = new USparrow();
		koreaSparrow = new KSparrow();
		
		sparrows[0] = usaSparrow;
		sparrows[1] = chinaSparrow;
		sparrows[2] = europeSparrow;
		sparrows[3] = koreaSparrow;
	}
	
	public void randomSound(){
		sparrows[random.nextInt(4)].getSound();
	}
}
