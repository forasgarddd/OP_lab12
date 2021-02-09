import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Faculty {
    private String name;
    private Institute institute;
    private HashSet<Student> students = new HashSet<>();
    private HashMap<String,String> student_index = new HashMap<>();

    public Faculty(String name, Institute institute, HashSet<Student> students) {
        this.name = name;
        this.institute = institute;
        this.students = students;
        this.institute.add(this);
    }

    public Faculty(String name, Institute institute) {
        this.name = name;
        this.institute = institute;
        this.institute.add(this);
    }

    public void add(Student student) {
        try {
            for (Student studen : students) {
                if (studen.equals(student)) {
                    throw new IllegalArgumentException("Этот студент уже учится на факультете");
                }
            }
            students.add(student);
            student_index.put(student.getName().toUpperCase(),student.getIndex());
        }catch (IllegalArgumentException exc){
            System.out.println("Помилка! " + exc.getMessage());
        }
    }
    public void getIndexbyStudent(String studentName){
        try {
            var answer = student_index.get(studentName.toUpperCase());
            if (answer == null)
                throw new IllegalArgumentException("Этот студент тут не учится");
            System.out.println("Студент: "+ studentName + " Номер зачетки: " +answer);
        }catch(IllegalArgumentException exc){
            System.out.println("Помилка! "+ exc.getMessage());
        }
    }


    public Institute getInstitute() { return institute; }

    public String getName() { return name; }

    public HashSet<Student> getStudents() {
        return students;
    }

    public int countStudents() {
        return students.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return name.equalsIgnoreCase(faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public String toString() {
        return "Информация о факультете:" +
                "\nНазвание: " + name +
                "\nКоличество учеников: " +countStudents();
    }
}
