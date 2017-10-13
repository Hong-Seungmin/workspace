package sparrow;

public abstract class Sparrow {	
	String nation;
	String sing;
	String add;
	String name;
	String birth;
	
	public Sparrow(String nation, String sing, String add, String name, String birth) {
		this.nation = nation;
		this.sing = sing;
		this.add = add;
		this.name = name;
		this.birth = birth;
	}

	public abstract void getSound();
}
