package students;

public class Student {
	private static int cnt=1;
	
	private int number;
	private String name;
	private String address;
	private String telnumber; 
	
	public int getNumber(){
		return number;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public Student(String name, String address, String telnumber) {
		number = cnt++;
		this.name = name;
		this.address = address;
		this.telnumber = telnumber;
	}
	
	public Student(){
		number = cnt++;
	}

}
