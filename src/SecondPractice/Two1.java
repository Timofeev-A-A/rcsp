package SecondPractice;

import java.io.*;

public class Two1 {
    public static void copyFile(File src, File dest) throws IOException
    {
        try (InputStream is = new FileInputStream(src);
             OutputStream os = new FileOutputStream(dest))
        {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        }
    }

    public static void main(String[] args)
    {
        File from = new File("src/SecondPractice/copySource.txt");
        File to = new File("src/SecondPractice/copy1.txt");

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
