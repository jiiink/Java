package hw06;
import java.util.*;

public class SchoolManager extends Object {
    private List<School> schools = new ArrayList<>() ;
    
    public School findSchool(final String schoolName) {
    	assert schoolName != null;
        for (School school : schools) {
            if (school.getName().equals(schoolName)) {
                return school;
            }
        }
        return null;
    }
    public School createSchool(final String schoolName) {
        final School school = new School(schoolName);
        assert school != null;
        schools.add(school);
        return school;
    }
    public List<Student> findStudent(final String name, final int year) {
        List<Student> foundStudents = new ArrayList<>();
        for (School school : schools) {
            final Student foundStudent = school.findStudent(name, year);
            if (foundStudent != null) {
                foundStudents.add(foundStudent);
            }
        }
        return foundStudents;
    }
    public void removeAllSchools() {
        schools.clear();
    }
    
    @Override
    public String toString() {
        String total_line = "";
        final String school_count = String.valueOf(schools.size());
        final String first_line = "Total School Count: " + school_count + "\n";
        total_line += first_line;
        if (schools.size() == 0) {
            return total_line;
        }
        for (School s : schools) {
            String second_line = "";
            final String students_len = String.valueOf(s.getStudents().size());
            second_line += "School Name: " + s.getName() + " Student Count: " + students_len + "\n";
            second_line += s.allStudents() + "\n";
            total_line += second_line;
        }
        return total_line;
    }
}
