package voskrecasepunc;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class RecasepuncTest {
    public static void main(String[] args) throws IOException {


//        // 1. Запустить контейнер
//        executeCommand("docker", "start", "case");
//
//        // 2. Выполнить скрипт внутри контейнера
//        String output = executeCommandAndGetOutput("docker", "exec", "case", "python3", "example.py", "test.txt");
//        System.out.println("Результат: " + output);
//
//        // 3. Остановить контейнер
//        executeCommand("docker", "stop", "case");
//    }
//
//    // Выполнить команду без получения вывода
//    private static void executeCommand(String... command) {
//        try {
//            ProcessBuilder pb = new ProcessBuilder(command);
//            pb.redirectErrorStream(true);
//            Process process = pb.start();
//            int exitCode = process.waitFor();
//            System.out.println("Команда выполнена, код: " + exitCode);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
////     Выполнить команду и получить вывод
//    private static String executeCommandAndGetOutput(String... command) {
//        StringBuilder output = new StringBuilder();
//        try {
//            ProcessBuilder pb = new ProcessBuilder(command);
//            pb.redirectErrorStream(true);
//            Process process = pb.start();
//
//            try (BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(process.getInputStream()))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    output.append(line).append("\n");
//                }
//            }
//
//            process.waitFor();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return output.toString();
//    }


//        try {
//
//
////  1           String fullCommand = "docker start case  "
////        List<String> commands = Arrays.asList("bash", "-c", fullCommand);
//            ProcessBuilder processBuilder = new ProcessBuilder("docker", "start", "case","docker", "exec", "case", "python3", "example.py", "test.txt","docker","stop","case");
//            processBuilder.command("docker", "exec", "case")
//                    .command("python3", "example.py", "test.txt")
//                    .command("docker","stop","case")
//            Process process = processBuilder.start();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//                //  1       Files.writeString(Path.of("TestText.txt"), line);
//
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {

            Process startContainer = new ProcessBuilder("docker", "start", "case").start();
            int startCode = startContainer.waitFor();
            if (startCode != 0) {
                System.out.println("не запустился контейнер");
            }
            System.out.println(startCode);
            Process process1 = new ProcessBuilder("docker", "exec", "case", "python3", "example.py", "test.txt").start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process1.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int codeProcess = process1.waitFor();
            if (codeProcess != 0) {
                System.out.println("чет не работает");
            }
            Process stopContainer = new ProcessBuilder("docker", "stop", "case").start();
            int stopCode = stopContainer.waitFor();
            if (startCode != 0) {
                System.out.println("работает, а не должен");
            }


//
//            List<Process> process = ProcessBuilder.startPipeline(builders);
//            Process last = process.get(process.size() - 1);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(last.getInputStream()));
//            String line;
//            while ((line= reader.readLine()) != null){
//                System.out.println(line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}