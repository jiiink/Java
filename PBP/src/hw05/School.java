package hw05;

public class School {
	private String name ;
	private int limit ;
	
	private Student[] students ;
	private int studentCount ;

	public String toString() {	
		String msg = "School Name: " + name + " Student Count: "
			+ studentCount + "\n" ;
		
		for ( int i = 0 ; i < studentCount ; i ++ ) {
			msg += "\t" + students[i] + "\n" ;
		}
		return msg ;
	}

	// other methods including constructor, equals(), hashCode()
	School(String name, int limit) {
		this.name = name;
		this.limit = limit;
		this.studentCount = 0;
		this.students = new Student[limit];
	}
	public boolean equals(School other) {
		if (this.studentCount == other.studentCount) {
			for (int i=0; i<this.studentCount; i++) {
				if (!this.students[i].equals(other.students[i])) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
		
	}
	public int hashCode() {
		var hash = 0;
		for (int i=0; i<this.studentCount; i++) {
			hash += students[i].hashCode();
		}
		return hash;
	}
	public void addStudent(Student student) {
		this.students[studentCount] = student;
		studentCount++;
	}
	public Student findStudent(String name, int year) {
		Student student = new Student(name, year);
		for (int i=0; i<studentCount; i++) {
			if (student.equals(students[i])) 
				return students[i];
		}
		return null;
	}
	public void removeAllStudent() {
		for (int i=0; i<studentCount; i++) {
			students[i] = null;
		}
		this.studentCount = 0;
	}
}