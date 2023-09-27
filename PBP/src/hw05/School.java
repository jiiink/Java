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
	public School(String name, int limit) {
		this.name = name;
		this.limit = limit;
		this.students = new Student[limit];
		this.studentCount = 0; 
	}
	public void addStudent(Student student) {
		students[studentCount] = student;
		studentCount++;
	}
	public void removeAllStudent() {
		studentCount = 0;
		for (int i=0; i<studentCount; i++) {
			students[i] = null;
		}
	}
	public Student findStudent(String studentName, int schoolYear) {
//		for (Student student : students) {
//			if (student.getName().equals(studentName) && student.getYear() == schoolYear) {
//				return student;
//			}
//		}
		for (int i=0; i<studentCount; i++) {
			if (students[i].getName().equals(studentName) && students[i].getYear() == schoolYear) {
				return students[i];
			}
		}
		return null;
	}
}
