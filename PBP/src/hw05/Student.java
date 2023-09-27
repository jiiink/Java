package hw05;

public class Student {
	private String name ;
	private int year ;

	// other methods including constructor,
	// toString(), equals(), hashcode()
	Student(String name, int year) {
		this.name = name;
		this.year = year;
	}
	public String toString() {
		String msg = "[" + this.name + ", " + String.valueOf(this.year) + "학년]";
		return msg;
	}
	public String getName() {
		return this.name;
	}
	public int getYear() {
		return this.year;
	}
}
