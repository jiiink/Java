package hw06;
import java.util.*;

public class School {
    private final String name ;
	private List<Student> students = new ArrayList<>() ;

	public School(final String name) { this.name = name ; }
	
    public void addStudent(Student student) {
        students.add(student);
    }
    public boolean equals(School other) {
        return name.equals(other.name);
    } 
    public int hashCode() {
        int hashCode = 0;
        return hashCode;
    }
    public String getName() {
        return this.name;
    } 
    public Student findStudent(String name, int year) {
        Student findStudent = new Student(name, year);
        for (Student student : students) {
            if (student.equals(findStudent)) {
                return student;
            }
        }
        return null;
    }
    public String allStudents() {
        String line = "";
        for (Student s : students) {
            line += s.toString() + "\n";
        }
        return line;
    }
    public List<Student> getStudents() {
        return students;
    }
}
