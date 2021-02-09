import java.util.HashSet;
import java.util.Iterator;

public class Institute {

    private HashSet<Faculty> faculties = new HashSet<>();
    private String name;

    public Institute(String name, HashSet<Faculty> faculties) {
        this.faculties = faculties;
        this.name = name;
    }

    public Institute(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void add(Faculty faculty) {
        try {
            for (Faculty facult : faculties) {
                if (facult.equals(faculty)) {
                    throw new IllegalArgumentException("Этот факультет уже принадлежит институту");
                }
            }
            faculties.add(faculty);
        } catch (IllegalArgumentException exc) {
            System.out.println("Помилка! " + exc.getMessage());
        }
    }

    // Метод рахує загальну кілкість студентів Задание 1)
    public int countStudents() {
        int quantity = 0;
        Iterator iterator = faculties.iterator();
        while (iterator.hasNext()) {
            quantity += ((Faculty) iterator.next()).countStudents();
        }
        return quantity;
    }

    // Метод шукає факультет з найбільшою кілкістю студентів Задание 2)
    public void showMostStudentsFaculty() {
        try {
            Faculty answer = null;
            Iterator<Faculty> iterator = faculties.iterator();
            int tempStudents = 0;
            while (iterator.hasNext()) {
                Faculty tempFaculty = iterator.next();
                if (tempFaculty.countStudents() > tempStudents) {
                    tempStudents = tempFaculty.countStudents();
                    answer = tempFaculty;
                }
            }
            if (answer == null)
                throw new RuntimeException("Количество факультетов равно 0 или количество студентов на факультетах 0");
            System.out.println("Найбільша кількість студкентів на факультеті: " + answer.getName());
        } catch (RuntimeException exc) {
            System.out.println("Помилка! " + exc.getMessage());
        }
    }

    // Метод шукає кращих студентів Задание 3)
    public void showBestStudents() {
        try {
            HashSet<String> bestStudents = new HashSet<>();
            for (Faculty faculty : faculties) {
                for (Student student : faculty.getStudents()) {
                    if (student.getGpa() >= 95) {
                        bestStudents.add(student.getName());
                    }
                }
            }
            if (bestStudents.size() == 0)
                throw new IllegalArgumentException("Нет студентов с высокими баллами");
            System.out.println(bestStudents);
        } catch (IllegalArgumentException exc) {
            System.out.println("Помилка! " + exc.getMessage());
        }
    }

    // Метод переводить студента на іншу форму навчання в інституті

    public void changeFormOfEnroll(Student student, FormOfEnroll form) throws SameFormOfEnrollException {
        try {
            if (student.formOfEnroll == form) {
                throw new SameFormOfEnrollException("вже навчається на даній формі навчання", student);
            }
            student.formOfEnroll = form;
        } catch (SameFormOfEnrollException exc) {
            System.out.println("Помилка! " + exc.getName() + " " + exc.getMessage());
        }

    }

    @Override
    public String toString() {
        return "Информация о Институте:" +
                "\nНазвание: " + name +
                "\nКоличество учеников: " + countStudents();
    }
}