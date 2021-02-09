import java.util.Objects;

public class Student {

    private String name; // ім’я, прізвище
    private String index; // номер залікової книжки
    private double gpa; //середній бал
    private Faculty faculty; // факультет
    public FormOfEnroll formOfEnroll; // форма навчання

    public Student(String name, String markBookIndex, double gpa, Faculty faculty, FormOfEnroll formOfEnroll) {
        this.name = name;
        this.index = markBookIndex;
        this.gpa = gpa;
        this.faculty = faculty;
        this.formOfEnroll = formOfEnroll;
        this.faculty.add(this);
    }


    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getIndex() {
        return index;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equalsIgnoreCase(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Вся информация о студенте:" +
                "\nФИО: " + this.name +
                "\nИнститут: " + faculty.getInstitute().getName() +
                "\nФакультет: " + faculty.getName() +
                "\nНомер студенческого: " + this.index +
                "\nСредний балл: " + this.gpa +
                "\nФорма навчання: " + this.formOfEnroll;
    }
}
