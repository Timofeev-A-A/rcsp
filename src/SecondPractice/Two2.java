package SecondPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Two2 {
    public static void copyFile(File src, File dest) throws IOException {
        try (FileChannel sourceChannel = new FileInputStream(src).getChannel();
             FileChannel destChannel = new FileOutputStream(dest).getChannel()) {
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        }
    }

    public static void main(String[] args)
    {
        File from = new File("src/SecondPractice/copySource.txt");
        File to = new File("src/SecondPractice/copy2.txt");
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
