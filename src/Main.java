import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== Reading class list ===");
            List<Student> students = ClassListReader.readFromFile("C:\\test\\student_list.txt");
            System.out.println("Successfully read " + students.size() + " students:");
            for (Student s : students) {
                System.out.println("- " + s.getLastName() + " " + s.getFirstName());
            }

            System.out.println("\n=== Extracting ZIP ===");
            Path extractedPath = ZipHandler.extractFirstZip("C:\\test", "C:\\test\\unzipped_homeworks");
            System.out.println("Zip file extracted to: " + extractedPath);

            System.out.println("\n=== Checking submissions ===");
            File extractedFolder = extractedPath.toFile();
            SubmissionChecker.checkSubmissions(extractedFolder, students);

            System.out.println("\n=== Submission Summary ===");
            for (Student s : students) {
                System.out.println(s);
            }

            System.out.println("\n=== Process finished successfully ===");

        } catch (Exception e) {
            System.err.println("An error occurred during execution:");
            e.printStackTrace();
        }
    }
}
