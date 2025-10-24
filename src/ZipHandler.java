import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipHandler {

    // Finds the first .zip file in the given folder
    private static File findFirstZipFile(String folderPath) throws IOException {
        File sourceDirectory = new File(folderPath);
        if (!sourceDirectory.exists() || !sourceDirectory.isDirectory()) {
            throw new IOException("Source directory not found: " + folderPath);
        }

        File[] zipFiles = sourceDirectory.listFiles((d, name) -> name.toLowerCase().endsWith(".zip"));
        if (zipFiles == null || zipFiles.length == 0) {
            throw new IOException("No .zip file found in: " + folderPath);
        }

        return zipFiles[0];
    }

    // Makes sure the target folder exists
    private static Path createTargetFolder(String folderPath) throws IOException {
        Path targetPath = Paths.get(folderPath);
        if (!Files.exists(targetPath)) {
            Files.createDirectories(targetPath);
        }
        return targetPath;
    }

    // Extracts all files from the given zip into the target folder
    private static void extractZip(File zipFile, Path targetPath) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                Path newFile = targetPath.resolve(entry.getName()).normalize();

                if (entry.isDirectory()) {
                    Files.createDirectories(newFile);
                } else {
                    Files.createDirectories(newFile.getParent());
                    Files.copy(zis, newFile, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    // Main function that coordinates everything
    public static Path extractFirstZip(String sourceFolder, String targetFolder) throws IOException {
        File zipFile = findFirstZipFile(sourceFolder);
        Path targetPath = createTargetFolder(targetFolder);
        extractZip(zipFile, targetPath);
        return targetPath;
    }
}
