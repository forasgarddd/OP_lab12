public class Lab10 {
    
    public static void main(String[] args) {
        Institute kpi = new Institute("KPI");
        Institute sheva = new Institute("SHEVA");
        Faculty nofict = new Faculty("FICT",sheva);
        Faculty fict = new Faculty("FICT",kpi);
        Faculty ipsa = new Faculty("IPSA",kpi);
        //  Faculty ipsa1 = new Faculty("ipsa",kpi);


        Student student = new Student("Sasha","123213",21.1,fict);
        Student student1 = new Student("Ivan","123212",21.7,ipsa);
        Student student2 = new Student("Vitaliy","123123",96.5,ipsa);
        //Student student3 = new Student("Sasha","123123",96.5,ipsa);
        //Student student4 = new Student("Sasha","123123",96.5,ipsa);
        //System.out.println(kpi.count());
        //System.out.println(kpi.get_max_Faculty());

        // ipsa.add(student);
        //ipsa.add(student);
        System.out.println(ipsa.countStudents());
        System.out.println(kpi.countStudents());
        //  System.out.println(kpi.bestStudents());

        //System.out.println(ipsa.equals(null));

        ipsa.getIndexbyStudent("Ivan");
        kpi.showBestStudents();
        Student student3 = new Student("Sassha","123213",221.1,fict);
        kpi.showMostStudentsFaculty();
        System.out.println(student.hashCode());


    }
}
