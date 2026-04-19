package voskrecasepunc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecasepuncTest {
    public static void main(String[] args) {

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c",
                    "docker run --rm -v /home/veles/vosk-recasepunc-ru-0.22/test.txt:/app/vosk-recasepunc-ru-0.22/test2.txt case python3 example.py test2.txt");
            Process process = processBuilder.start();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            int exitCode = process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}