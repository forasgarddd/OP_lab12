public class Lab13 {

    public static void main(String[] args) throws SameFormOfEnrollException {

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


        student.changeFormOfEnroll(FormOfEnroll.CONTRACT);
       // System.out.println(student.toString());
        student.changeFormOfEnroll(FormOfEnroll.BUDGET);
        //System.out.println(student.toString());

    }
}
