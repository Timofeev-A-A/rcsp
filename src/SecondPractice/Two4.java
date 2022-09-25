package SecondPractice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Two4 {
    private static void copyFile(File src, File dest) throws IOException {
        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args)
    {
        File from = new File("src/SecondPractice/copySource.txt");
        File to = new File("src/SecondPractice/copy4.txt");

        try {
            long startTime = System.nanoTime();
            copyFile(from, to);
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("File copied successfully.");
            System.out.println("Total execution in millis: " + elapsedTime/1000000);
            long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            System.out.println("Bytes used: " + usedBytes);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
