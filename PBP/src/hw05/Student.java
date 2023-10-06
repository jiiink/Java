package hw05;

public class Student {
	private String name ;
	private int year ;

	// other methods including constructor,
	// toString(), equals(), hashCode()
	Student(String name, int year) {
		this.name = name;
		this.year = year;
	}
	public String toString() {
		String msg = "[" + this.name + ", " + this.year + "학년]";
		return msg;
	}
	public boolean equals(Student other) {
		return this.name.equals(other.name) && this.year == other.year;
	}
	public int hashCode() {
		var hash = 0;
		for (int i=0; i<name.length(); i++) {
			hash = 31 * hash + name.charAt(i);
		}
		hash += year * 10;
		return hash;
	}
}