package SecondPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class One {
    public static void readAsBytes(Path filePath) {
        if (Files.exists(filePath)) {
            try {
                byte[] bytes = Files.readAllBytes(filePath);
                String text = new String(bytes, StandardCharsets.UTF_8);
                System.out.println(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void readAsLines (Path filePath) {
        if (Files.exists(filePath)) {
            try {
                List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
                for (String line: lines) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        Path path = Paths.get("src/SecondPractice/oneFile.txt");
        //readAsBytes(path);
        readAsLines(path);
    }
}
