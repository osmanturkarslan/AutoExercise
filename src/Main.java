import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Student> studenten = ClassListReader.readFromFile("C:\\test\\student_list.txt");
            System.out.println("Gelesene Studenten:");
            for (Student s : studenten) {
                System.out.println("- " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
