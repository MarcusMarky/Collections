import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
// Raspundeti la intrebarea - de ce cand declaram toString() in clasa, se zice ca de fapt noi il suprascriem ("override")?
// Deoarece toString() este mostenitoarea clasei Objesc
// Oricand o metoda cu aceeasi semnatura (nume și parametri) este definita într-o clasa derivata, aceasta suprascrie implementarea din clasa de baza.
    students.add(new Student("Bob Gray", "Math", 9.2f));
    students.add(new Student("Ashley Johnson", "Physics", 7.8f));
    students.add(new Student("Chester Wood", "Chemistry", 8.9f));
    students.add(new Student("Eva Ruiz", "Informatics", 7.0f));
    students.add(new Student("Johnny ", "Geography", 8.5f));
        
    int indexOfTheBest = 0;
        float maxGrade = students.get(0).grade;
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).grade > maxGrade) {
                maxGrade = students.get(i).grade;
                indexOfTheBest = i;
            }
        }

        ArrayList<Student> bestStudents = new ArrayList<Student>();
        for (Student student : students) {
            if (student.grade >= 8.0f) {
                bestStudents.add(student);
            }
        }

        System.out.println("The initial list:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nThe best students:");
        for (int i = 0; i < bestStudents.size(); i++) {
            Student student = bestStudents.get(i);
            if (i == indexOfTheBest) {
                student.grade += 0.1f; 
            }
            System.out.println(student);
        }
    }
static class Student {
    String fullname;
    String specialty;
    Float grade;
    
public Student(String fullname, String specialty, Float grade) {
            this.fullname = fullname;
            this.specialty = specialty;
            this.grade = grade;
        }
    
        @Override
public String toString() {
            return "Student " +
                    "fullname: " + fullname +  
                    ", specialty: " + specialty +
                    ", grade: " + grade ;
                    
        }
    }
}
