import java.io.*;
import java.util.*;

public class ClassListReader {

    public static List<Student> readFromFile(String filename) throws IOException {
        List<Student> studenten = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s+", 2); // nur 2 Teile: Nachname + Vorname
                    if (parts.length == 2) {
                        studenten.add(new Student(parts[0], parts[1]));
                    } else {
                        System.out.println("Ungültige Zeile in Klassenliste: " + line);
                    }
                }
            }
        }
        return studenten;
    }
}
