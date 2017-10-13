package sparrow;

public class Dove extends Sparrow{

	public Dove(String nation, String sing, String add, String name, String birth) {
		super(nation, sing, add, name, birth);
	}

	@Override
	public void getSound() {
		System.out.println(nation+" "+add+" "+" "+name+"("+birth+")"+sing);
	}

}
