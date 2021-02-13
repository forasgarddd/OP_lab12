public class SameFormOfEnrollException extends Exception{

    private String name;

    public String getName() {
        return name;
    }

    public SameFormOfEnrollException(String message, Student student) {
        super(message);
        name = student.getName();
    }



}
