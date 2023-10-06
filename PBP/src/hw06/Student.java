package hw06;

public class Student {
    private final String name ;
	private int year ;
	private final School theSchool ;
	
    Student(School theSchool, String studentName, int schoolYear) {
        this.theSchool = theSchool;
        this.name = studentName;
        this.year = schoolYear;
    }
    Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.theSchool = null;
    }
    public String toString() {
        String information = "";
        //[Name: James, School:PNU, 1학년]
        information += "[Name: " + this.name + ", School:" + this.theSchool.getName() + ", " + this.year + "학년]"; 
        return information;
    }
    public boolean equals(Student other) {
        return name.equals(other.name) && year == other.year;
    }
    public int hashCode() {
        int hashCode = 0;
        return hashCode;
    }
}
