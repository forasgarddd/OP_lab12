public class Lab13 {

    public static void main(String[] args) {

        Institute kpi = new Institute("KPI");
        Institute sheva = new Institute("SHEVA");


        Faculty kubik = new Faculty("FICT",sheva);
        Faculty fict = new Faculty("FICT",kpi);
        Faculty ipsa = new Faculty("IPSA",kpi);


        Student student = new Student("Олександр Бражник","000001",76.1,fict, FormOfEnroll.BUDGET);
        Student student1 = new Student("Іван Девіцький","000002",67.7,fict, FormOfEnroll.CONTRACT);
        Student student2 = new Student("Віталій Кривоносюк","000003",96.5,ipsa, FormOfEnroll.BUDGET);
        Student student3 = new Student("Володимир Зеленський", "000004", 89.3,kubik, FormOfEnroll.CONTRACT);
        Student student4 = new Student("Олексій Навальний", "000005", 99.2, ipsa, FormOfEnroll.BUDGET);

        changeFormOfEnrollChanger(student, FormOfEnroll.CONTRACT);
       // System.out.println(student.toString());
        changeFormOfEnrollChanger(student, FormOfEnroll.CONTRACT);
        //System.out.println(student.toString());

    }

    public static void changeFormOfEnrollChanger (Student student, FormOfEnroll form) {
        try {
            student.changeFormOfEnroll(form);
        } catch (SameFormOfEnrollException e) {
            System.out.println("Студент " + student.getName()+ " " + e.getMessage());
        } finally {
            System.out.println(student.getName() + " вчиться на формі навчання: " + student.getFormOfEnroll());
        }
    }
}
