import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Faculty {
    private final String NAME;
    private final Institute INSTITUTE;
    private HashSet<Student> students = new HashSet<>();
    private HashMap<String,String> student_index = new HashMap<>();

    public Faculty(String name, Institute institute, HashSet<Student> students) {
        this.NAME = name;
        this.INSTITUTE = institute;
        this.students = students;
        INSTITUTE.add(this);
    }

    public Faculty(String name, Institute institute) {
        this.NAME = name;
        this.INSTITUTE = institute;
        INSTITUTE.add(this);
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
    public Institute getInstitute() { return INSTITUTE; }

    public String getName() { return NAME; }

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
        return NAME.equalsIgnoreCase(faculty.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME);
    }


    @Override
    public String toString() {
        return "Информация о факультете:" +
                "\nНазвание: " + NAME +
                "\nКоличество учеников: " +countStudents();
    }
}
