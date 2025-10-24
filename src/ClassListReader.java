import java.io.*;
import java.util.*;

public class ClassListReader {

    public static List<Student> readFromFile(String filename) throws IOException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s+", 2); // Only 2 parts: last name + first name
                    if (parts.length == 2) {
                        students.add(new Student(parts[0], parts[1]));
                    } else {
                        System.out.println("Invalid line in class list: " + line);
                    }
                }
            }
        }
        return students;
    }
}
