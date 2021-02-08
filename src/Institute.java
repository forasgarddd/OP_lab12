import java.util.HashSet;
import java.util.Iterator;

public class Institute{
    //1 замена
    //   private static HashMap<String,String> facult_inst = new HashMap<>();

    private HashSet<Faculty> faculties = new HashSet<>();
    private final String NAME;

    public Institute(String name, HashSet<Faculty> faculties) {
        this.faculties = faculties;
        this.NAME = name;
    }

    public Institute(String name) {
        this.NAME = name;
    }



    public String getName() {
        return NAME;
    }


    public void add(Faculty faculty) {
        try {
            for (Faculty facult : faculties) {
                if (facult.equals(faculty)) {
                    throw new IllegalArgumentException("Этот факультет уже принадлежит институту");
                }
            }
            faculties.add(faculty);
        }catch (IllegalArgumentException exc){
            System.out.println("Помилка! "+ exc.getMessage());
        }
    }
    // Функция которая считает сколько всего учится студентов Задание 1)
    public int countStudents() {
        int quantity = 0;
        Iterator iterator = faculties.iterator();
        while (iterator.hasNext()) {
            quantity += ((Faculty)iterator.next()).countStudents() ;
        }
        return quantity;
    }

    // Функция которая смотрит где больше всего студентов Задание 2)
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
            System.out.println(answer.getName());
        }catch(RuntimeException exc){
            System.out.println("Помилка! "+ exc.getMessage());
        }
    }

    // Фукнция которая ищет лучших студентов Задание 3)
    public void showBestStudents() {
        try {
            HashSet<String> bestStudents = new HashSet<>();
            for (Faculty faculty : faculties) {
                for (Student student : faculty.getStudents()) {
                    if (student.getGPA() >= 95) {
                        bestStudents.add(student.getName());
                    }
                }
            }
            if (bestStudents.size() == 0)
                throw new IllegalArgumentException("Нет студентов с высокими баллами");
            System.out.println(bestStudents);
        }catch (IllegalArgumentException exc){
            System.out.println("Помилка! "+ exc.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Информация о Институте:" +
                "\nНазвание: " + NAME +
                "\nКоличество учеников: " +countStudents();
    }
}