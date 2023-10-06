package hw06;
// import java.util.List;
import java.util.*;

public class SchoolManager {
    private List<School> schools = new ArrayList<>() ;
    

    public School findSchool(final String schoolName) {
        // School school = new School(schoolName);
        // schools.add(school);
        // return school;
        // School finding_school = new School(schoolName);
        for (School school : schools) {
            if (school.getName().equals(schoolName)) {
                return school;
            }
        }
        return null;
    }
    public School createSchool(final String schoolName) {
        School school = new School(schoolName);
        schools.add(school);
        return school;
    }
    public List<Student> findStudent(String name, int year) {
        List<Student> foundStudents = new ArrayList<>();
        for (School school : schools) {
            Student foundStudent = school.findStudent(name, year);
            if (foundStudent != null) {
                foundStudents.add(foundStudent);
            }
        }
        return foundStudents;
    }
    public void removeAllSchools() {
        schools.clear();
        // students of schools also clear ??
    }
    public String toString() {
        /*
        Total School Count: 2
        School Name: PNU Student Count: 1
        [Name: James, School:PNU, 1학년]

        School Name: SNU Student Count: 1
        [Name: James, School:SNU, 1학년]
        */
        String total = "";
        String first_line = "";
        String len = String.valueOf(schools.size());
        first_line += "Total School Count: " + len + "\n";
        total += first_line;
        if (schools.size() == 0) {
            return total;
        }
        for (School s : schools) {
            String second_line = "";
            String students_len = String.valueOf(s.getStudents().size());
            second_line += "School Name: " + s.getName() + " Student Count: " + students_len + "\n";
            second_line += s.allStudents() + "\n";
            total += second_line;
        }
        return total;
    }

}
