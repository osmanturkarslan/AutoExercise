import java.io.File;
import java.util.List;

public class SubmissionChecker {

    // Checks which students have submitted their assignment folders.
    public static void checkSubmissions(File baseFolder, List<Student> students) {
        if (baseFolder == null || !baseFolder.exists()) {
            System.err.println("Invalid folder: " + baseFolder);
            return;
        }

        // list all subfolders inside the base folder
        File[] subFolders = baseFolder.listFiles(File::isDirectory);
        if (subFolders == null) return;

        // check each subfolder
        for (File folder : subFolders) {
            String folderName = folder.getName();
            String[] parts = folderName.split("_");

            // folder must contain at least last name and first name
            if (parts.length >= 2) {
                String lastName = parts[0];
                String firstName = parts[1];

                // match with student list
                for (Student student : students) {
                    if (student.getLastName().equalsIgnoreCase(lastName) &&
                            student.getFirstName().equalsIgnoreCase(firstName)) {
                        student.setSubmitted(true);
                        break; // stop checking once a match is found
                    }
                }
            }
            // RECURSIVE CALL: check deeper folders as well
            checkSubmissions(folder, students);
        }
    }
}
